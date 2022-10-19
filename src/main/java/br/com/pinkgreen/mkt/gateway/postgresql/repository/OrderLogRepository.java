package br.com.pinkgreen.mkt.gateway.postgresql.repository;

import br.com.pinkgreen.mkt.gateway.postgresql.model.OrderLogDatabase;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderLogRepository extends JpaRepository<OrderLogDatabase, Integer> {

    List<OrderLogDatabase> findAllByOrderId(Integer orderId);

}
