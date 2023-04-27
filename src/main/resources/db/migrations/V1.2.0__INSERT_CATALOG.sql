insert into PRODUCT_BRAND (NAME, BRAND_IMAGE) values ('Acer', 'https://i.imgur.com/6wTcxmU.png');
insert into PRODUCT_BRAND (NAME, BRAND_IMAGE) values ('Apple', 'https://i.imgur.com/JdtpxX9.png');
insert into PRODUCT_BRAND (NAME, BRAND_IMAGE) values ('Samsung', 'https://i.imgur.com/OkgdSou.png');
insert into PRODUCT_BRAND (NAME, BRAND_IMAGE) values ('Electrolux', 'https://i.imgur.com/FNvvjre.png');
insert into PRODUCT_BRAND (NAME, BRAND_IMAGE) values ('Esmaltec', 'https://i.imgur.com/xrv55JQ.png');
insert into PRODUCT_BRAND (NAME, BRAND_IMAGE) values ('Xiaomi', 'https://i.imgur.com/7N2QBR1.png');

insert into PRODUCT_CATEGORY (NAME, IMAGE) values ('Informatica', 'https://i.imgur.com/PchRPP7.png');
insert into PRODUCT_CATEGORY (NAME, IMAGE) values ('Eletrodomésticos', 'https://i.imgur.com/hXDg30e.png');
insert into PRODUCT_CATEGORY (NAME, IMAGE) values ('Celulares e smartphones', 'https://i.imgur.com/m6VyNEE.png');

insert into PRODUCT (NAME, PRICE, ACTIVE, MAIN_IMAGE_URL, PRODUCT_BRAND_ID) values ('Notebook Aspire 5', 3099.99, true, 'https://i.imgur.com/ZwzTflF.png', 1);
insert into PRODUCT (NAME, PRICE, ACTIVE, MAIN_IMAGE_URL, PRODUCT_BRAND_ID) values ('Galaxy S10e', 2999.00, true, 'https://i.imgur.com/dkR4vDn.png', 3);
insert into PRODUCT (NAME, PRICE, ACTIVE, MAIN_IMAGE_URL, PRODUCT_BRAND_ID) values ('Xiaomi MI 9', 1200.0, true, 'https://i.imgur.com/Bcme7Vy.png', 6);
insert into PRODUCT (NAME, PRICE, ACTIVE, MAIN_IMAGE_URL, PRODUCT_BRAND_ID) values ('Smart TV Samsung 50"', 2999.00, true, 'https://i.imgur.com/Ic0KAXB.png', 3);
insert into PRODUCT (NAME, PRICE, ACTIVE, MAIN_IMAGE_URL, PRODUCT_BRAND_ID) values ('Notebook Samsung Book', 4299.00, true, 'https://i.imgur.com/fzo9SWr.png', 3);
insert into PRODUCT (NAME, PRICE, ACTIVE, MAIN_IMAGE_URL, PRODUCT_BRAND_ID) values ('Samsung Galaxy A11', 999.00, true, 'https://i.imgur.com/b6XTUFP.png', 3);
insert into PRODUCT (NAME, PRICE, ACTIVE, MAIN_IMAGE_URL, PRODUCT_BRAND_ID) values ('iPhone 12 Pro Max', 9499.00, true, 'https://i.imgur.com/m6VyNEE.png', 2);
insert into PRODUCT (NAME, PRICE, ACTIVE, MAIN_IMAGE_URL, PRODUCT_BRAND_ID) values ('Micro-ondas Electrolux Prata Efficient 23L', 1819.00, true, 'https://i.imgur.com/hXDg30e.png', 4);
insert into PRODUCT (NAME, PRICE, ACTIVE, MAIN_IMAGE_URL, PRODUCT_BRAND_ID) values ('Fogão de Piso 4 Bocas', 430.00, true, 'https://i.imgur.com/UGbiTod.png', 5);

