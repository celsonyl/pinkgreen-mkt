package br.com.pinkgreen.mkt.gateway.postgresql.repository;

import br.com.pinkgreen.mkt.gateway.postgresql.model.CategoryDatabase;
import br.com.pinkgreen.mkt.gateway.postgresql.model.CustomerCategoryIntentionsDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerCategoryIntentionsRepository extends JpaRepository<CustomerCategoryIntentionsDatabase, Integer> {

    @Modifying
    @Query(value = "INSERT INTO CUSTOMER_CATEGORY_INTENTIONS (CUSTOMER_ID, CATEGORY_ID) " +
            "VALUES (:customerId, :categoryId) ON CONFLICT (CUSTOMER_ID, CATEGORY_ID) DO " +
            "UPDATE SET COUNTER = CUSTOMER_CATEGORY_INTENTIONS.COUNTER + 1", nativeQuery = true)
    void upsertIntention(@Param("customerId") String customerId, @Param("categoryId") Integer categoryId);

    List<CustomerCategoryIntentionsDatabase> findAllByCustomerId(String customerId);
}
