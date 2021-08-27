package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.enums.OrderStatus;
import br.com.pinkgreen.mkt.gateway.PublishOrderStatusEvent;
import br.com.pinkgreen.mkt.gateway.SaveOrderGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateAndPublishOrderEvent {

    private final FindOrderByIdUseCase findOrderByIdUseCase;
    private final SaveOrderGateway saveOrderGateway;
    private final PublishOrderStatusEvent publishOrderStatusEvent;

    public void execute(String orderId, OrderStatus newOrderStatus) {
        var order = findOrderByIdUseCase.execute(orderId);
        order.setStatus(newOrderStatus);
        order.setUpdatedAt();

        saveOrderGateway.execute(order);
        publishOrderStatusEvent.publish(order);
    }
}
