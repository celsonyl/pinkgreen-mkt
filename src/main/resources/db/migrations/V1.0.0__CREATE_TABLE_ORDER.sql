create TABLE ORDERS
(
    ID            SERIAL PRIMARY KEY,
    CUSTOMER_DATA jsonb,
    PAYMENT_DATA  jsonb,
    PRODUCT_LIST  jsonb,
    SHIPPING_DATA jsonb,
    STATUS        VARCHAR(255),
    UPDATED_AT    timestamptz,
    CREATED_AT    timestamptz
);

create TABLE ORDERS_LOG
(
    ID       SERIAL PRIMARY KEY,
    ORDER_ID INTEGER NOT NULL,
    STATUS   VARCHAR(255),
    UPDATED_AT timestamptz,
    CREATED_AT timestamptz,
    FOREIGN KEY (ORDER_ID) REFERENCES ORDERS (ID)
)