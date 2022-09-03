CREATE TABLE orders
(
    id            SERIAL PRIMARY KEY,
    customer_data jsonb,
    payment_data  jsonb,
    product_list  jsonb,
    shipping_data jsonb,
    status        VARCHAR(255),
    updated_at    timestamptz,
    created_at    timestamptz
);

CREATE TABLE orders_log
(
    id       SERIAL PRIMARY KEY,
    order_id INTEGER NOT NULL,
    status   VARCHAR(255),
    updated_at timestamptz,
    createdAt timestamptz,
    FOREIGN KEY (order_id) REFERENCES orders (id)
)