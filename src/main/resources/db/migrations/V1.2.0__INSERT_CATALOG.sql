insert into PRODUCT_BRAND (NAME, BRAND_IMAGE) values ('Acer', 'https://i.imgur.com/6wTcxmU.png');
insert into PRODUCT_BRAND (NAME, BRAND_IMAGE) values ('Apple', 'https://i.imgur.com/JdtpxX9.png');
insert into PRODUCT_BRAND (NAME, BRAND_IMAGE) values ('Samsung', 'https://i.imgur.com/OkgdSou.png');
insert into PRODUCT_BRAND (NAME, BRAND_IMAGE) values ('Electrolux', 'https://i.imgur.com/FNvvjre.png');
insert into PRODUCT_BRAND (NAME, BRAND_IMAGE) values ('Esmaltec', 'https://i.imgur.com/xrv55JQ.png');
insert into PRODUCT_BRAND (NAME, BRAND_IMAGE) values ('Xiaomi', 'https://i.imgur.com/7N2QBR1.png');

insert into PRODUCT_CATEGORY (NAME, IMAGE) values ('Informatica', 'https://i.imgur.com/PchRPP7.png');
insert into PRODUCT_CATEGORY (NAME, IMAGE) values ('Eletrodomésticos', 'https://i.imgur.com/Ye8Ecvoo.png');
insert into PRODUCT_CATEGORY (NAME, IMAGE) values ('Celulares e smartphones', 'https://i.imgur.com/m6VyNEE.png');

insert into PRODUCT (NAME, PRICE, ACTIVE, MAIN_IMAGE_URL, PRODUCT_BRAND_ID) values ('Notebook Aspire 5', 3704.05, true, 'https://i.imgur.com/PchRPP7.png', 1);
insert into PRODUCT (NAME, PRICE, ACTIVE, MAIN_IMAGE_URL, PRODUCT_BRAND_ID) values ('Galaxy S10e', 2400.00, true, 'https://i.imgur.com/dkR4vDn.png', 3);
insert into PRODUCT (NAME, PRICE, ACTIVE, MAIN_IMAGE_URL, PRODUCT_BRAND_ID) values ('Xiaomi MI 9', 1400.00, true, 'https://i.imgur.com/Bcme7Vy.png', 6);
insert into PRODUCT (NAME, PRICE, ACTIVE, MAIN_IMAGE_URL, PRODUCT_BRAND_ID) values ('TV Samsung 50"', 3000.00, true, 'https://i.imgur.com/QiBNHzb.png', 3);
insert into PRODUCT (NAME, PRICE, ACTIVE, MAIN_IMAGE_URL, PRODUCT_BRAND_ID) values ('Notebook Samsung Book', 3181.55, true, 'https://i.imgur.com/fzo9SWr.png', 3);
insert into PRODUCT (NAME, PRICE, ACTIVE, MAIN_IMAGE_URL, PRODUCT_BRAND_ID) values ('Samsung Galaxy A11', 999.00, true, 'https://i.imgur.com/b6XTUFP.png', 3);
insert into PRODUCT (NAME, PRICE, ACTIVE, MAIN_IMAGE_URL, PRODUCT_BRAND_ID) values ('iPhone 12 Pro Max', 9495.36, true, 'https://i.imgur.com/m6VyNEE.png', 2);
insert into PRODUCT (NAME, PRICE, ACTIVE, MAIN_IMAGE_URL, PRODUCT_BRAND_ID) values ('Micro-ondas', 659.00, true, 'https://i.imgur.com/Ye8Ecvo.png', 4);
insert into PRODUCT (NAME, PRICE, ACTIVE, MAIN_IMAGE_URL, PRODUCT_BRAND_ID) values ('Fogão de Piso 4 Bocas', 433.52, true, 'https://i.imgur.com/2dmMfQp.png', 5);

