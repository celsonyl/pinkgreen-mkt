package br.com.pinkgreen.mkt.controller.model;

import br.com.pinkgreen.mkt.domain.OrderHistoryDomain;
import br.com.pinkgreen.mkt.domain.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

import static java.util.stream.Collectors.toList;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderHistoryResponse {
    private OrderStatus status;
    private Integer orderId;
    private Instant createdAt;
    private Instant updatedAt;

    public static List<OrderHistoryResponse> fromDomain(List<OrderHistoryDomain> domain) {
        return (domain == null) ? null : domain.stream()
                .map(OrderHistoryResponse::fromDomain)
                .collect(toList());
    }

    public static OrderHistoryResponse fromDomain(OrderHistoryDomain domain) {
        return new OrderHistoryResponse(
                domain.getStatus(),
                domain.getOrderId(),
                domain.getCreatedAt(),
                domain.getUpdatedAt()
        );
    }
}
