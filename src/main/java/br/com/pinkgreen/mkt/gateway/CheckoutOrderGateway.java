package br.com.pinkgreen.mkt.gateway;

import br.com.pinkgreen.mkt.domain.OrderDomain;

public interface CheckoutOrderGateway {

    OrderDomain execute(OrderDomain orderDomain);
}
