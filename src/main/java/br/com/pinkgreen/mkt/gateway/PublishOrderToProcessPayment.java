package br.com.pinkgreen.mkt.gateway;

import br.com.pinkgreen.mkt.domain.OrderDomain;
import br.com.pinkgreen.mkt.domain.PaymentDomain;

public interface PublishOrderToProcessPayment {

    void publish(OrderDomain orderDomain, PaymentDomain paymentDomain);
}
