package br.com.pinkgreen.mkt.gateway.postgresql.repository;

import br.com.pinkgreen.mkt.domain.enums.OrderStatus;
import br.com.pinkgreen.mkt.gateway.postgresql.model.OrderDatabase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderRepository extends JpaRepository<OrderDatabase, Integer> {

    @Query(value = "SELECT * FROM ORDERS WHERE CUSTOMER_DATA ->> 'id' = :customerId", nativeQuery = true)
    List<OrderDatabase> findAllOrdersByCustomerId(@Param("customerId") String customerId);

    @Query(value = "SELECT * FROM ORDERS WHERE PAYMENT_DATA ->> 'paymentId' = :paymentId", nativeQuery = true)
    Optional<OrderDatabase> findOrderByPaymentId(@Param("paymentId") String paymentId);

    List<OrderDatabase> findAllOrdersByStatus(OrderStatus orderStatus);
}
