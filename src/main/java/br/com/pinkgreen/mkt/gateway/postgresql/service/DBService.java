package br.com.pinkgreen.mkt.gateway.postgresql.service;

import br.com.pinkgreen.mkt.domain.SkuAttributesDomain;
import br.com.pinkgreen.mkt.domain.SkuPriceDomain;
import br.com.pinkgreen.mkt.gateway.postgresql.BrandRepository;
import br.com.pinkgreen.mkt.gateway.postgresql.CategoryRepository;
import br.com.pinkgreen.mkt.gateway.postgresql.ProductRepository;
import br.com.pinkgreen.mkt.gateway.postgresql.SkuRepository;
import br.com.pinkgreen.mkt.gateway.postgresql.model.BrandDatabase;
import br.com.pinkgreen.mkt.gateway.postgresql.model.CategoryDatabase;
import br.com.pinkgreen.mkt.gateway.postgresql.model.ProductDatabase;
import br.com.pinkgreen.mkt.gateway.postgresql.model.SkuDatabase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class DBService {

    public static final String URLIMAGE = "urlimage";
    private final BrandRepository brandRepository;
    private final CategoryRepository categoryRepository;
    private final ProductRepository productRepository;
    private final SkuRepository skuRepository;

    public void instantiateTestDB() {
        var acer = new BrandDatabase(null, "Acer");
        var samsung = new BrandDatabase(null, "Samsung");
        var apple = new BrandDatabase(null, "Apple");
        var electrolux = new BrandDatabase(null, "Electrolux");
        var esmaltec = new BrandDatabase(null, "Esmaltec");
        brandRepository.saveAll(Arrays.asList(acer, samsung, apple, electrolux, esmaltec));

        var informatica = new CategoryDatabase(null, "Informatica");
        var eletrodomesticos = new CategoryDatabase(null, "Eletrodomésticos");
        var celularesSmartphones = new CategoryDatabase(null, "Celulares e smartphones");
        categoryRepository.saveAll(Arrays.asList(informatica, eletrodomesticos, celularesSmartphones));

        var aspire5 = new ProductDatabase(null, "Notebook Aspire 5", 3704.05, true, acer, Collections.singletonList(informatica));
        var samsungBook = new ProductDatabase(null, "Samsung Book", 3181.55, true, samsung, Collections.singletonList(informatica));
        var samsungGalaxyA11 = new ProductDatabase(null, "Samsung Galaxy A11", 999.00, true, samsung, Collections.singletonList(celularesSmartphones));
        var iphone12ProMax = new ProductDatabase(null, "iPhone 12 Pro Max", 9495.36, true, apple, Collections.singletonList(celularesSmartphones));
        var microOndas = new ProductDatabase(null, "Micro-ondas", 659.00, true, electrolux, Collections.singletonList(eletrodomesticos));
        var fogao = new ProductDatabase(null, "Fogão de Piso 4 Bocas", 433.52, true, esmaltec, Collections.singletonList(eletrodomesticos));
        productRepository.saveAll(Arrays.asList(aspire5, samsungBook, samsungGalaxyA11, iphone12ProMax, microOndas, fogao));

        var aspire5Sku = new SkuDatabase(null,
                aspire5,
                "A515-54-57EN",
                "Intel Core i5 - 8GB 256GB SSD 15,6” Full HD LED Windows 10",
                10, 10.00, 10.00, 10.00, 10.00, URLIMAGE, Arrays.asList(URLIMAGE, URLIMAGE, URLIMAGE),
                new SkuPriceDomain(3704.05, 0.00, null, null),
                Arrays.asList(
                        new SkuAttributesDomain("Memória RAM", "memory", "8GB"),
                        new SkuAttributesDomain("Capacidade do SSD", "ssd", "256GB de armazenamento SSD NVMe x4"),
                        new SkuAttributesDomain("Sistema operacional", "os", "Windows 10 Home 64-bit")
                )
        );

        var startDate = LocalDateTime.parse("00:00 AM, Tue 06/15/2021", DateTimeFormatter.ofPattern("hh:mm a, EEE M/d/uuuu", Locale.US)).toInstant(ZoneOffset.of("-03:00"));
        var endDate = LocalDateTime.parse("00:00 AM, Fri 06/18/2021", DateTimeFormatter.ofPattern("hh:mm a, EEE M/d/uuuu", Locale.US)).toInstant(ZoneOffset.of("-03:00"));

        var iphone12ProMax128 = new SkuDatabase(
                null, iphone12ProMax, "MGD93BZA",
                "Dourado, com Tela de 6,7”, 5G, 128 GB e Câmera Tripla de 12MP",
                10, 10.00, 10.00, 10.00, 10.00, URLIMAGE, Arrays.asList(URLIMAGE, URLIMAGE, URLIMAGE),
                new SkuPriceDomain(9495.36, 4500.98, startDate, endDate),
                Collections.emptyList()
        );

        skuRepository.saveAll(Arrays.asList(aspire5Sku, iphone12ProMax128));
    }
}
