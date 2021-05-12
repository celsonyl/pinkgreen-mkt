package br.com.pinkgreen.mkt.listener.sink;

import org.springframework.cloud.stream.annotation.Input;
import org.springframework.messaging.MessageChannel;

public interface ProcessOrderPaymentSink {

    String INPUT = "process-order-payment-input";

    @Input(value = INPUT)
    MessageChannel receiverMessage();

}
