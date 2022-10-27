package br.com.pinkgreen.mkt.gateway.postgresql.model;

import br.com.pinkgreen.mkt.domain.CustomerDomain;
import br.com.pinkgreen.mkt.domain.ProductEvaluationDomain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.Instant;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Entity(name = "PRODUCT_EVALUATIONS")
public class ProductEvaluationDatabase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer orderId;
    private String customerId;
    private String skuCode;
    private Double stars;
    private String title;
    private String evaluation;
    private Instant createdAt;

    public ProductEvaluationDatabase() {
    }

    public ProductEvaluationDatabase(
            Integer id,
            Integer orderId,
            String customerId,
            String skuCode,
            Double stars,
            String title,
            String evaluation,
            Instant createdAt
    ) {
        this.id = id;
        this.orderId = orderId;
        this.customerId = customerId;
        this.skuCode = skuCode;
        this.stars = stars;
        this.title = title;
        this.evaluation = evaluation;
        this.createdAt = createdAt;
    }

    public static ProductEvaluationDatabase database(ProductEvaluationDomain evaluation) {
        return new ProductEvaluationDatabase(
                evaluation.getId(),
                evaluation.getOrderId(),
                evaluation.getCustomer().getId(),
                evaluation.getSkuCode(),
                evaluation.getStars(),
                evaluation.getTitle(),
                evaluation.getEvaluation(),
                evaluation.getCreatedAt()
        );
    }

    public ProductEvaluationDomain domain() {
        return new ProductEvaluationDomain(
                this.id,
                this.orderId,
                new CustomerDomain(this.customerId),
                this.skuCode,
                this.stars,
                this.title,
                this.evaluation,
                this.createdAt
        );
    }

    public static List<ProductEvaluationDomain> domain(List<ProductEvaluationDatabase> evaluations) {
        return evaluations.stream()
                .map(ProductEvaluationDatabase::domain)
                .collect(toList());
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
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

    public String getCustomerId() {
        return customerId;
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
