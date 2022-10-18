package br.com.pinkgreen.mkt.gateway.postgresql.model;

import br.com.pinkgreen.mkt.domain.FavoriteProductDomain;
import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity(name = "FAVORITE_PRODUCTS")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class FavoriteProductDatabase implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String userId;
    private String skuCode;

    public static FavoriteProductDatabase database(FavoriteProductDomain domain) {
        return new FavoriteProductDatabase(domain.getId(), domain.getUserId(), domain.getSkuCode());
    }

    public FavoriteProductDomain domain() {
        return new FavoriteProductDomain(id, userId, skuCode);
    }
}
