package br.com.pinkgreen.mkt.gateway.rabbitmq;

import br.com.pinkgreen.mkt.domain.OrderDomain;
import br.com.pinkgreen.mkt.domain.PaymentDomain;
import br.com.pinkgreen.mkt.gateway.PublishOrderToProcessPayment;
import br.com.pinkgreen.mkt.gateway.rabbitmq.model.ProcessOrderPaymentMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@EnableBinding(ProcessOrderPaymentSource.class)
public class PublishOrderToProcessPaymentRabbitImpl implements PublishOrderToProcessPayment {

    private final ProcessOrderPaymentSource processOrderPaymentSource;

    public void publish(OrderDomain orderDomain, PaymentDomain paymentDomain) {
        ProcessOrderPaymentMessage processOrderPaymentMessage = ProcessOrderPaymentMessage.builder()
                .orderId(orderDomain.getId())
                .paymentDomain(paymentDomain)
                .build();
        processOrderPaymentSource.sendMessage().send(MessageBuilder.withPayload(processOrderPaymentMessage).build());
    }
}
