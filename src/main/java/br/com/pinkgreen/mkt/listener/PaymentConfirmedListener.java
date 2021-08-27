package br.com.pinkgreen.mkt.listener;

import br.com.pinkgreen.mkt.listener.model.PaymentMessage;
import br.com.pinkgreen.mkt.usecase.FindOrderByPaymentIdUseCase;
import br.com.pinkgreen.mkt.usecase.VerifyAndReserveProductStockUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.function.Consumer;

@Slf4j
@Component
@RequiredArgsConstructor
public class PaymentConfirmedListener {

    private final FindOrderByPaymentIdUseCase findOrderByPaymentIdUseCase;
    private final VerifyAndReserveProductStockUseCase verifyAndReserveProductStockUseCase;

    @Bean
    public Consumer<PaymentMessage> paymentConfirmedConsumer() {
        return message -> {
            log.info("pagamento confirmado!!");
            var order = findOrderByPaymentIdUseCase.execute(message.getPaymentId());
            verifyAndReserveProductStockUseCase.execute(order);
        };
    }
}
