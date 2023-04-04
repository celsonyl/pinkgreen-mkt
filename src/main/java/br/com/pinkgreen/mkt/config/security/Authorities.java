package br.com.pinkgreen.mkt.config.security;

public enum Authorities {
    CREATE_CATEGORY, // Catalog Admin
    CREATE_BRAND, // Catalog Admin
    CREATE_PRODUCT, // Catalog Admin
    UPDATE_PRODUCT, // Catalog Admin
    CREATE_SKU, // Catalog Admin
    UPDATE_SKU, // Catalog Admin
    GET_ALL_SKUS, // Catalog Admin
    CHECKOUT_ORDER, // User
    GET_CUSTOMER_ORDERS, // User
    GET_CUSTOMER_FAVORITE_PRODUCTS, // User
    ADD_CUSTOMER_FAVORITE_PRODUCT, // User
    DELETE_CUSTOMER_FAVORITE_PRODUCT, // User
    ADD_PRODUCT_EVALUATION, // User
    GET_CUSTOMER_PRODUCTS_EVALUATIONS, // User
    GET_ALL_ORDERS, // Order administration
    GET_ORDER_BY_ID, // Order administration
    UPDATE_ORDER_STATUS;  // Order administration

    @Override
    public String toString() {
        return this.name()
                .toLowerCase()
                .replaceAll("_", "-");
    }
}
