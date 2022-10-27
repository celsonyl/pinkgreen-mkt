package br.com.pinkgreen.mkt.domain;

import java.time.Instant;

public class ProductEvaluationDomain {

    private Integer id;
    private Integer orderId;
    private CustomerDomain customer;
    private String skuCode;
    private Double stars;
    private String title;
    private String evaluation;
    private Instant createdAt;

    public ProductEvaluationDomain(
            Integer orderId,
            CustomerDomain customer,
            String skuCode,
            Double stars,
            String title,
            String evaluation,
            Instant createdAt
    ) {
        this.orderId = orderId;
        this.customer = customer;
        this.skuCode = skuCode;
        this.stars = stars;
        this.title = title;
        this.evaluation = evaluation;
        this.createdAt = createdAt;
    }

    public ProductEvaluationDomain(
            Integer id,
            Integer orderId,
            CustomerDomain customer,
            String skuCode,
            Double stars,
            String title,
            String evaluation,
            Instant createdAt
    ) {
        this.id = id;
        this.orderId = orderId;
        this.customer = customer;
        this.skuCode = skuCode;
        this.stars = stars;
        this.title = title;
        this.evaluation = evaluation;
        this.createdAt = createdAt;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public void setCustomer(CustomerDomain customer) {
        this.customer = customer;
    }

    public void setSkuCode(String skuCode) {
        this.skuCode = skuCode;
    }

    public void setStars(Double stars) {
        this.stars = stars;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public CustomerDomain getCustomer() {
        return customer;
    }

    public String getSkuCode() {
        return skuCode;
    }

    public Double getStars() {
        return stars;
    }

    public String getTitle() {
        return title;
    }

    public String getEvaluation() {
        return evaluation;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}