insert into PRODUCT_CATEGORIES (PRODUCT_ID, CATEGORY_ID) values (1, 1);
insert into PRODUCT_CATEGORIES (PRODUCT_ID, CATEGORY_ID) values (2, 3);
insert into PRODUCT_CATEGORIES (PRODUCT_ID, CATEGORY_ID) values (3, 3);
insert into PRODUCT_CATEGORIES (PRODUCT_ID, CATEGORY_ID) values (4, 2);
insert into PRODUCT_CATEGORIES (PRODUCT_ID, CATEGORY_ID) values (5, 1);
insert into PRODUCT_CATEGORIES (PRODUCT_ID, CATEGORY_ID) values (6, 3);
insert into PRODUCT_CATEGORIES (PRODUCT_ID, CATEGORY_ID) values (7, 3);
insert into PRODUCT_CATEGORIES (PRODUCT_ID, CATEGORY_ID) values (8, 2);
insert into PRODUCT_CATEGORIES (PRODUCT_ID, CATEGORY_ID) values (9, 2);

insert into PRODUCT_SKU (PRODUCT_ID, MAIN_IMAGE_URL, NAME, PRICE, SKU_ATTRIBUTES, SKU_CODE, STOCK_QUANTITY, URL_IMAGES, WEIGHT, HEIGHT, LENGTH, WIDTH, ACTIVE, INDEX) values (1, 'https://i.imgur.com/ZwzTflF.png', 'Notebook Aspire 5 - Intel Core i3 - 4GB RAM 256GB SSD','{"endDate": 1661996659.2356095, "listPrice": 3099.99, "salePrice": 2479.99, "startDate": 1661219059.2356095}', '[{"type": "cpu", "label": "Processador", "value": "Intel® Core™ i3"}, {"type": "gpu", "label": "Placa de vídeo", "value": "Intel® UHD Graphics de 10th"}, {"type": "memory", "label": "Memória RAM", "value": "4GB"}, {"type": "ssd", "label": "Capacidade do SSD", "value": "256 GB"}, {"type": "os", "label": "Sistema operacional", "value": "Windows 10 Home 32-bit"}, {"type": "screenSize", "label": "Tamanho da Tela", "value": "15,6”"}, {"type": "keyboard", "label": "Teclado", "value": "Português do Brasil no padrão ABNT 2"}, {"type": "observation", "label": "Observação", "value": "Este produto não possui leitor de CD/DVD<br>GPU e CPU são soldadas na máquina."}, {"type": "included", "label": "Conteúdo da Embalagem", "value": "Notebook Acer Aspire 5<br>Fonte carregadora do notebook<br>Manual em português<br>Termo de garantia"}]', 'acer-aspire-5-core-i3-256gb-4gb-ram', 10, '["https://i.imgur.com/dywTwwz.png", "https://i.imgur.com/NUHgUIM.png", "https://i.imgur.com/8twbuLG.png", "https://i.imgur.com/5YKqfAN.png"]', 1800, 1.79, 36.34, 25.05, true, 1);
insert into PRODUCT_SKU (PRODUCT_ID, MAIN_IMAGE_URL, NAME, PRICE, SKU_ATTRIBUTES, SKU_CODE, STOCK_QUANTITY, URL_IMAGES, WEIGHT, HEIGHT, LENGTH, WIDTH, ACTIVE, INDEX) values (1, 'https://i.imgur.com/ZwzTflF.png', 'Notebook Aspire 5 - Intel Core i5 - 8GB RAM 256GB SSD', '{"endDate": 1623726000, "listPrice": 3799.00, "salePrice": 2759.08, "startDate": 1623726000}', '[{"type": "cpu", "label": "Processador", "value": "Intel® Core™ i5"}, {"type": "gpu", "label": "Placa de vídeo", "value": "Intel® UHD Graphics de 10th"}, {"type": "memory", "label": "Memória RAM", "value": "8GB"}, {"type": "ssd", "label": "Capacidade do SSD", "value": "256GB"}, {"type": "os", "label": "Sistema operacional", "value": "Windows 10 Home 64-bit"}, {"type": "screenSize", "label": "Tamanho da Tela", "value": "15,6”"}, {"type": "keyboard", "label": "Teclado", "value": "Português do Brasil no padrão ABNT 2"}, {"type": "observation", "label": "Observação", "value": "Este produto não possui leitor de CD/DVD<br>GPU e CPU são soldadas na máquina."}, {"type": "included", "label": "Conteúdo da Embalagem", "value": "Notebook Acer Aspire 5<br>Fonte carregadora do notebook<br>Manual em português<br>Termo de garantia"}]', 'acer-aspire-5-core-i5-256gb-8gb-ram', 10, '["https://i.imgur.com/dywTwwz.png", "https://i.imgur.com/NUHgUIM.png", "https://i.imgur.com/8twbuLG.png", "https://i.imgur.com/5YKqfAN.png"]', 1800, 1.79, 36.34, 25.05, true, 2);
insert into PRODUCT_SKU (PRODUCT_ID, MAIN_IMAGE_URL, NAME, PRICE, SKU_ATTRIBUTES, SKU_CODE, STOCK_QUANTITY, URL_IMAGES, WEIGHT, HEIGHT, LENGTH, WIDTH, ACTIVE, INDEX) values (1, 'https://i.imgur.com/ZwzTflF.png', 'Notebook Aspire 5 - Intel Core i7 - 16GB RAM 480GB SSD', '{"endDate": 1661996659.2356095, "listPrice": 4999.00, "salePrice": 4231.08, "startDate": 1661219059.2356095}', '[{"type": "cpu", "label": "Processador", "value": "Intel® Core™ i7"}, {"type": "gpu", "label": "Placa de vídeo", "value": "Intel® UHD Graphics de 10th"}, {"type": "memory", "label": "Memória RAM", "value": "16GB"}, {"type": "ssd", "label": "Capacidade do SSD", "value": "480GB"}, {"type": "os", "label": "Sistema operacional", "value": "Windows 10 Home 64-bit"}, {"type": "screenSize", "label": "Tamanho da Tela", "value": "15,6”"}, {"type": "keyboard", "label": "Teclado", "value": "Português do Brasil no padrão ABNT 2"}, {"type": "observation", "label": "Observação", "value": "Este produto não possui leitor de CD/DVD<br>GPU e CPU são soldadas na máquina."}, {"type": "included", "label": "Conteúdo da Embalagem", "value": "Notebook Acer Aspire 5<br>Fonte carregadora do notebook<br>Manual em português<br>Termo de garantia"}]' , 'acer-aspire-5-core-i7-480gb-16gb-ram', 10, '["https://i.imgur.com/dywTwwz.png", "https://i.imgur.com/NUHgUIM.png", "https://i.imgur.com/8twbuLG.png", "https://i.imgur.com/5YKqfAN.png"]', 1800, 1.79, 36.34, 25.05, true, 3);

