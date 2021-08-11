package br.com.pinkgreen.mkt.listener;

import br.com.pinkgreen.mkt.listener.model.PaymentMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Slf4j
@Component
@RequiredArgsConstructor
public class PaymentConfirmedListener {

    @Bean
    public Consumer<PaymentMessage> paymentConfirmedConsumer() {
        return message -> {
            // TODO: Apos confirmado o pagamento, reservar o estoque
            // TODO: caso nao tenha estoque, cancelar pagamento e compra
            // TODO: caso tenha estoque, disparar pedido para entrega
            log.info("pagamento confirmado!!");
        };
    }
}
