package br.com.pinkgreen.mkt.domain.enums;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;

public enum OrderStatus {
    ORDER_CANCELED,
    ORDER_SHIPPED,
    ORDER_EN_ROUTE(ORDER_SHIPPED),
    ORDER_IN_SEPARATION(ORDER_EN_ROUTE),
    ORDER_STOCK_FAILED(ORDER_CANCELED),
    ORDER_STOCK_RESERVED(ORDER_IN_SEPARATION),
    PAYMENT_CONFIRMED(ORDER_STOCK_RESERVED, ORDER_STOCK_FAILED),
    PAYMENT_REQUESTED(PAYMENT_CONFIRMED),
    ORDER_CREATED(PAYMENT_CONFIRMED, PAYMENT_REQUESTED);

    private final List<OrderStatus> supportedStatus;

    OrderStatus(OrderStatus... supportedStatus) {
        this.supportedStatus = asList(supportedStatus);
    }

    OrderStatus() {
        this.supportedStatus = emptyList();
    }

    public boolean isAbleToChange(OrderStatus newStatus) {
        return supportedStatus.stream().anyMatch(status -> status.equals(newStatus));
    }
}
