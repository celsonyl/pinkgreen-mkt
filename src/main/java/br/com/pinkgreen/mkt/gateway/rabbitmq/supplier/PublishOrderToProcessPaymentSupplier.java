package br.com.pinkgreen.mkt.gateway.rabbitmq.supplier;

import br.com.pinkgreen.mkt.gateway.rabbitmq.model.ProcessOrderPaymentMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.function.Supplier;

@Component
@Slf4j
public class PublishOrderToProcessPaymentSupplier {

    public static final String OUTPUT = "processOrderPaymentSupplier-out-0";

    @Bean
    public Supplier<Message<ProcessOrderPaymentMessage>> processOrderPaymentSupplier() {
        return () -> null;
    }
}
