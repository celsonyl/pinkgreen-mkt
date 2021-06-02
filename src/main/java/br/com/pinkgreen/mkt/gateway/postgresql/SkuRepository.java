package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.gateway.postgresql.model.SkuDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SkuRepository extends JpaRepository<SkuDatabase,Integer> {

    @Query(value = "SELECT * FROM product_sku WHERE sku_code = :skuCode", nativeQuery = true)
    Optional<SkuDatabase> findSkuDatabaseByName(@Param("skuCode") String code);

}
