package br.com.pinkgreen.mkt.domain;

import br.com.pinkgreen.mkt.gateway.postgresql.model.IProductEvaluationMetadata;

import java.util.List;

public class ProductEvaluationBySkuCode {
    private Double average;
    private Integer count;
    private List<ProductEvaluationDomain> data;


    public ProductEvaluationBySkuCode(Double average, Integer count, List<ProductEvaluationDomain> data) {
        this.average = average;
        this.count = count;
        this.data = data;
    }

    public static ProductEvaluationBySkuCode evaluation(IProductEvaluationMetadata metadata, List<ProductEvaluationDomain> data) {
        return new ProductEvaluationBySkuCode(metadata.getAverage(), metadata.getCount(), data);
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

    public List<ProductEvaluationDomain> getData() {
        return data;
    }

    public void setData(List<ProductEvaluationDomain> data) {
        this.data = data;
    }
}
