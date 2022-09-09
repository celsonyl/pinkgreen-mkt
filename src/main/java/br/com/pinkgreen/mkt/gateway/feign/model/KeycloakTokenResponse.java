package br.com.pinkgreen.mkt.gateway.feign.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class KeycloakTokenResponse {

    @JsonProperty("access_token")
    private String accessToken;

    @JsonProperty("expires_in")
    private Integer expiresIn;

    @JsonProperty("refresh_expires_in")
    private Integer refreshExpiresIn;

    @JsonProperty("token_type")
    private String tokenType;

    @JsonProperty("not-before-policy")
    private Integer notBeforePolicy;

    private String scope;

    public KeycloakTokenResponse() { }

    public KeycloakTokenResponse(String accessToken, Integer expiresIn, Integer refreshExpiresIn, String tokenType, Integer notBeforePolicy, String scope) {
        this.accessToken = accessToken;
        this.expiresIn = expiresIn;
        this.refreshExpiresIn = refreshExpiresIn;
        this.tokenType = tokenType;
        this.notBeforePolicy = notBeforePolicy;
        this.scope = scope;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Integer getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Integer expiresIn) {
        this.expiresIn = expiresIn;
    }

    public Integer getRefreshExpiresIn() {
        return refreshExpiresIn;
    }

    public void setRefreshExpiresIn(Integer refreshExpiresIn) {
        this.refreshExpiresIn = refreshExpiresIn;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public Integer getNotBeforePolicy() {
        return notBeforePolicy;
    }

    public void setNotBeforePolicy(Integer notBeforePolicy) {
        this.notBeforePolicy = notBeforePolicy;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
}
