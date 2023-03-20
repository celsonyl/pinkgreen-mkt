package br.com.pinkgreen.mkt.controller.model;

import br.com.pinkgreen.mkt.domain.ProductEvaluationBySkuCode;

import java.util.List;

public class ProductEvaluationBySkuResponse {
    private Double average;
    private Integer count;
    private List<ProductEvaluationResponse> data;

    public ProductEvaluationBySkuResponse(Double average, Integer count, List<ProductEvaluationResponse> data) {
        this.average = average;
        this.count = count;
        this.data = data;
    }

    public static ProductEvaluationBySkuResponse response(ProductEvaluationBySkuCode evaluations) {
        return new ProductEvaluationBySkuResponse(
                evaluations.getAverage(),
                evaluations.getCount(),
                ProductEvaluationResponse.response(evaluations.getData())
        );
    }

    public Double getAverage() {
        return average;
    }

    public void setAverage(Double average) {
        this.average = average;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<ProductEvaluationResponse> getData() {
        return data;
    }

    public void setData(List<ProductEvaluationResponse> data) {
        this.data = data;
    }
}
