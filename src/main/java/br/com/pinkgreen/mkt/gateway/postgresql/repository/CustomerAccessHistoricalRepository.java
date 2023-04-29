package br.com.pinkgreen.mkt.gateway.postgresql.repository;

import br.com.pinkgreen.mkt.gateway.postgresql.model.CustomerAccessHistoricalDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerAccessHistoricalRepository extends JpaRepository<CustomerAccessHistoricalDatabase, Integer> {

    @Modifying
    @Query(value = "INSERT INTO CUSTOMER_PRODUCT_ACCESS_HISTORICAL (CUSTOMER_ID, PRODUCT_ID) " +
            "VALUES (:customerId, :productId) ON CONFLICT (CUSTOMER_ID, PRODUCT_ID) DO " +
            "UPDATE SET LAST_ACCESS = NOW()", nativeQuery = true)
    void upsertAccessHistory(@Param("customerId") String customerId, @Param("productId") Integer productId);

    List<CustomerAccessHistoricalDatabase> findAllByCustomerId(String customerId);
}
