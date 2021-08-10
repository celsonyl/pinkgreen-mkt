package br.com.pinkgreen.mkt.gateway.rabbitmq;

import br.com.pinkgreen.mkt.domain.OrderDomain;
import br.com.pinkgreen.mkt.gateway.PublishOrderStatusEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.function.StreamBridge;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

import static br.com.pinkgreen.mkt.gateway.rabbitmq.supplier.PublishOrderStatusEventSupplier.OUTPUT;

@Component
@RequiredArgsConstructor
public class PublishOrderStatusEventRabbitImpl implements PublishOrderStatusEvent {

    private final StreamBridge streamBridge;

    public void publish(OrderDomain orderDomain) {
        var message = MessageBuilder.withPayload(orderDomain)
                .setHeader("ORDER_STATUS", orderDomain.getStatus())
                .build();
        streamBridge.send(OUTPUT, message);
    }
}
