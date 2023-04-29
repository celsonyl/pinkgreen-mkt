package br.com.pinkgreen.mkt.gateway;

import br.com.pinkgreen.mkt.domain.ProductDomain;

import java.util.List;

public interface GetProductAccessHistoricalByCustomerIdGateway {
    List<ProductDomain> execute(String customerId);
}
