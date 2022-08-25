CREATE TABLE product_brand
(
    id   SERIAL PRIMARY KEY,
    name VARCHAR(255),
    brand_image VARCHAR(255)
);
CREATE UNIQUE INDEX product_brand_name_idx on product_brand (name);

CREATE TABLE product
(
    id               SERIAL PRIMARY KEY,
    active           BOOLEAN,
    main_image_url   VARCHAR(255),
    name             VARCHAR(255),
    price            DOUBLE PRECISION,
    product_brand_id INTEGER,
    FOREIGN KEY (product_brand_id) REFERENCES product_brand (id)
);

CREATE TABLE product_category
(
    id    SERIAL PRIMARY KEY,
    image VARCHAR(255),
    name  VARCHAR(255)
);
CREATE UNIQUE INDEX product_category_name_idx on product_category (name);

CREATE TABLE product_categories
(
    product_id  INTEGER NOT NULL,
    category_id INTEGER NOT NULL,
    FOREIGN KEY (product_id) REFERENCES product (id),
    FOREIGN KEY (category_id) REFERENCES product_category (id)
);

CREATE TABLE product_sku
(
    id             SERIAL PRIMARY KEY,
    height         DOUBLE PRECISION,
    length         DOUBLE PRECISION,
    main_image_url VARCHAR(255),
    name           VARCHAR(255),
    price          jsonb,
    sku_attributes jsonb,
    sku_code       VARCHAR(255),
    stock_quantity INTEGER,
    url_images     jsonb,
    weight         DOUBLE PRECISION,
    width          DOUBLE PRECISION,
    product_id     INTEGER,
    FOREIGN KEY (product_id) REFERENCES product (id)
);
CREATE UNIQUE INDEX product_sku_code_idx on product_sku (sku_code);