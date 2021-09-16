package br.com.pinkgreen.mkt.domain.enums;

import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;

public enum OrderStatus {
    ORDER_CANCELED,
    ORDER_IN_SEPARATION,
    ORDER_STOCK_FAILED(ORDER_CANCELED),
    ORDER_STOCK_RESERVED(ORDER_IN_SEPARATION),
    AWAITING_PAYMENT_CONFIRM(ORDER_STOCK_RESERVED, ORDER_STOCK_FAILED),
    ORDER_CREATED(AWAITING_PAYMENT_CONFIRM);

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
