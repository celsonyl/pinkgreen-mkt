package br.com.pinkgreen.mkt.gateway.feign.model;

import br.com.pinkgreen.mkt.domain.CustomerDomain;

import java.util.List;
import java.util.Map;

public class UserKeycloakResponse {
    private String id;
    private Long createdTimestamp;
    private String username;
    private String firstName;
    private String lastName;
    private String email;
    private Map<String, List<String>> attributes;

    public UserKeycloakResponse(
            String id,
            Long createdTimestamp,
            String username,
            String firstName,
            String lastName,
            String email,
            Map<String, List<String>> attributes
    ) {
        this.id = id;
        this.createdTimestamp = createdTimestamp;
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.attributes = attributes;
    }

    public CustomerDomain toDomain() {
        return new CustomerDomain(
                id,
                firstName,
                lastName,
                attributes.get("CPF").get(0),
                email,
                attributes.get("phone").get(0)
        );
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getCreatedTimestamp() {
        return createdTimestamp;
    }

    public void setCreatedTimestamp(Long createdTimestamp) {
        this.createdTimestamp = createdTimestamp;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Map<String, List<String>> getAttributes() {
        return attributes;
    }

    public void setAttributes(Map<String, List<String>> attributes) {
        this.attributes = attributes;
    }

}
