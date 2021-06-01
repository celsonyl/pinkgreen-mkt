package br.com.pinkgreen.mkt.gateway.rabbitmq;

import br.com.pinkgreen.mkt.domain.OrderDomain;
import br.com.pinkgreen.mkt.domain.PaymentDomain;
import br.com.pinkgreen.mkt.gateway.PublishOrderToProcessPayment;
import br.com.pinkgreen.mkt.gateway.rabbitmq.model.ProcessOrderPaymentMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

import static br.com.pinkgreen.mkt.gateway.rabbitmq.supplier.PublishOrderToProcessPaymentSupplier.OUTPUT;

@Component
@RequiredArgsConstructor
public class PublishOrderToProcessPaymentRabbitImpl implements PublishOrderToProcessPayment {

    private final StreamBridge streamBridge;

    public void publish(OrderDomain orderDomain, PaymentDomain paymentDomain) {
        var processOrderPaymentMessage = ProcessOrderPaymentMessage.builder()
                .orderId(orderDomain.getId())
                .paymentDomain(paymentDomain)
                .build();
        streamBridge.send(OUTPUT, MessageBuilder.withPayload(processOrderPaymentMessage).build());
    }
}
