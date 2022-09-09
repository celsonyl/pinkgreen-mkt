package br.com.pinkgreen.mkt.gateway.feign;

import br.com.pinkgreen.mkt.domain.OrderDomain;
import br.com.pinkgreen.mkt.gateway.RequestCardPaymentGateway;
import br.com.pinkgreen.mkt.gateway.feign.client.RequestCardPaymentFeignApi;
import br.com.pinkgreen.mkt.gateway.feign.properties.BasePaymentProperties;
import br.com.pinkgreen.mkt.gateway.feign.model.RequestCardPaymentModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class RequestCardPaymentGatewayFeignImpl implements RequestCardPaymentGateway {

    private final RequestCardPaymentFeignApi requestCardPaymentFeignApi;
    private final BasePaymentProperties basePaymentProperties;

    @Override
    public String execute(OrderDomain orderDomain) {
        var map = orderDomain.getPaymentData().getPaymentMethodProperties();
        var paymentCard = RequestCardPaymentModel.builder()
                .cardNumber(map.get("cardNumber"))
                .cvv(map.get("cvv"))
                .validationDate(map.get("validationDate"))
                .document(map.get("document"))
                .ownerName(map.get("ownerName"))
                .phone(map.get("phone"))
                .email(map.get("email"))
                .paymentAddress(orderDomain.getPaymentData().getPaymentAddress())
                .amount(orderDomain.getPaymentData().getAmount())
                .build();

        return requestCardPaymentFeignApi.execute(basePaymentProperties.getUrl(), paymentCard).getPaymentId();
    }
}