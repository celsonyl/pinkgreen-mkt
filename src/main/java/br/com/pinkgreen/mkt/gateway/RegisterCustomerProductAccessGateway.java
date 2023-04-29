package br.com.pinkgreen.mkt.gateway;

public interface RegisterCustomerProductAccessGateway {
    void execute(String customerId, Integer productId);
}
