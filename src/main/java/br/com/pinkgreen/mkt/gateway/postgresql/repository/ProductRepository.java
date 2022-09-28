package br.com.pinkgreen.mkt.gateway.postgresql.repository;

import br.com.pinkgreen.mkt.gateway.postgresql.model.ProductDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductDatabase, Integer> {

    List<ProductDatabase> findByActiveTrue();

    Optional<ProductDatabase> findByIdAndActiveTrue(Integer id);

    List<ProductDatabase> findByNameContainsIgnoreCaseAndActiveTrue(String text);

    List<ProductDatabase> findAllByCategoriesIdAndActiveTrue(Integer id);

    List<ProductDatabase> findAllByBrandIdAndActiveTrue(Integer id);
}
