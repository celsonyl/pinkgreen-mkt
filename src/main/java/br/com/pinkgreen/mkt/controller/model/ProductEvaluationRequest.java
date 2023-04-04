package br.com.pinkgreen.mkt.controller.model;

import br.com.pinkgreen.mkt.domain.CustomerDomain;
import br.com.pinkgreen.mkt.domain.ProductEvaluationDomain;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;
import java.time.Instant;

public class ProductEvaluationRequest {

    @NotNull
    @PositiveOrZero
    private Double stars;

    @NotBlank
    @Size(min = 2, max = 50)
    private String title;

    @Size(max = 255)
    private String evaluation;

    public ProductEvaluationRequest(Double stars, String title, String evaluation) {
        this.stars = stars;
        this.title = title;
        this.evaluation = evaluation;
    }

    public ProductEvaluationDomain domain(Integer orderId, String skuCode, String customerId) {
        return new ProductEvaluationDomain(
                orderId,
                new CustomerDomain(customerId),
                skuCode,
                stars,
                title,
                evaluation,
                Instant.now()
        );
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

    public void setStars(Double stars) {
        this.stars = stars;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setEvaluation(String evaluation) {
        this.evaluation = evaluation;
    }
}
