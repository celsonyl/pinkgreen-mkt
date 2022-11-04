package br.com.pinkgreen.mkt.gateway.postgresql.repository;

import br.com.pinkgreen.mkt.gateway.postgresql.model.ProductEvaluationDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductEvaluationRepository extends JpaRepository<ProductEvaluationDatabase, Integer> {
    List<ProductEvaluationDatabase> findAllBySkuCode(String skuCode);
    List<ProductEvaluationDatabase> findAllByCustomerId(String customerId);
    List<ProductEvaluationDatabase> findAllByOrderId(Integer orderId);
    Optional<ProductEvaluationDatabase> findByOrderIdAndSkuCode(Integer orderId, String skuCode);
}
