package br.com.pinkgreen.mkt.gateway.feign;

import br.com.pinkgreen.mkt.domain.PaymentData;
import br.com.pinkgreen.mkt.domain.PaymentDomain;
import br.com.pinkgreen.mkt.gateway.RequestBankSlipPaymentGateway;
import br.com.pinkgreen.mkt.gateway.feign.client.RequestBankSlipPaymentFeignApi;
import br.com.pinkgreen.mkt.gateway.feign.model.RequestBankSlipPaymentModel;
import br.com.pinkgreen.mkt.gateway.feign.model.ResponseBankSlipPaymentModel;
import br.com.pinkgreen.mkt.gateway.feign.properties.BasePaymentProperties;
import org.springframework.stereotype.Service;

import java.util.Map;

import static br.com.pinkgreen.mkt.gateway.feign.model.RequestBankSlipPaymentModel.request;

@Service
public class RequestBankSlipPaymentGatewayImpl implements RequestBankSlipPaymentGateway {

    private final RequestBankSlipPaymentFeignApi feignApi;
    private final BasePaymentProperties properties;

    public RequestBankSlipPaymentGatewayImpl(
            RequestBankSlipPaymentFeignApi feignApi,
            BasePaymentProperties properties
    ) {
        this.feignApi = feignApi;
        this.properties = properties;
    }

    @Override
    public PaymentDomain execute(Double subtotal, PaymentData paymentData) {
        RequestBankSlipPaymentModel request = request(subtotal, paymentData);
        ResponseBankSlipPaymentModel response = feignApi.execute(properties.getUrl(), request);

        Map<String, String> paymentProperties = request.properties();
        paymentProperties.put("barcode", response.getBarcode());
        return new PaymentDomain(
                response.getPaymentId(),
                subtotal,
                paymentData.getPaymentMethod(),
                paymentProperties,
                paymentData.getPaymentAddress()
        );
    }
}
