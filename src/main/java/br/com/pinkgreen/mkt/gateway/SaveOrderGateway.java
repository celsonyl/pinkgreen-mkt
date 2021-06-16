package br.com.pinkgreen.mkt.gateway;

import br.com.pinkgreen.mkt.domain.OrderDomain;

public interface SaveOrderGateway {

    OrderDomain execute(OrderDomain orderDomain);
}
