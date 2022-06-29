package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.OrderDomain;
import br.com.pinkgreen.mkt.domain.enums.OrderStatus;
import br.com.pinkgreen.mkt.gateway.ReserveSkuGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;


@Component
@RequiredArgsConstructor
public class VerifyAndReserveProductStockUseCase {

    private final ReserveSkuGateway reserveSkuGateway;
    private final UpdateAndPublishOrderEvent updateAndPublishOrderEvent;

    @Transactional
    public void execute(OrderDomain orderDomain) {
        var isReserved = reserveSkuGateway.execute(orderDomain.getProductList());

        if (isReserved) {
            updateAndPublishOrderEvent.execute(orderDomain.getId(), OrderStatus.ORDER_STOCK_RESERVED);
        } else {
            // TODO: cancelar pagamento
            updateAndPublishOrderEvent.execute(orderDomain.getId(), OrderStatus.ORDER_STOCK_FAILED);
            updateAndPublishOrderEvent.execute(orderDomain.getId(), OrderStatus.ORDER_CANCELED);
        }
    }
}
