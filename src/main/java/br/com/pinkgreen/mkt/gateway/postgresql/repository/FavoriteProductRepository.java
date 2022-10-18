package br.com.pinkgreen.mkt.gateway.postgresql.repository;

import br.com.pinkgreen.mkt.gateway.postgresql.model.FavoriteProductDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FavoriteProductRepository extends JpaRepository<FavoriteProductDatabase, Integer> {

    List<FavoriteProductDatabase> findAllByUserId(String customerId);

    @Query(value = "SELECT * FROM FAVORITE_PRODUCTS WHERE USER_ID = :customerId AND SKU_CODE = :skuCode", nativeQuery = true)
    FavoriteProductDatabase findByCustomerIdAndSkuCode(@Param("customerId") String customerId, @Param("skuCode") String skuCode);

    @Modifying
    @Query(value = "DELETE FROM FAVORITE_PRODUCTS WHERE USER_ID = :customerId AND SKU_CODE = :skuCode", nativeQuery = true)
    void deleteByCustomerIdAndSkuCode(@Param("customerId") String customerId, @Param("skuCode") String skuCode);
}
