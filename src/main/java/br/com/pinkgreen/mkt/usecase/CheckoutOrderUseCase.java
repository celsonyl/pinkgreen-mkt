package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.OrderDomain;
import br.com.pinkgreen.mkt.domain.PaymentDomain;
import br.com.pinkgreen.mkt.domain.ProductDomain;
import br.com.pinkgreen.mkt.gateway.CheckoutOrderGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static br.com.pinkgreen.mkt.domain.enums.OrderStatus.ORDER_CREATED;

@Component
@RequiredArgsConstructor
public class CheckoutOrderUseCase {
    // TODO - Consultar catalogo para validar dados do produto recebido
    // TODO - Validar customerId recebido (se customerId existe na base)

    private final CheckoutOrderGateway checkoutOrderGateway;

    public OrderDomain execute(OrderDomain orderDomain, PaymentDomain paymentDomain) {
        // TODO - Criptografar campos no 'paymentMethodProperties' caso o pagamento seja por cartão
        setOrderStatusAndCalculateAmount(orderDomain);

        OrderDomain order = checkoutOrderGateway.execute(orderDomain);
        // TODO - Postar pedido criado em uma fila no rabbit como payload o orderId e um header com o status de ORDER_CREATED

        // TODO - Retornar OrderDomain com orderId preenchido
        return order;
    }

    private void setOrderStatusAndCalculateAmount(OrderDomain orderDomain) {
        orderDomain.setStatus(ORDER_CREATED);
        orderDomain.getPaymentData().setAmount(calcOrderAmount(orderDomain.getProductList()));
    }

    private Double calcOrderAmount(List<ProductDomain> productDomainList) {
        return productDomainList.stream().reduce(0.00, (aaa, element) -> aaa + element.getPrice(), Double::sum);
    }
}