insert into PRODUCT_CATEGORIES (PRODUCT_ID, CATEGORY_ID) values (1, 1);
insert into PRODUCT_CATEGORIES (PRODUCT_ID, CATEGORY_ID) values (2, 3);
insert into PRODUCT_CATEGORIES (PRODUCT_ID, CATEGORY_ID) values (3, 3);
insert into PRODUCT_CATEGORIES (PRODUCT_ID, CATEGORY_ID) values (4, 2);
insert into PRODUCT_CATEGORIES (PRODUCT_ID, CATEGORY_ID) values (5, 1);
insert into PRODUCT_CATEGORIES (PRODUCT_ID, CATEGORY_ID) values (6, 3);
insert into PRODUCT_CATEGORIES (PRODUCT_ID, CATEGORY_ID) values (7, 3);
insert into PRODUCT_CATEGORIES (PRODUCT_ID, CATEGORY_ID) values (8, 2);
insert into PRODUCT_CATEGORIES (PRODUCT_ID, CATEGORY_ID) values (9, 2);

insert into PRODUCT_SKU (PRODUCT_ID, HEIGHT, LENGTH, MAIN_IMAGE_URL, NAME, PRICE, SKU_ATTRIBUTES, SKU_CODE, STOCK_QUANTITY, URL_IMAGES, WEIGHT, WIDTH) values (1, 10, 10, 'https://i.imgur.com/PchRPP7.png', 'Notebook Aspire 5 - Intel Core i3 - 4GB 256GB SSD 15,6” Full HD LED Windows 10','{"endDate": 1661996659.2356095, "listPrice": 3004.85, "salePrice": 1458.32, "startDate": 1661219059.2356095}', '[{"type": "memory", "label": "Memória RAM", "value": "4GB"}, {"type": "ssd", "label": "Capacidade do SSD", "value": "256GB de armazenamento SSD NVMe x4"}, {"type": "os", "label": "Sistema operacional", "value": "Windows 10 Home 64-bit"}]', 'A513-54-57EN', 10, '[]', 10, 10);
insert into PRODUCT_SKU (PRODUCT_ID, HEIGHT, LENGTH, MAIN_IMAGE_URL, NAME, PRICE, SKU_ATTRIBUTES, SKU_CODE, STOCK_QUANTITY, URL_IMAGES, WEIGHT, WIDTH) values (1, 10, 10, 'https://i.imgur.com/PchRPP7.png', 'Notebook Aspire 5 - Intel Core i5 - 8GB 256GB SSD 15,6” Full HD LED Windows 10', '{"endDate": 1623726000, "listPrice": 3704.05, "salePrice": 0.0, "startDate": 1623726000}', '[{"type": "memory", "label": "Memória RAM", "value": "8GB"}, {"type": "ssd", "label": "Capacidade do SSD", "value": "256GB de armazenamento SSD NVMe x4"}, {"type": "os", "label": "Sistema operacional", "value": "Windows 10 Home 64-bit"}]', 'A515-54-57EN', 10, '[]', 10, 10);
insert into PRODUCT_SKU (PRODUCT_ID, HEIGHT, LENGTH, MAIN_IMAGE_URL, NAME, PRICE, SKU_ATTRIBUTES, SKU_CODE, STOCK_QUANTITY, URL_IMAGES, WEIGHT, WIDTH) values (1, 10, 10, 'https://i.imgur.com/PchRPP7.png', 'Notebook Aspire 5 - Intel Core i7 - 16GB 480GB SSD 15,6” Full HD LED Windows 10', '{"endDate": 1661996659.2356095, "listPrice": 3904.05, "salePrice": 2556.89, "startDate": 1661219059.2356095}', '[{"type": "memory", "label": "Memória RAM", "value": "16GB"}, {"type": "ssd", "label": "Capacidade do SSD", "value": "480GB de armazenamento SSD NVMe x4"}, {"type": "os", "label": "Sistema operacional", "value": "Windows 10 Home 64-bit"}]' , 'A517-54-57EN', 10, '[]', 10, 10);
insert into PRODUCT_SKU (PRODUCT_ID, HEIGHT, LENGTH, MAIN_IMAGE_URL, NAME, PRICE, SKU_ATTRIBUTES, SKU_CODE, STOCK_QUANTITY, URL_IMAGES, WEIGHT, WIDTH) values (2, 12, 9, 'https://i.imgur.com/dkR4vDn.png', 'Galaxy S10e - 128GB Tela 15,6” Full HD LED','{"endDate": 1623726000, "listPrice": 2709.09, "salePrice": 0.0, "startDate": 1623726000}', '[{"type": "memory", "label": "Memória RAM", "value": "6GB"}, {"type": "HD", "label": "Capacidade de Armazenamento", "value": "256GB de armazenamento"}]','B125-B7-EF2N', 5, '[]', 10, 19);
insert into PRODUCT_SKU (PRODUCT_ID, HEIGHT, LENGTH, MAIN_IMAGE_URL, NAME, PRICE, SKU_ATTRIBUTES, SKU_CODE, STOCK_QUANTITY, URL_IMAGES, WEIGHT, WIDTH) values (3, 12, 9, 'https://i.imgur.com/Bcme7Vy.png', 'Xiaomi Mi9 - 64GB Tela 12,6” Quad HD LED', '{ "endDate": 1623726000, "listPrice": 1200.0, "salePrice": 0.0, "startDate": 1623726000 }', '[{"type": "memory", "label": "Memória RAM", "value": "8GB"}, {"type": "HD", "label": "Capacidade de Armazenamento", "value": "128GB de armazenamento"}]', 'CD12-H7-24FDF', 20, '[]', 10, 20);
insert into PRODUCT_SKU (PRODUCT_ID, HEIGHT, LENGTH, MAIN_IMAGE_URL, NAME, PRICE, SKU_ATTRIBUTES, SKU_CODE, STOCK_QUANTITY, URL_IMAGES, WEIGHT, WIDTH) values (4, 100, 10, 'https://i.imgur.com/QiBNHzb.png', 'Smart TV 50” Crystal 4K Samsung 50AU7700 - Wi-Fi Bluetooth HDR Alexa Built in 3 HDMI 1 USB', '{ "endDate": 1623726000, "listPrice": 3704.05, "salePrice": 0.0, "startDate": 1623726000 }','[{"type": "memory", "label": "Memória RAM", "value": "2GB"}, {"type": "ssd", "label": "Capacidade do SSD", "value": "20GB de armazenamento SSD NVMe x4"}, {"type": "os", "label": "Sistema operacional", "value": "Alexa Build"}]', 'AFRQF5-DWW-12EN', 5, '[]', 10, 50);
insert into PRODUCT_SKU (PRODUCT_ID, HEIGHT, LENGTH, MAIN_IMAGE_URL, NAME, PRICE, SKU_ATTRIBUTES, SKU_CODE, STOCK_QUANTITY, URL_IMAGES, WEIGHT, WIDTH) values (5, 10, 10, 'https://i.imgur.com/PchRPP7.png', 'Notebook Samsung Book - Intel Core i3 - 4GB 256GB SSD 15,6” Full HD LED Windows 10', '{"endDate": 1661478259.2366135, "listPrice": 4299.0, "salePrice": 3181.55, "startDate": 1661305459.2366135}', '[]' , 'NP550XDA-KT3BR', 10, '[]', 10, 10);
insert into PRODUCT_SKU (PRODUCT_ID, HEIGHT, LENGTH, MAIN_IMAGE_URL, NAME, PRICE, SKU_ATTRIBUTES, SKU_CODE, STOCK_QUANTITY, URL_IMAGES, WEIGHT, WIDTH) values (7, 10, 10, 'https://i.imgur.com/m6VyNEE.png', 'iPhone 12 Pro Max Dourado, com Tela de 6,7”, 5G, 128 GB e Câmera Tripla de 12MP', '{"endDate": 1623985200, "listPrice": 9495.36, "salePrice": 4500.98, "startDate": 1623726000}', '[]', 'MGD93BZA', 10, '[]', 10, 10);
insert into PRODUCT_SKU (PRODUCT_ID, HEIGHT, LENGTH, MAIN_IMAGE_URL, NAME, PRICE, SKU_ATTRIBUTES, SKU_CODE, STOCK_QUANTITY, URL_IMAGES, WEIGHT, WIDTH) values (9, 10, 10, 'https://i.imgur.com/2dmMfQp.png', 'Fogão de Piso 4 Bocas Esmaltec', '{"endDate": 1661391855.383617, "listPrice": 433.52, "salePrice": 0.0, "startDate": 1661391855.383617}', '[]', '1589663525', 10, '[]', 10, 10);
