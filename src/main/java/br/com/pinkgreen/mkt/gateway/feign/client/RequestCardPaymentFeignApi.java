package br.com.pinkgreen.mkt.gateway.feign.client;

import br.com.pinkgreen.mkt.gateway.feign.config.PaymentBaseConfig;
import br.com.pinkgreen.mkt.gateway.feign.model.RequestCardPaymentModel;
import br.com.pinkgreen.mkt.gateway.feign.model.ResponseCardPaymentModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;

@FeignClient(value = "RequestCardPayment", configuration = PaymentBaseConfig.class)
public interface RequestCardPaymentFeignApi {

    @PostMapping(value = "/payments/credit_card")
    ResponseCardPaymentModel execute(URI baseUrl, @RequestBody RequestCardPaymentModel requestCardPaymentModel);
}
