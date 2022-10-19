package br.com.pinkgreen.mkt.gateway.postgresql.model;

import br.com.pinkgreen.mkt.domain.OrderHistoryDomain;
import br.com.pinkgreen.mkt.domain.enums.OrderStatus;
import lombok.*;

import javax.persistence.*;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

@Entity(name = "ORDERS_LOG")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class OrderLogDatabase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    private Integer orderId;
    private Instant createdAt;
    private Instant updatedAt;

    public static List<OrderHistoryDomain> domain(List<OrderLogDatabase> database) {
        return database.stream()
                .map(it -> it.domain())
                .collect(toList());
    }

    public OrderHistoryDomain domain() {
        return new OrderHistoryDomain(
                status,
                orderId,
                createdAt,
                updatedAt
        );
    }
}
