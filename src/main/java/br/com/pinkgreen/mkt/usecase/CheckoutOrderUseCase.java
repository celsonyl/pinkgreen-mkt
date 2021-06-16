package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.OrderDomain;
import br.com.pinkgreen.mkt.domain.PaymentDomain;
import br.com.pinkgreen.mkt.domain.ProductOrderDomain;
import br.com.pinkgreen.mkt.domain.SkuDomain;
import br.com.pinkgreen.mkt.gateway.SaveOrderGateway;
import br.com.pinkgreen.mkt.gateway.PublishOrderToProcessPayment;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static br.com.pinkgreen.mkt.domain.enums.OrderStatus.ORDER_CREATED;

@Component
@RequiredArgsConstructor
public class CheckoutOrderUseCase {
    // TODO - Consultar catalogo para validar dados do produto recebido
    // TODO - Criptografar campos no 'paymentMethodProperties' caso o pagamento seja por cartão

    private final GetSkuBySkuCodeUseCase getSkuBySkuCodeUseCase;
    private final SaveOrderGateway saveOrderGateway;
    private final PublishOrderToProcessPayment publishOrderToProcessPayment;

    public OrderDomain execute(OrderDomain orderDomain, PaymentDomain paymentDomain) {
        List<SkuDomain> skuDomainsDB = orderDomain.getProductList().stream()
                .map(element -> getSkuBySkuCodeUseCase.getSkuBySkuCode(element.getSkuCode()))
                .collect(Collectors.toList());

        validateReceivedSku(orderDomain.getProductList(), skuDomainsDB);
        setOrderStatusAndCalculateAmount(orderDomain);
        OrderDomain order = saveOrderGateway.execute(orderDomain);

        publishOrderToProcessPayment.publish(order, paymentDomain);
        return order;
    }

    private void setOrderStatusAndCalculateAmount(OrderDomain orderDomain) {
        orderDomain.setStatus(ORDER_CREATED);
        orderDomain.getPaymentData().setAmount(calcOrderAmount(orderDomain.getProductList()));
    }

    private Double calcOrderAmount(List<ProductOrderDomain> productOrderDomainList) {
        return productOrderDomainList.stream().reduce(0.00, (subtotal, element) -> subtotal + element.getPrice().getListPrice(), Double::sum);
    }

    private void validateReceivedSku(List<ProductOrderDomain> productOrderDomains, List<SkuDomain> skuDomainsDB) {
        // TODO: Validar dados do SKU.
    }
}
