package br.com.pinkgreen.mkt.gateway.feign;

import br.com.pinkgreen.mkt.domain.PaymentData;
import br.com.pinkgreen.mkt.domain.PaymentDomain;
import br.com.pinkgreen.mkt.gateway.RequestCardPaymentGateway;
import br.com.pinkgreen.mkt.gateway.feign.client.RequestCardPaymentFeignApi;
import br.com.pinkgreen.mkt.gateway.feign.model.RequestCardPaymentModel;
import br.com.pinkgreen.mkt.gateway.feign.properties.BasePaymentProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import static br.com.pinkgreen.mkt.gateway.feign.model.RequestCardPaymentModel.request;

@Component
@RequiredArgsConstructor
public class RequestCardPaymentGatewayFeignImpl implements RequestCardPaymentGateway {

    private final RequestCardPaymentFeignApi requestCardPaymentFeignApi;
    private final BasePaymentProperties basePaymentProperties;

    @Override
    public PaymentDomain execute(Double subtotal, PaymentData paymentData) {
        RequestCardPaymentModel request = request(subtotal, paymentData);
        String paymentId = requestCardPaymentFeignApi.execute(
                basePaymentProperties.getUrl(),
                request
        ).getPaymentId();

        return new PaymentDomain(
                paymentId,
                subtotal,
                paymentData.getPaymentMethod(),
                request.properties(),
                paymentData.getPaymentAddress()
        );
    }
}