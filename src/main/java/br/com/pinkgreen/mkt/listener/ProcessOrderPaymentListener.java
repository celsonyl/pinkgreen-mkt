package br.com.pinkgreen.mkt.listener;

import br.com.pinkgreen.mkt.gateway.rabbitmq.model.ProcessOrderPaymentMessage;
import br.com.pinkgreen.mkt.usecase.RequestPaymentUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProcessOrderPaymentListener {

    private final RequestPaymentUseCase requestPaymentUseCase;

    @Bean
    public Consumer<ProcessOrderPaymentMessage> processOrderPaymentConsumer() {
        return message -> {
            log.info("Pedido numero {} recebido para processamento de pagamento", message.getOrderId());
            requestPaymentUseCase.execute(message.getOrderId(), message.getPaymentDomain());
        };
    }
}
