package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.enums.OrderStatus;
import br.com.pinkgreen.mkt.gateway.ProcessOrderCheckout;
import br.com.pinkgreen.mkt.gateway.PublishOrderStatusEvent;
import br.com.pinkgreen.mkt.gateway.SaveOrderGateway;
import br.com.pinkgreen.mkt.usecase.exception.InvalidStatusTransitionException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateAndPublishOrderEvent {

    private final FindOrderByIdUseCase findOrderByIdUseCase;
    private final SaveOrderGateway saveOrderGateway;
    private final PublishOrderStatusEvent publishOrderStatusEvent;

    public void execute(Integer orderId, OrderStatus newOrderStatus) throws InvalidStatusTransitionException {
        var order = findOrderByIdUseCase.execute(orderId);
        if (!order.getStatus().isAbleToChange(newOrderStatus)) {
            throw new InvalidStatusTransitionException(order.getStatus(), newOrderStatus);
        }
        order.setStatus(newOrderStatus);
        order.setUpdatedAt();

        saveOrderGateway.execute(order);
        publishOrderStatusEvent.publish(order);
    }
}
