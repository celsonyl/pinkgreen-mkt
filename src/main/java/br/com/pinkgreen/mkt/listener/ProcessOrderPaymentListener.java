package br.com.pinkgreen.mkt.listener;

import br.com.pinkgreen.mkt.gateway.rabbitmq.model.ProcessOrderPaymentMessage;
import br.com.pinkgreen.mkt.listener.sink.ProcessOrderPaymentSink;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;

@Slf4j
@EnableBinding(ProcessOrderPaymentSink.class)
public class ProcessOrderPaymentListener {

    @StreamListener(ProcessOrderPaymentSink.INPUT)
    public void receiver(ProcessOrderPaymentMessage processOrderPaymentMessage){
        log.info("Pedido numero {} recebido para processamento de pagamento",processOrderPaymentMessage.getOrderId());
    }
}
