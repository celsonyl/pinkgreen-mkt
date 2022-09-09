package br.com.pinkgreen.mkt.gateway;

import br.com.pinkgreen.mkt.domain.CustomerDomain;

public interface FindCustomerById {
    CustomerDomain execute(String customerId);
}
