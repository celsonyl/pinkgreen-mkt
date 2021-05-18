package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.OrderDomain;
import br.com.pinkgreen.mkt.domain.PaymentDomain;
import br.com.pinkgreen.mkt.domain.ProductDomain;
import br.com.pinkgreen.mkt.gateway.CheckoutOrderGateway;
import br.com.pinkgreen.mkt.gateway.PublishOrderToProcessPayment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static br.com.pinkgreen.mkt.domain.enums.OrderStatus.ORDER_CREATED;

@Component
@RequiredArgsConstructor
public class CheckoutOrderUseCase {
    // TODO - Consultar catalogo para validar dados do produto recebido
    // TODO - Criptografar campos no 'paymentMethodProperties' caso o pagamento seja por cartão

    private final CheckoutOrderGateway checkoutOrderGateway;
    private final PublishOrderToProcessPayment publishOrderToProcessPayment;

    public OrderDomain execute(OrderDomain orderDomain, PaymentDomain paymentDomain) {
        setOrderStatusAndCalculateAmount(orderDomain);
        OrderDomain order = checkoutOrderGateway.execute(orderDomain);

        publishOrderToProcessPayment.publish(order, paymentDomain);
        return order;
    }

    private void setOrderStatusAndCalculateAmount(OrderDomain orderDomain) {
        orderDomain.setStatus(ORDER_CREATED);
        orderDomain.getPaymentData().setAmount(calcOrderAmount(orderDomain.getProductList()));
    }

    private Double calcOrderAmount(List<ProductDomain> productDomainList) {
        return productDomainList.stream().reduce(0.00, (subtotal, element) -> subtotal + element.getPrice(), Double::sum);
    }
}
