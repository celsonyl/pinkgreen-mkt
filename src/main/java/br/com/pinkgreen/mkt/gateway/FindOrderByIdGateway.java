package br.com.pinkgreen.mkt.gateway;

import br.com.pinkgreen.mkt.domain.OrderDomain;

import java.util.Optional;

public interface FindOrderByIdGateway {
    
    Optional<OrderDomain> execute(Integer id);
}
