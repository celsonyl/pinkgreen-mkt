package br.com.pinkgreen.mkt.usecase.factory;

import br.com.pinkgreen.mkt.domain.enums.PaymentMethod;
import br.com.pinkgreen.mkt.usecase.factory.strategies.RequestPaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class RequestPaymentFactory {

    private final List<RequestPaymentStrategy> requestPaymentStrategies;

    public Optional<RequestPaymentStrategy> getPaymentMethodStrategy(PaymentMethod paymentMethod) {
        for (RequestPaymentStrategy x : requestPaymentStrategies) {
            if (x.supports(paymentMethod)) {
                return Optional.of(x);
            }
        }
        return Optional.empty();
    }
}
