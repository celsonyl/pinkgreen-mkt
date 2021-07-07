package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.gateway.postgresql.model.BrandDatabase;
import br.com.pinkgreen.mkt.gateway.postgresql.model.SkuDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BrandRepository extends JpaRepository<BrandDatabase, Integer> {

    List<BrandDatabase> findByNameStartingWithIgnoreCase(String text);

    @Query(value = "SELECT * FROM product_brand WHERE name = :brand_name", nativeQuery = true)
    Optional<BrandDatabase> findBranddatabaseByName(@Param("brand_name") String name);
}