insert into PRODUCT_SKU (PRODUCT_ID, MAIN_IMAGE_URL, NAME, PRICE, SKU_ATTRIBUTES, SKU_CODE, STOCK_QUANTITY, URL_IMAGES, WEIGHT, HEIGHT, LENGTH, WIDTH, ACTIVE, INDEX) values (2, 'https://i.imgur.com/dkR4vDn.png', 'Galaxy S10e - 128GB Branco','{"endDate": 1623726000, "listPrice": 2999.00, "salePrice": 0.0, "startDate": 1623726000}', '[{"type": "color", "label": "Cor", "value": "Branco"}, {"type": "cpu", "label": "Processador", "value": "4x 1.95 GHz Cortex-A55 + 2x 2.3 GHz Cortex-A75 + 2x 2.7 GHz M4"}, {"type": "gpu", "label": "Placa de vídeo", "value": "Mali-G76 MP12"}, {"type": "memory", "label": "Memória RAM", "value": "6GB"}, {"type": "hd", "label": "Capacidade de Armazenamento", "value": "128GB"}, {"type": "os", "label": "Sistema operacional", "value": "Android 11 Samsung One UI 3.0"}, {"type": "screenSize", "label": "Tamanho da Tela", "value": "5,8”"}, {"type": "simCardQtd", "label": "Quantidade de Chips", "value": "Dual Chip"}]','samsung-galaxy-s10e-128gb-branco-6gb-ram', 10, '["https://i.imgur.com/ZiZIxiO.png", "https://i.imgur.com/8BKFFPV.png", "https://i.imgur.com/lw1yjTO.png", "https://i.imgur.com/qr3PQl0.png", "https://i.imgur.com/ohz71m7.png", "https://i.imgur.com/RqEt07P.png"]', 150, 14.22, 6.99, 0.79, true, 1);
insert into PRODUCT_SKU (PRODUCT_ID, MAIN_IMAGE_URL, NAME, PRICE, SKU_ATTRIBUTES, SKU_CODE, STOCK_QUANTITY, URL_IMAGES, WEIGHT, HEIGHT, LENGTH, WIDTH, ACTIVE, INDEX) values (2, 'https://i.imgur.com/qcA0Cme.png', 'Galaxy S10e - 128GB Preto','{"endDate": 1623726000, "listPrice": 3499.00, "salePrice": 0.0, "startDate": 1623726000}', '[{"type": "color", "label": "Cor", "value": "Preto"}, {"type": "cpu", "label": "Processador", "value": "4x 1.95 GHz Cortex-A55 + 2x 2.3 GHz Cortex-A75 + 2x 2.7 GHz M4"}, {"type": "gpu", "label": "Placa de vídeo", "value": "Mali-G76 MP12"}, {"type": "memory", "label": "Memória RAM", "value": "6GB"}, {"type": "hd", "label": "Capacidade de Armazenamento", "value": "128GB"}, {"type": "os", "label": "Sistema operacional", "value": "Android 11 Samsung One UI 3.0"}, {"type": "screenSize", "label": "Tamanho da Tela", "value": "5,8”"}, {"type": "simCardQtd", "label": "Quantidade de Chips", "value": "Dual Chip"}]','samsung-galaxy-s10e-128gb-preto-6gb-ram', 10, '["https://i.imgur.com/Y99PNgO.png", "https://i.imgur.com/oiCwAPB.png", "https://i.imgur.com/fhWMdo6.png", "https://i.imgur.com/E95t0Dv.png", "https://i.imgur.com/tlhfDfJ.png", "https://i.imgur.com/GR19bKh.png"]', 150, 14.22, 6.99, 0.79, true, 2);

