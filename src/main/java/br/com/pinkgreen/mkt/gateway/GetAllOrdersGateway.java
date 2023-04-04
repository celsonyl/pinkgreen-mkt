package br.com.pinkgreen.mkt.gateway;

import br.com.pinkgreen.mkt.domain.OrderDomain;

import java.util.List;

public interface GetAllOrdersGateway {

    List<OrderDomain> execute();
}
