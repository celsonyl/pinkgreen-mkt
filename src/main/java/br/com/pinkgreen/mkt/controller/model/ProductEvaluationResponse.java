package br.com.pinkgreen.mkt.controller.model;

import java.time.Instant;

public class ProductEvaluationResponse {
    private final Integer id;
    private final Integer orderId;
    private final CustomerResponse customer;
    private final String skuCode;
    private final Double stars;
    private final String title;
    private final String evaluation;
    private final Instant createdAt;

    public ProductEvaluationResponse(
            Integer id,
            Integer orderId,
            CustomerResponse customer,
            String skuCode, Double stars,
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

    public Integer getId() {
        return id;
    }

    public Integer getOrderId() {
        return orderId;
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

    public String getSkuCode() {
        return skuCode;
    }

    public CustomerResponse getCustomer() {
        return customer;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }
}