insert into PRODUCT_SKU (PRODUCT_ID, MAIN_IMAGE_URL, NAME, PRICE, SKU_ATTRIBUTES, SKU_CODE, STOCK_QUANTITY, URL_IMAGES, WEIGHT, HEIGHT, LENGTH, WIDTH, ACTIVE, INDEX) values (3, 'https://i.imgur.com/Bcme7Vy.png', 'Xiaomi Mi9 - 64GB Preto', '{ "endDate": 1623726000, "listPrice": 1200.0, "salePrice": 0.0, "startDate": 1623726000 }', '[{"type": "color", "label": "Cor", "value": "Preto"}, {"type": "cpu", "label": "Processador", "value": "1x 2.84 GHz Kryo 485 + 3x 2.42 GHz Kryo 485 + 4x 1.8 GHz Kryo 485"}, {"type": "memory", "label": "Memória RAM", "value": "6GB"}, {"type": "HD", "label": "Capacidade de Armazenamento", "value": "128GB"}, {"type": "os", "label": "Sistema operacional", "value": "Android 10 MIUI 11"}, {"type": "screenSize", "label": "Tamanho da Tela", "value": "6,39”"}, {"type": "simCardQtd", "label": "Quantidade de Chips", "value": "Dual Chip"}]', 'xiaomi-mi-9-128gb-preto-6gb-ram', 10, '["https://i.imgur.com/1sP18M3.png", "https://i.imgur.com/QgOJSqW.png", "https://i.imgur.com/xtyKVH9.png"]', 160, 14.75, 7.05, 7.05, true, 1);

