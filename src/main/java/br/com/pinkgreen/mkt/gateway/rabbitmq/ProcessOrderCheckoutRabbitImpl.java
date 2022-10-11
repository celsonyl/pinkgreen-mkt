package br.com.pinkgreen.mkt.gateway.rabbitmq;

import br.com.pinkgreen.mkt.domain.PaymentData;
import br.com.pinkgreen.mkt.gateway.ProcessOrderCheckout;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.stereotype.Component;

import static br.com.pinkgreen.mkt.domain.enums.OrderStatus.ORDER_CREATED;
import static br.com.pinkgreen.mkt.gateway.rabbitmq.model.ProcessOrderCheckoutMessage.message;
import static br.com.pinkgreen.mkt.gateway.rabbitmq.supplier.PublishOrderStatusEventSupplier.OUTPUT;
import static org.springframework.integration.support.MessageBuilder.withPayload;

@Component
@RequiredArgsConstructor
public class ProcessOrderCheckoutRabbitImpl implements ProcessOrderCheckout {

    private final StreamBridge streamBridge;

    public void publish(Integer id, PaymentData paymentData) {
        streamBridge.send(OUTPUT, withPayload(message(id, paymentData))
                .setHeader("ORDER_STATUS", ORDER_CREATED)
                .build());
    }
}
