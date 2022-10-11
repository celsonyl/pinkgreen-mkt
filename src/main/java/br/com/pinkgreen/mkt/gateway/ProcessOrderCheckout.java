package br.com.pinkgreen.mkt.gateway;

import br.com.pinkgreen.mkt.domain.PaymentData;

public interface ProcessOrderCheckout {

    void publish(Integer id, PaymentData paymentData);
}