insert into PRODUCT_SKU (PRODUCT_ID, MAIN_IMAGE_URL, NAME, PRICE, SKU_ATTRIBUTES, SKU_CODE, STOCK_QUANTITY, URL_IMAGES, WEIGHT, HEIGHT, LENGTH, WIDTH, ACTIVE, INDEX) values (4, 'https://i.imgur.com/Ic0KAXB.png', 'Smart TV 50” Crystal 4K Samsung 50AU7700', '{ "endDate": 1623726000, "listPrice": 2999.00, "salePrice": 0.0, "startDate": 1623726000 }', '[{"type": "screenSize", "label": "Tamanho da Tela", "value": "50”"}, {"type": "screenResolution", "label": "Resolução Tela", "value": "3.840 x 2.160"}, {"type": "audioSystem", "label": "Sistema de áudio", "value": "Dolby Digital Plus"}, {"type": "os", "label": "Sistema operacional", "value": "Tizen"}, {"type": "connections", "label": "Conexões", "value": "- 3 Entradas HDMI<br>- 1 Entrada USB<br>- 1 Saída de Áudio Digital (Óptica)<br>- 1 Entrada de RF (terrestre/entrada de cabo)<br>- Ethernet (LAN)"}, {"type": "screenFormat", "label": "Formato da Tela", "value": "Plana"}, {"type": "screenTech", "label": "Tecnologia da Tela", "value": "LED"}, {"type": "isRemoteControlIncluded", "label": "Possui Controle remoto?", "value": "Sim"}, {"type": "is3dGlassesIncluded", "label": "Possui Óculos 3D Incluso?", "value": "Sim"}, {"type": "isIntegratedWifi", "label": "Possui Wi-Fi integrado?", "value": "Sim"}, {"type": "hasAlexaIntegration", "label": "Possui Alexa integrado?", "value": "Sim"}, {"type": "hasGoogleAssistentIntegration", "label": "Possui Google Assistant integrado?", "value": "Sim"}, {"type": "hasWebBrowser", "label": "Possui navegador Web?", "value": "Sim"}, {"type": "hasSmartThingsAppSupport", "label": "Possui Suporte ao app SmartThings?", "value": "Sim"}]', 'samsung-smart-tv-50au7700-preta', 50, '["https://i.imgur.com/p0Xilod.png", "https://i.imgur.com/QqwjI60.png"]', 1140, 64.40, 1120, 5.90, true, 1);
insert into PRODUCT_SKU (PRODUCT_ID, MAIN_IMAGE_URL, NAME, PRICE, SKU_ATTRIBUTES, SKU_CODE, STOCK_QUANTITY, URL_IMAGES, WEIGHT, HEIGHT, LENGTH, WIDTH, ACTIVE, INDEX) values (5, 'https://i.imgur.com/fzo9SWr.png', 'Notebook Samsung Book - Intel Core i3 - 4GB RAM 256GB SSD', '{"endDate": 1661478259.2366135, "listPrice": 4299.00, "salePrice": 3199.99, "startDate": 1661305459.2366135}', '[{"type": "cpu", "label": "Processador", "value": "Intel® Core™ i3"}, {"type": "gpu", "label": "Placa de vídeo", "value": "Intel® UHD Graphics"}, {"type": "memory", "label": "Memória RAM", "value": "4GB"}, {"type": "ssd", "label": "Capacidade do SSD", "value": "256 GB"}, {"type": "os", "label": "Sistema operacional", "value": "Windows 10 Home 32-bit"}, {"type": "screenSize", "label": "Tamanho da Tela", "value": "15,6”"}, {"type": "keyboard", "label": "Teclado", "value": "Português do Brasil no padrão ABNT 2"}, {"type": "observation", "label": "Observação", "value": "Este produto não possui leitor de CD/DVD<br>GPU e CPU são soldadas na máquina."}, {"type": "included", "label": "Conteúdo da Embalagem", "value": "- 1 Notebook<br>- Fonte<br>-Guia do usuário<br>- Certificado de garantia"}]' , 'samsung-notebook-samsung-book-core-i3-256gb-4gb-ram', 1, '["https://i.imgur.com/IXG27SX.png", "https://i.imgur.com/HnmDfYv.png", "https://i.imgur.com/196fQEy.png", "https://i.imgur.com/59mLD4r.png", "https://i.imgur.com/tEsEQLL.png", "https://i.imgur.com/yyAeX6b.png", "https://i.imgur.com/hjhSnsH.png", "https://i.imgur.com/VSyUlh9.png", "https://i.imgur.com/olRv0JJ.png", "https://i.imgur.com/vHkqqka.png"]', 1800, 1.8, 35.9, 24.1, true, 1);
insert into PRODUCT_SKU (PRODUCT_ID, MAIN_IMAGE_URL, NAME, PRICE, SKU_ATTRIBUTES, SKU_CODE, STOCK_QUANTITY, URL_IMAGES, WEIGHT, HEIGHT, LENGTH, WIDTH, ACTIVE, INDEX) values (7, 'https://i.imgur.com/m6VyNEE.png', 'iPhone 12 Pro Max - 128GB Dourado', '{"endDate": 1623985200, "listPrice": 9499.00, "salePrice": 7499.00, "startDate": 1623726000}', '[{"type": "color", "label": "Cor", "value": "Dourado"}, {"type": "cpu", "label": "Processador", "value": "A14 Bionic com Neural Engine de nova geração"}, {"type": "memory", "label": "Memória RAM", "value": "6GB"}, {"type": "hd", "label": "Capacidade de Armazenamento", "value": "128GB"}, {"type": "os", "label": "Sistema operacional", "value": "iOS 14"}, {"type": "screenSize", "label": "Tamanho da Tela", "value": "6,7”"}, {"type": "simCardQtd", "label": "Quantidade de Chips", "value": "Dual Chip"}, {"type": "included", "label": "Conteúdo da Embalagem", "value": "iPhone com iOS, Cabo de USB-C para Lightning e Documentação"}]', 'apple-iphone-12-pro-max-128gb-dourado-6gb-ram', 3, '["https://i.imgur.com/4OZhUVo.png", "https://i.imgur.com/ZIniHz5.png", "https://i.imgur.com/sDVTg9J.png", "https://i.imgur.com/SwsLuzq.png", "https://i.imgur.com/5WG9fmD.png", "https://i.imgur.com/MCIYz1W.png"]', 228, 16.1, 7.8, 0.7, true, 1);
insert into PRODUCT_SKU (PRODUCT_ID, MAIN_IMAGE_URL, NAME, PRICE, SKU_ATTRIBUTES, SKU_CODE, STOCK_QUANTITY, URL_IMAGES, WEIGHT, HEIGHT, LENGTH, WIDTH, ACTIVE, INDEX) values (8, 'https://i.imgur.com/hXDg30e.png', 'Micro-ondas Electrolux Prata Efficient - 23L 110V', '{"endDate": 1661391855.383617, "listPrice": 1819.00, "salePrice": 0.0, "startDate": 1661391855.383617}', '[{"type": "type", "label": "Tipo", "value": "Micro-ondas de Bancada"}, {"type": "features", "label": "Funções", "value": "Derreter.<br>Desidratar.<br>Cozinhar Rápido.<br>Cozinhar Delicado"}, {"type": "capacity", "label": "Capacidade", "value": "23L"}, {"type": "power", "label": "Potência", "value": "1100W"}, {"type": "voltage", "label": "Voltagem", "value": "110V"}, {"type": "included", "label": "Conteúdo da Embalagem", "value": "- 1 Micro-ondas"}]', 'elektrolux-micro-ondas-prata-efficient-23l-110v', 10, '["https://i.imgur.com/EdLbaDC.png", "https://imgur.com/InVwysg.png", "https://i.imgur.com/UjaGvHa.png", "https://i.imgur.com/aSBCLvE.png", "https://i.imgur.com/9UTm245.png"]', 1150, 29, 46.1, 35.2, true, 1);
insert into PRODUCT_SKU (PRODUCT_ID, MAIN_IMAGE_URL, NAME, PRICE, SKU_ATTRIBUTES, SKU_CODE, STOCK_QUANTITY, URL_IMAGES, WEIGHT, HEIGHT, LENGTH, WIDTH, ACTIVE, INDEX) values (8, 'https://i.imgur.com/hXDg30e.png', 'Micro-ondas Electrolux Prata Efficient - 23L 220V', '{"endDate": 1661391855.383617, "listPrice": 1819.00, "salePrice": 0.0, "startDate": 1661391855.383617}', '[{"type": "type", "label": "Tipo", "value": "Micro-ondas de Bancada"}, {"type": "features", "label": "Funções", "value": "Derreter.<br>Desidratar.<br>Cozinhar Rápido.<br>Cozinhar Delicado"}, {"type": "capacity", "label": "Capacidade", "value": "23L"}, {"type": "power", "label": "Potência", "value": "1100W"}, {"type": "voltage", "label": "Voltagem", "value": "220V"}, {"type": "included", "label": "Conteúdo da Embalagem", "value": "- 1 Micro-ondas"}]', 'elektrolux-micro-ondas-prata-efficient-23l-220v', 5, '["https://i.imgur.com/EdLbaDC.png", "https://imgur.com/InVwysg.png", "https://i.imgur.com/UjaGvHa.png", "https://i.imgur.com/aSBCLvE.png", "https://i.imgur.com/9UTm245.png"]', 1150, 29, 46.1, 35.2, true, 2);
insert into PRODUCT_SKU (PRODUCT_ID, MAIN_IMAGE_URL, NAME, PRICE, SKU_ATTRIBUTES, SKU_CODE, STOCK_QUANTITY, URL_IMAGES, WEIGHT, HEIGHT, LENGTH, WIDTH, ACTIVE, INDEX) values (9, 'https://i.imgur.com/UGbiTod.png', 'Fogão de Piso 4 Bocas Esmaltec', '{"endDate": 1661391855.383617, "listPrice": 430.00, "salePrice": 0.0, "startDate": 1661391855.383617}', '[{"type": "material", "label": "Material", "value": "Aço"}, {"type": "tableMaterial", "label": "Material da mesa", "value": "Vidro temperado"}, {"type": "type", "label": "Tipo", "value": "Piso"}, {"type": "stoveBurnerQtd", "label": "Quantidade de bocas", "value": "4"}, {"type": "typeOfFuel", "label": "Alimentação", "value": "A Gás GLP"}, {"type": "ovenSize", "label": "Capacidade do forno", "value": "53,2L"}, {"type": "ovenTempeture", "label": "Temperatura do forno", "value": "160°C a 270°C"}, {"type": "power", "label": "Potência", "value": "9,6kW"}, {"type": "voltage", "label": "Voltagem", "value": "Bivolt"}, {"type": "included", "label": "Conteúdo da Embalagem", "value": "- 1 Fogão"}]', 'esmaltec-fogao-de-piso-4-bocas-preto', 10, '["https://i.imgur.com/yjW2gU6.png", "https://i.imgur.com/nscWWmo.png", "https://i.imgur.com/QdLLUEt.png", "https://i.imgur.com/7zAceyi.png"]', 2130, 88, 51, 57.3, true, 1);
