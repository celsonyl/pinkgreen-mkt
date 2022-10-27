package br.com.pinkgreen.mkt.controller.model;

import br.com.pinkgreen.mkt.domain.ProductEvaluationDomain;

import java.time.Instant;
import java.util.List;

import static java.util.stream.Collectors.toList;

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

    public static ProductEvaluationResponse response(ProductEvaluationDomain productEvaluation) {
        return new ProductEvaluationResponse(
                productEvaluation.getId(),
                productEvaluation.getOrderId(),
                new CustomerResponse(
                        productEvaluation.getCustomer().getId(),
                        productEvaluation.getCustomer().getName(),
                        productEvaluation.getCustomer().getLastname()
                ),
                productEvaluation.getSkuCode(),
                productEvaluation.getStars(),
                productEvaluation.getTitle(),
                productEvaluation.getEvaluation(),
                productEvaluation.getCreatedAt()
        );
    }

    public static List<ProductEvaluationResponse> response(List<ProductEvaluationDomain> order) {
        return order.stream()
                .map(ProductEvaluationResponse::response)
                .collect(toList());
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
