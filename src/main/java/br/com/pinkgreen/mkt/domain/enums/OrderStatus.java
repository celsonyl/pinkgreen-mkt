package br.com.pinkgreen.mkt.domain.enums;

public enum OrderStatus {
    ORDER_CREATED,
    AWAITING_PAYMENT_CONFIRM,
    PAYMENT_CONFIRMED,
    ORDER_STOCK_RESERVED,
    ORDER_STOCK_FAILED,
}
