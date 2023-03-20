package br.com.pinkgreen.mkt.gateway.postgresql.repository;

import br.com.pinkgreen.mkt.gateway.postgresql.model.IProductEvaluationMetadata;
import br.com.pinkgreen.mkt.gateway.postgresql.model.ProductEvaluationDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductEvaluationRepository extends JpaRepository<ProductEvaluationDatabase, Integer> {
    List<ProductEvaluationDatabase> findAllBySkuCode(String skuCode);

    @Query(
            value = "SELECT COALESCE(ROUND(AVG(STARS), 2), 0) AS average, COUNT(SKU_CODE) AS count " +
                    "FROM PRODUCT_EVALUATIONS WHERE sku_code = :skuCode",
            nativeQuery = true
    )
    IProductEvaluationMetadata findProductMetadata(@Param("skuCode") String skuCode);

    List<ProductEvaluationDatabase> findAllByCustomerId(String customerId);
    List<ProductEvaluationDatabase> findAllByOrderId(Integer orderId);
    Optional<ProductEvaluationDatabase> findByOrderIdAndSkuCode(Integer orderId, String skuCode);
}
