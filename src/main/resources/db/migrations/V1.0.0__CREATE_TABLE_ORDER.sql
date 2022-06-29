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