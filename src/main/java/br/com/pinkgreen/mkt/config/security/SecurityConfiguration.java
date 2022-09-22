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
                .antMatchers(POST, "/brand").hasAuthority(CREATE_BRAND.toString())
                .antMatchers(GET, "/brand").permitAll()
                .antMatchers(GET, "/brand/search").permitAll()
                .antMatchers(GET, "/brand/{id}").permitAll()
                .antMatchers(POST, "/category").hasAuthority(CREATE_CATEGORY.toString())
                .antMatchers(GET, "/category").permitAll()
                .antMatchers(GET, "/category/{id}").permitAll()
                .antMatchers(POST, "/product").hasAuthority(CREATE_PRODUCT.toString())
                .antMatchers(PUT, "/product/{id}").hasAuthority(UPDATE_PRODUCT.toString())
                .antMatchers(GET, "/product/{id}").permitAll()
                .antMatchers(GET, "/product").permitAll()
                .antMatchers(GET, "/product/search").permitAll()
                .antMatchers(GET, "/product/category/{id}").permitAll()
                .antMatchers(GET, "/product/brand/{id}").permitAll()
                .antMatchers(POST, "/sku").hasAuthority(CREATE_SKU.toString())
                .antMatchers(PUT, "/sku/{code}").hasAuthority(UPDATE_SKU.toString())
                .antMatchers(GET, "/sku/{code}").permitAll()
                .antMatchers(GET, "/product_skus/{productId}").permitAll()
                .antMatchers(POST, "/order").hasAuthority(CHECKOUT_ORDER.toString())
                .antMatchers(GET, "/order/{customerId}").hasAuthority(GET_CUSTOMER_ORDERS.toString())
                .antMatchers(GET, "/order/ready-to-ship").hasAuthority(GET_ORDERS_READY_TO_SHIP.toString())
                .antMatchers(PATCH, "/order/{orderId}/update/{orderStatus}").hasAuthority(UPDATE_ORDER_STATUS.toString())
                .antMatchers(GET, "/actuator").permitAll()
                .antMatchers(GET, "/actuator/health").permitAll()
                .antMatchers(GET, "/actuator/env").permitAll()
                .antMatchers(GET, "/swagger-ui.html").permitAll()
                .antMatchers(GET, "/swagger-ui/**").permitAll()
                .antMatchers(GET, "/api-docs.yaml").permitAll()
                .antMatchers(GET, "/api-docs/**").permitAll()
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
