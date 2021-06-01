package br.com.pinkgreen.mkt.gateway.postgresql.service;

import br.com.pinkgreen.mkt.gateway.postgresql.BrandRepository;
import br.com.pinkgreen.mkt.gateway.postgresql.CategoryRepository;
import br.com.pinkgreen.mkt.gateway.postgresql.ProductRepository;
import br.com.pinkgreen.mkt.gateway.postgresql.model.BrandDatabase;
import br.com.pinkgreen.mkt.gateway.postgresql.model.CategoryDatabase;
import br.com.pinkgreen.mkt.gateway.postgresql.model.ProductDatabase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.Arrays;
import java.util.Collections;

@Service
public class DBService {

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private ProductRepository productRepository;

    public void instantiateTestDB() throws ParseException {
        BrandDatabase brand1 = new BrandDatabase(null, "Naike");
        BrandDatabase brand2 = new BrandDatabase(null, "Sony");
        BrandDatabase brand3 = new BrandDatabase(null, "APPLE");
        BrandDatabase brand4 = new BrandDatabase(null, "Xaiomer");
        brandRepository.saveAll(Arrays.asList(brand1, brand2, brand3, brand4));

        CategoryDatabase category1 = new CategoryDatabase(null, "Informatica");
        CategoryDatabase category2 = new CategoryDatabase(null, "Decoração");
        categoryRepository.saveAll(Arrays.asList(category1, category2));

        ProductDatabase product1 = new ProductDatabase(null, "PS5", 1500.00, true, brand2, Collections.singletonList(category1));
        ProductDatabase product2 = new ProductDatabase(null, "TV", 3500.00, true, brand3, Collections.singletonList(category2));
        ProductDatabase product3 = new ProductDatabase(null, "Mesa", 500.00, true, brand1, Collections.singletonList(category2));
        productRepository.saveAll(Arrays.asList(product1, product2, product3));

    }
}
