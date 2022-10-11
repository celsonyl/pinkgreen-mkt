package br.com.pinkgreen.mkt.domain;

import br.com.pinkgreen.mkt.domain.enums.OrderStatus;
import lombok.*;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

import static java.time.Instant.now;

@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class OrderDomain implements Serializable {

    private Integer id;
    private OrderStatus status;
    private CustomerDomain customerData;
    private ShippingDataDomain shippingData;
    private List<ProductOrderDomain> productList;
    private PaymentDomain paymentData;
    private Instant createdAt;
    private Instant updatedAt;

    public OrderDomain(
            OrderStatus status,
            CustomerDomain customerData,
            ShippingDataDomain shippingData,
            List<ProductOrderDomain> productList
    ) {
        this.status = status;
        this.customerData = customerData;
        this.shippingData = shippingData;
        this.productList = productList;
        this.createdAt = now();
        this.updatedAt = now();
    }

    public OrderDomain(
            OrderStatus status,
            CustomerDomain customerData,
            ShippingDataDomain shippingData,
            List<ProductOrderDomain> productList,
            PaymentDomain paymentData,
            Instant createdAt,
            Instant updatedAt
    ) {
        this.status = status;
        this.customerData = customerData;
        this.shippingData = shippingData;
        this.productList = productList;
        this.paymentData = paymentData;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Double getSubtotal() {
        return this.getProductList().stream().reduce(
                0.00,
                (subtotal, it) -> subtotal + (it.getPrice() * it.getQuantity()),
                Double::sum
        );
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public CustomerDomain getCustomerData() {
        return customerData;
    }

    public void setCustomerData(CustomerDomain customerData) {
        this.customerData = customerData;
    }

    public ShippingDataDomain getShippingData() {
        return shippingData;
    }

    public void setShippingData(ShippingDataDomain shippingData) {
        this.shippingData = shippingData;
    }

    public List<ProductOrderDomain> getProductList() {
        return productList;
    }

    public void setProductList(List<ProductOrderDomain> productList) {
        this.productList = productList;
    }

    public PaymentDomain getPaymentData() {
        return paymentData;
    }

    public void setPaymentData(PaymentDomain paymentData) {
        this.paymentData = paymentData;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt() {
        this.updatedAt = now();
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt() {
        this.updatedAt = now();
    }
}
