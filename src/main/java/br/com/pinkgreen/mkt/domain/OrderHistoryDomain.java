package br.com.pinkgreen.mkt.domain;

import br.com.pinkgreen.mkt.domain.enums.OrderStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderHistoryDomain {
    private OrderStatus status;
    private Integer orderId;
    private Instant createdAt;
    private Instant updatedAt;
}
