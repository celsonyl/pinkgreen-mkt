package br.com.pinkgreen.mkt.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.oauth2.server.resource.OAuth2ResourceServerConfigurer;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationConverter;
import org.springframework.security.web.SecurityFilterChain;

import java.util.List;
import java.util.Map;

import static br.com.pinkgreen.mkt.config.security.Authorities.*;
import static org.springframework.http.HttpMethod.*;
import static org.springframework.security.core.authority.AuthorityUtils.createAuthorityList;

@Configuration
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.cors().and().csrf().disable().authorizeRequests()
                .antMatchers(POST, "/brand-administration/brand").hasAuthority(CREATE_BRAND.toString())
                .antMatchers(DELETE, "/brand-administration/brand/{id}").hasAuthority(CREATE_BRAND.toString()) // TODO: Add permissao
                .antMatchers(PUT, "/brand-administration/brand/{id}").hasAuthority(CREATE_BRAND.toString()) // TODO: Add permissao
                .antMatchers(GET, "/brand").permitAll()
                .antMatchers(GET, "/brand/search").permitAll()
                .antMatchers(GET, "/brand/{id}").permitAll()
                .antMatchers(GET, "/favorite/user/{userId}").hasAuthority(GET_CUSTOMER_FAVORITE_PRODUCTS.toString())
                .antMatchers(POST, "/favorite/product/{skuCode}/user/{userId}").hasAuthority(ADD_CUSTOMER_FAVORITE_PRODUCT.toString())
                .antMatchers(GET, "/favorite/product/{skuCode}/user/{userId}").hasAuthority(GET_CUSTOMER_FAVORITE_PRODUCTS.toString())
                .antMatchers(DELETE, "/favorite/product/{skuCode}/user/{userId}").hasAuthority(DELETE_CUSTOMER_FAVORITE_PRODUCT.toString())
                .antMatchers(POST, "/category-administration/category").hasAuthority(CREATE_CATEGORY.toString())
                .antMatchers(DELETE, "/category-administration/category/{id}").hasAuthority(CREATE_CATEGORY.toString())  // TODO: Add permissao
                .antMatchers(PUT, "/category-administration/category/{id}").hasAuthority(CREATE_CATEGORY.toString())  // TODO: Add permissao
                .antMatchers(GET, "/category").permitAll()
                .antMatchers(GET, "/category/{id}").permitAll()
                .antMatchers(POST, "/product-administration/product").hasAuthority(CREATE_PRODUCT.toString())
                .antMatchers(GET, "/product-administration/product").hasAuthority(CREATE_PRODUCT.toString()) // TODO: Add permissao
                .antMatchers(PUT, "/product-administration/product/{id}").hasAuthority(UPDATE_PRODUCT.toString())
                .antMatchers(DELETE, "/product-administration/product/{id}").hasAuthority(CREATE_PRODUCT.toString())  // TODO: Add permissao
                .antMatchers(GET, "/product-administration/product/{id}").hasAuthority(CREATE_PRODUCT.toString())  // TODO: Add permissao
                .antMatchers(GET, "/product/{id}").permitAll()
                .antMatchers(GET, "/product").permitAll()
                .antMatchers(GET, "/product/search").permitAll()
                .antMatchers(GET, "/product/category/{id}").permitAll()
                .antMatchers(GET, "/product/brand/{id}").permitAll()
                .antMatchers(POST, "/evaluations/order/{orderId}/product/{skuCode}").hasAuthority(ADD_PRODUCT_EVALUATION.toString())
                .antMatchers(GET, "/evaluations/order/{orderId}/product/{skuCode}").hasAuthority(GET_CUSTOMER_PRODUCTS_EVALUATIONS.toString())
                .antMatchers(GET, "/evaluations/product/{skuCode}").permitAll()
                .antMatchers(GET, "/evaluations/customer/{customerId}").hasAuthority(GET_CUSTOMER_PRODUCTS_EVALUATIONS.toString())
                .antMatchers(GET, "/evaluations/order/{orderId}").hasAuthority(GET_CUSTOMER_PRODUCTS_EVALUATIONS.toString())
                .antMatchers(POST, "/sku-administration/sku").hasAuthority(CREATE_SKU.toString())
                .antMatchers(PUT, "/sku-administration/sku/{code}").hasAuthority(UPDATE_SKU.toString())
                .antMatchers(DELETE, "/sku-administration/sku/{code}").hasAuthority(CREATE_SKU.toString())  // TODO: Add permissao
                .antMatchers(GET, "/sku-administration/sku/{code}").hasAuthority(CREATE_SKU.toString())  // TODO: Add permissao
                .antMatchers(GET, "/sku-administration/sku/product/{id}").hasAuthority(CREATE_SKU.toString())  // TODO: Add permissao
                .antMatchers(GET, "/sku-administration/sku").hasAuthority(GET_ALL_SKUS.toString())
                .antMatchers(GET, "/sku/most-selled").permitAll()
                .antMatchers(GET, "/sku/{code}").permitAll()
                .antMatchers(GET, "/sku/product_skus/{productId}").permitAll()
                .antMatchers(GET, "/customer-intentions/{customerId}").hasAuthority(CHECKOUT_ORDER.toString())  // TODO: Add permissao
                .antMatchers(GET, "/customer-product-access-historical/{customerId}").hasAuthority(CHECKOUT_ORDER.toString())  // TODO: Add permissao
                .antMatchers(POST, "/order").hasAuthority(CHECKOUT_ORDER.toString())
                .antMatchers(GET, "/order/customer/{customerId}").hasAuthority(GET_CUSTOMER_ORDERS.toString())
                .antMatchers(GET, "/order/{orderId}").hasAuthority(GET_CUSTOMER_ORDERS.toString())
                .antMatchers(GET, "/order-administration/order").hasAuthority(GET_ALL_ORDERS.toString())
                .antMatchers(GET, "/order-administration/order/{orderId}").hasAuthority(GET_ORDER_BY_ID.toString())
                .antMatchers(PATCH, "/order-administration/order/{orderId}/update/{orderStatus}").hasAuthority(UPDATE_ORDER_STATUS.toString())
                .antMatchers(GET, "/actuator").permitAll()
                .antMatchers(GET, "/actuator/health").permitAll()
                .antMatchers(GET, "/actuator/env").permitAll()
                .antMatchers(GET, "/swagger-ui.html").permitAll()
                .antMatchers(GET, "/swagger-ui/**").permitAll()
                .antMatchers(GET, "/api-docs.yaml").permitAll()
                .antMatchers(GET, "/api-docs/**").permitAll()
                .antMatchers(GET, "/api-docs/**").permitAll()
                .antMatchers(GET, "/v2/api-docs").permitAll()
                .antMatchers(GET, "/configuration/ui").permitAll()
                .antMatchers(GET, "/swagger-resources/**").permitAll()
                .antMatchers(GET, "/configuration/security").permitAll()
                .antMatchers(GET, "/webjars/**").permitAll()
                .anyRequest().denyAll()
                .and().oauth2ResourceServer(OAuth2ResourceServerConfigurer::jwt);
        return http.build();
    }

    @Bean
    public JwtAuthenticationConverter jwtAuthenticationConverter() {
        JwtAuthenticationConverter authenticationConverter = new JwtAuthenticationConverter();
        authenticationConverter.setJwtGrantedAuthoritiesConverter((jwt) -> {
            Map<String, Object> realm_access = jwt.getClaimAsMap("realm_access");

            if (realm_access == null) return createAuthorityList();

            List<String> roles = (List<String>) realm_access.get("roles");
            return createAuthorityList(roles.toArray(String[]::new));
        });
        return authenticationConverter;
    }
}
