package br.com.pinkgreen.mkt.gateway;

import br.com.pinkgreen.mkt.domain.OrderDomain;
import br.com.pinkgreen.mkt.domain.enums.OrderStatus;

import java.util.List;

public interface GetAllOrdersByStatusGateway {

    List<OrderDomain> execute(OrderStatus orderStatus);
}
