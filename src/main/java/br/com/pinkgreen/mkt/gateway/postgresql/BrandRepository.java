package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.gateway.postgresql.model.BrandDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<BrandDatabase, Integer> {

    List<BrandDatabase> findByNameStartingWithIgnoreCase(String text);
}
