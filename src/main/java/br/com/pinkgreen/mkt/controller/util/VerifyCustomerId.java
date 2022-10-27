package br.com.pinkgreen.mkt.controller.util;

import br.com.pinkgreen.mkt.domain.exception.InvalidCustomerIdException;
import org.springframework.security.oauth2.server.resource.authentication.JwtAuthenticationToken;

public class VerifyCustomerId {

    public static String getCustomerIdAndValidate(JwtAuthenticationToken authenticationToken, String customerId) throws InvalidCustomerIdException {
        String tokenCustomerId = authenticationToken.getToken().getSubject();

        if (!customerId.equals(tokenCustomerId)) {
            throw new InvalidCustomerIdException("[CONTROLLER] Invalid customerId");
        }

        return tokenCustomerId;
    }
}
