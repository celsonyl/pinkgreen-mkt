package br.com.pinkgreen.mkt.gateway;

import br.com.pinkgreen.mkt.domain.ProductOrderDomain;

import java.util.List;

public interface ReserveSkuGateway {

    boolean execute(List<ProductOrderDomain> products);
}
