package br.com.pinkgreen.mkt.gateway.postgresql.repository;

import br.com.pinkgreen.mkt.gateway.postgresql.model.ProductEvaluationDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductEvaluationRepository extends JpaRepository<ProductEvaluationDatabase, Integer> {
    List<ProductEvaluationDatabase> findAllBySkuCode(String skuCode);
}
