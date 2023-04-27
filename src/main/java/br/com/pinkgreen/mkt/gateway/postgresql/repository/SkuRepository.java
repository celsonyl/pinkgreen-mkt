package br.com.pinkgreen.mkt.gateway.postgresql.repository;

import br.com.pinkgreen.mkt.gateway.postgresql.model.SkuDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SkuRepository extends JpaRepository<SkuDatabase, Integer> {

    @Query(value = "SELECT * FROM PRODUCT_SKU WHERE SKU_CODE = :skuCode", nativeQuery = true)
    Optional<SkuDatabase> findSkuByCode(@Param("skuCode") String code);

    @Query(value =
            "SELECT * FROM PRODUCT_SKU PS " +
                    "INNER JOIN PRODUCT P ON P.ID = PS.PRODUCT_ID " +
                    "WHERE PRODUCT_ID = :productId ", nativeQuery = true)
    List<SkuDatabase> findAllSkuByProductId(@Param("productId") Integer productId);

    @Query(value =
            "SELECT * FROM PRODUCT_SKU PS " +
                    "INNER JOIN PRODUCT P ON P.ID = PS.PRODUCT_ID " +
                    "WHERE PS.SKU_CODE = :skuCode " +
                    "AND PS.ACTIVE = true " +
                    "AND P.ACTIVE = true", nativeQuery = true)
    Optional<SkuDatabase> findActiveSkuByCode(@Param("skuCode") String code);

    @Query(value =
            "SELECT * FROM PRODUCT_SKU PS " +
                    "INNER JOIN PRODUCT P ON P.ID = PS.PRODUCT_ID " +
                    "WHERE PRODUCT_ID = :productId " +
                    "AND PS.ACTIVE = true " +
                    "AND P.ACTIVE = true", nativeQuery = true)
    List<SkuDatabase> findAllActiveSkuByProductId(@Param("productId") Integer productId);

    @Query(value = "SELECT * FROM PRODUCT_SKU PS WHERE PS.SKU_CODE IN (" +
            "SELECT P.\"skuCode\" FROM ORDERS O " +
            "JOIN LATERAL jsonb_to_recordset(O.PRODUCT_LIST) AS P(\"skuCode\" TEXT, \"quantity\" INTEGER) ON TRUE " +
            "GROUP BY P.\"skuCode\" " +
            "ORDER BY SUM(p.\"quantity\") DESC)", nativeQuery = true)
    List<SkuDatabase> findMostSelled();

    @Modifying
    @Query(value = "UPDATE PRODUCT_SKU SET STOCK_QUANTITY = STOCK_QUANTITY + :quantity WHERE SKU_CODE = :skuCode", nativeQuery = true)
    void appendStockQuantityBySkuCode(@Param("skuCode") String code, @Param("quantity") Integer quantity);
}
