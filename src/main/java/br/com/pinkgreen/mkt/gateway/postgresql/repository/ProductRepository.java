package br.com.pinkgreen.mkt.gateway.postgresql.repository;

import br.com.pinkgreen.mkt.gateway.postgresql.model.ProductDatabase;
import br.com.pinkgreen.mkt.gateway.postgresql.model.SkuDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

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
}
