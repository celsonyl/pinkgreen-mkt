package br.com.pinkgreen.mkt.gateway;

import br.com.pinkgreen.mkt.domain.OrderDomain;

public interface PublishOrderStatusEvent {

    void publish(OrderDomain orderDomain);
}
