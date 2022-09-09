package br.com.pinkgreen.mkt.gateway.feign.model;

import java.util.HashMap;
import java.util.Map;

public class KeycloakTokenRequest {
    private final String grantType;
    private final String clientId;
    private final String clientSecret;

    public KeycloakTokenRequest(String grantType, String clientId, String clientSecret) {
        this.grantType = grantType;
        this.clientId = clientId;
        this.clientSecret = clientSecret;
    }

    public Map<String, String> toMap() {
        HashMap<String, String> map = new HashMap<>();
        map.put("grant_type", grantType);
        map.put("client_id", clientId);
        map.put("client_secret", clientSecret);
        return map;
    }
}
