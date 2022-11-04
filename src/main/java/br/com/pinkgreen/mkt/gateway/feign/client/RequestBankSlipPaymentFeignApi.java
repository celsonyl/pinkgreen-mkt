package br.com.pinkgreen.mkt.gateway.feign.client;

import br.com.pinkgreen.mkt.gateway.feign.config.PaymentBaseConfig;
import br.com.pinkgreen.mkt.gateway.feign.model.RequestBankSlipPaymentModel;
import br.com.pinkgreen.mkt.gateway.feign.model.ResponseBankSlipPaymentModel;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.net.URI;

@FeignClient(value = "RequestBankSlipPayment", configuration = PaymentBaseConfig.class)
public interface RequestBankSlipPaymentFeignApi {

    @PostMapping(value = "/payments/bank_slip")
    ResponseBankSlipPaymentModel execute(URI baseUrl, @RequestBody RequestBankSlipPaymentModel body);
}
