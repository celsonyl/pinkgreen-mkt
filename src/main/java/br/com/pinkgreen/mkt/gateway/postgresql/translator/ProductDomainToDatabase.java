package br.com.pinkgreen.mkt.gateway.postgresql.translator;

import br.com.pinkgreen.mkt.domain.BrandDomain;
import br.com.pinkgreen.mkt.domain.CategoryDomain;
import br.com.pinkgreen.mkt.domain.ProductDomain;
import br.com.pinkgreen.mkt.gateway.postgresql.model.BrandDatabase;
import br.com.pinkgreen.mkt.gateway.postgresql.model.CategoryDatabase;
import br.com.pinkgreen.mkt.gateway.postgresql.model.ProductDatabase;

import java.util.stream.Collectors;

public class ProductDomainToDatabase {

    public ProductDatabase productDomainToDatabase(ProductDomain productDomain) {
        var brandDatabase = BrandDatabase.builder()
                .id(productDomain.getBrand().getId())
                .build();

        var categories = productDomain.getCategories().stream().map(element ->
                CategoryDatabase.builder()
                        .id(element.getId())
                        .name(element.getName())
                        .build()
        ).collect(Collectors.toList());

        return ProductDatabase.builder()
                .id(productDomain.getId())
                .name(productDomain.getName())
                .price(productDomain.getPrice())
                .brand(brandDatabase)
                .categories(categories)
                .active(productDomain.getActive()).build();
    }

    public ProductDomain productDatabaseToDomain(ProductDatabase productDatabase) {
        var brandDomain = BrandDomain.builder()
                .id(productDatabase.getBrand().getId())
                .name(productDatabase.getBrand().getName())
                .build();

        var categories = productDatabase.getCategories().stream().map(element ->
                CategoryDomain.builder()
                        .id(element.getId())
                        .name(element.getName())
                        .build()
        ).collect(Collectors.toList());

        return ProductDomain.builder()
                .id(productDatabase.getId())
                .name(productDatabase.getName())
                .price(productDatabase.getPrice())
                .active(productDatabase.getActive())
                .brand(brandDomain)
                .categories(categories)
                .build();
    }
}
