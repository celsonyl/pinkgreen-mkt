package br.com.pinkgreen.mkt.gateway.postgresql.repository;

import br.com.pinkgreen.mkt.gateway.postgresql.model.SkuDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SkuRepository extends JpaRepository<SkuDatabase,Integer> {

    @Query(value = "SELECT * FROM PRODUCT_SKU WHERE SKU_CODE = :skuCode", nativeQuery = true)
    Optional<SkuDatabase> findSkuByCode(@Param("skuCode") String code);

    @Query(value = "SELECT * FROM PRODUCT_SKU WHERE PRODUCT_ID = :productId", nativeQuery = true)
    List<SkuDatabase> findAllByProductId(@Param("productId") Integer productId);
}
