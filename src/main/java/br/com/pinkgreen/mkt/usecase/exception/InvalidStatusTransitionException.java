package br.com.pinkgreen.mkt.usecase.exception;

import br.com.pinkgreen.mkt.domain.enums.OrderStatus;

public class InvalidStatusTransitionException extends RuntimeException {
    public InvalidStatusTransitionException(OrderStatus origin, OrderStatus destiny) {
        super("Is not possible to update order status from: " + origin + " to " + destiny);
    }
}
