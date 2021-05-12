package br.com.pinkgreen.mkt.gateway.rabbitmq.source;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface ProcessOrderPaymentSource {

    @Output("process-order-payment-output")
    MessageChannel sendMessage();
}
