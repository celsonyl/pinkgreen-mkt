package br.com.pinkgreen.mkt.gateway.rabbitmq.supplier;

import br.com.pinkgreen.mkt.gateway.rabbitmq.model.ProcessOrderPaymentMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
@Slf4j
public class PublishOrderStatusEventSupplier {

    public static final String OUTPUT = "publishOrderStatusEvent-out-0";

    @Bean
    public Supplier<Message<ProcessOrderPaymentMessage>> publishOrderStatusEvent() {
        return () -> null;
    }
}
