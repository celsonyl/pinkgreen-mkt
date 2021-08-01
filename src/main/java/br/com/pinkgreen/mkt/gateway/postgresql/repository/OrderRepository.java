package br.com.pinkgreen.mkt.gateway.postgresql.repository;

import br.com.pinkgreen.mkt.gateway.postgresql.model.OrderDatabase;
import br.com.pinkgreen.mkt.gateway.postgresql.model.SkuDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<OrderDatabase, Integer> {

    @Query(value = "SELECT * FROM orders WHERE customer_data ->> 'id' = :customerId", nativeQuery = true)
    List<OrderDatabase> findAllOrdersByCustomerId(@Param("customerId") String customerId);

}
