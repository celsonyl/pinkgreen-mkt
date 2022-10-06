package br.com.pinkgreen.mkt.config.security;

public enum Authorities {
    CREATE_CATEGORY,
    CREATE_BRAND,
    CREATE_PRODUCT,
    UPDATE_PRODUCT,
    CREATE_SKU,
    UPDATE_SKU,
    CHECKOUT_ORDER,
    GET_CUSTOMER_ORDERS,
    GET_ORDERS_READY_TO_SHIP,
    GET_CUSTOMER_FAVORITE_PRODUCTS,
    ADD_CUSTOMER_FAVORITE_PRODUCT,
    DELETE_CUSTOMER_FAVORITE_PRODUCT,
    UPDATE_ORDER_STATUS;

    @Override
    public String toString() {
        return this.name()
                .toLowerCase()
                .replaceAll("_", "-");
    }
}
