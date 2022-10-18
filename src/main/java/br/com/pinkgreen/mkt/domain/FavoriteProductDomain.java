package br.com.pinkgreen.mkt.domain;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class FavoriteProductDomain implements Serializable {

    private Integer id;
    private String userId;
    private String skuCode;

    public FavoriteProductDomain(String userId, String skuCode) {
        this.userId = userId;
        this.skuCode = skuCode;
    }
}
