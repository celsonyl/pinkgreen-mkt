package br.com.pinkgreen.mkt.gateway.postgresql.repository;

import br.com.pinkgreen.mkt.gateway.postgresql.model.ProductDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductDatabase, Integer> {

    List<ProductDatabase> findByActiveTrue();

    Optional<ProductDatabase> findByIdAndActiveTrue(Integer id);

    @Query(value = "SELECT * FROM PRODUCT WHERE unaccent(name) ILIKE ('%' || unaccent(:text) || '%') AND ACTIVE = true", nativeQuery = true)
    List<ProductDatabase> findByName(@Param("text") String text);

    List<ProductDatabase> findAllByCategoriesIdAndActiveTrue(Integer id);

    List<ProductDatabase> findAllByBrandIdAndActiveTrue(Integer id);

    @Query(value = "SELECT * FROM PRODUCT P " +
            "INNER JOIN FAVORITE_PRODUCTS FP ON FP.PRODUCT_ID = P.ID " +
            " WHERE FP.USER_ID  = :userId " +
            " AND P.ACTIVE = true ", nativeQuery = true)
    List<ProductDatabase> getAllByUserId(@Param("userId") String id);

    @Modifying
    @Transactional
    @Query(value = "DELETE FROM FAVORITE_PRODUCTS WHERE USER_ID = :userId AND PRODUCT_ID = :productId", nativeQuery = true)
    void deleteFavoriteProduct(@Param("userId") String userId, @Param("productId") Integer productId);
}
