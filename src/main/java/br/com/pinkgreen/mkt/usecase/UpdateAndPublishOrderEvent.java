package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.enums.OrderStatus;
import br.com.pinkgreen.mkt.gateway.PublishOrderStatusEvent;
import br.com.pinkgreen.mkt.gateway.SaveOrderGateway;
import br.com.pinkgreen.mkt.usecase.exception.InvalidStatusTransitionException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static br.com.pinkgreen.mkt.domain.ProductOrderDomain.getProductInfo;
import static br.com.pinkgreen.mkt.domain.enums.OrderStatus.ORDER_CANCELED;

@Component
@RequiredArgsConstructor
public class UpdateAndPublishOrderEvent {

    private final FindOrderByIdUseCase findOrderByIdUseCase;
    private final ReturnProductStockUseCase returnProductStockUseCase;
    private final SaveOrderGateway saveOrderGateway;
    private final PublishOrderStatusEvent publishOrderStatusEvent;

    public void execute(Integer orderId, OrderStatus newOrderStatus) throws InvalidStatusTransitionException {
        var order = findOrderByIdUseCase.execute(orderId);
        if (!order.getStatus().isAbleToChange(newOrderStatus)) {
            throw new InvalidStatusTransitionException(order.getStatus(), newOrderStatus);
        }
        order.setStatus(newOrderStatus);
        order.setUpdatedAt();

        if (ORDER_CANCELED.equals(order.getStatus()))
            returnProductStockUseCase.execute(getProductInfo(order.getProductList()));
        saveOrderGateway.execute(order);
        publishOrderStatusEvent.publish(order);
    }
}
