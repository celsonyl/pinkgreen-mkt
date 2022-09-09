package br.com.pinkgreen.mkt.gateway.feign;

import br.com.pinkgreen.mkt.domain.CustomerDomain;
import br.com.pinkgreen.mkt.gateway.FindCustomerById;
import br.com.pinkgreen.mkt.gateway.feign.client.FindUserByIdOnKeycloakFeignApi;
import br.com.pinkgreen.mkt.gateway.feign.properties.KeycloakAdminProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FindCustomerByIdFeignImpl implements FindCustomerById {

    private final KeycloakAdminProperties properties;
    private final FindUserByIdOnKeycloakFeignApi findUserById;

    @Override
    public CustomerDomain execute(String customerId) {
        return findUserById.execute(properties.getUrl(), customerId).toDomain();
    }
}
