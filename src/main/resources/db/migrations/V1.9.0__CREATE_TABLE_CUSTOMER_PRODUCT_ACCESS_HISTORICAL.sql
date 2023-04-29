CREATE TABLE CUSTOMER_PRODUCT_ACCESS_HISTORICAL
(
    ID                  SERIAL          PRIMARY KEY,
    CUSTOMER_ID         VARCHAR(255)    NOT NULL,
    PRODUCT_ID          INTEGER         NOT NULL,
    LAST_ACCESS         timestamptz     DEFAULT NOW(),
    FOREIGN KEY (PRODUCT_ID) REFERENCES PRODUCT (ID) ON DELETE CASCADE
);
CREATE UNIQUE INDEX on CUSTOMER_PRODUCT_ACCESS_HISTORICAL (CUSTOMER_ID, PRODUCT_ID);
