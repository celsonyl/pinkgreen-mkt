package br.com.pinkgreen.mkt.gateway.postgresql.repository;

import br.com.pinkgreen.mkt.gateway.postgresql.model.BrandDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<BrandDatabase, Integer> {

    @Query(value = "SELECT * FROM PRODUCT_BRAND WHERE unaccent(name) ILIKE ('%' || unaccent(:text) || '%')", nativeQuery = true)
    List<BrandDatabase> findByName(@Param("text") String text);
}
