package br.com.pinkgreen.mkt.gateway.postgresql.service;

import br.com.pinkgreen.mkt.domain.SkuAttributesDomain;
import br.com.pinkgreen.mkt.domain.SkuPriceDomain;
import br.com.pinkgreen.mkt.gateway.postgresql.model.BrandDatabase;
import br.com.pinkgreen.mkt.gateway.postgresql.model.CategoryDatabase;
import br.com.pinkgreen.mkt.gateway.postgresql.model.ProductDatabase;
import br.com.pinkgreen.mkt.gateway.postgresql.model.SkuDatabase;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.BrandRepository;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.CategoryRepository;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.ProductRepository;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.SkuRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;

@Service
@RequiredArgsConstructor
public class DBService {

    public static final String URLIMAGE = "https://imgur.com/c20GJPz.gif";
    public static final String RAM = "Memória RAM";
    public static final String SSD = "Capacidade do SSD";
    public static final String SO = "Sistema operacional";
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

        var informatica = new CategoryDatabase(null, "Informatica", URLIMAGE);
        var eletrodomesticos = new CategoryDatabase(null, "Eletrodomésticos", URLIMAGE);
        var celularesSmartphones = new CategoryDatabase(null, "Celulares e smartphones", URLIMAGE);
        categoryRepository.saveAll(Arrays.asList(informatica, eletrodomesticos, celularesSmartphones));

        var aspire5 = new ProductDatabase(null, "Notebook Aspire 5", 3704.05, true, URLIMAGE, acer, Collections.singletonList(informatica));
        var samsungBook = new ProductDatabase(null, "Notebook Samsung Book", 3181.55, true, URLIMAGE, samsung, Collections.singletonList(informatica));
        var samsungGalaxyA11 = new ProductDatabase(null, "Samsung Galaxy A11", 999.00, true, URLIMAGE, samsung, Collections.singletonList(celularesSmartphones));
        var iphone12ProMax = new ProductDatabase(null, "iPhone 12 Pro Max", 9495.36, true, "https://i.imgur.com/m6VyNEE.jpg", apple, Collections.singletonList(celularesSmartphones));
        var microOndas = new ProductDatabase(null, "Micro-ondas", 659.00, true, URLIMAGE, electrolux, Collections.singletonList(eletrodomesticos));
        var fogao = new ProductDatabase(null, "Fogão de Piso 4 Bocas", 433.52, true, URLIMAGE, esmaltec, Collections.singletonList(eletrodomesticos));
        productRepository.saveAll(Arrays.asList(aspire5, samsungBook, samsungGalaxyA11, iphone12ProMax, microOndas, fogao));

        var startDate = LocalDateTime.parse("00:00 AM, Tue 06/15/2021", DateTimeFormatter.ofPattern("hh:mm a, EEE M/d/uuuu", Locale.US)).toInstant(ZoneOffset.of("-03:00"));
        var endDate = LocalDateTime.parse("00:00 AM, Fri 06/18/2021", DateTimeFormatter.ofPattern("hh:mm a, EEE M/d/uuuu", Locale.US)).toInstant(ZoneOffset.of("-03:00"));

        var aspire5SkuI5 = new SkuDatabase(null,
                aspire5,
                "A515-54-57EN",
                "Notebook Aspire 5 - Intel Core i5 - 8GB 256GB SSD 15,6” Full HD LED Windows 10",
                10, 10.00, 10.00, 10.00, 10.00, URLIMAGE, Arrays.asList(URLIMAGE, URLIMAGE, URLIMAGE),
                new SkuPriceDomain(3704.05, 0.00, startDate, startDate),
                Arrays.asList(
                        new SkuAttributesDomain(RAM, "memory", "8GB"),
                        new SkuAttributesDomain(SSD, "ssd", "256GB de armazenamento SSD NVMe x4"),
                        new SkuAttributesDomain(SO, "os", "Windows 10 Home 64-bit")
                )
        );

        var aspire5SkuI7 = new SkuDatabase(null,
                aspire5,
                "A517-54-57EN",
                "Notebook Aspire 5 - Intel Core i7 - 16GB 480GB SSD 15,6” Full HD LED Windows 10",
                10, 10.00, 10.00, 10.00, 10.00, URLIMAGE, Arrays.asList(URLIMAGE, URLIMAGE, URLIMAGE),
                new SkuPriceDomain(3904.05, 2556.89, LocalDateTime.now().minusDays(2).toInstant(ZoneOffset.of("-03:00")), LocalDateTime.now().plusDays(7).toInstant(ZoneOffset.of("-03:00"))),
                Arrays.asList(
                        new SkuAttributesDomain(RAM, "memory", "16GB"),
                        new SkuAttributesDomain(SSD, "ssd", "480GB de armazenamento SSD NVMe x4"),
                        new SkuAttributesDomain(SO, "os", "Windows 10 Home 64-bit")
                )
        );

        var aspire5SkuI3 = new SkuDatabase(null,
                aspire5,
                "A513-54-57EN",
                "Notebook Aspire 5 - Intel Core i3 - 4GB 256GB SSD 15,6” Full HD LED Windows 10",
                10, 10.00, 10.00, 10.00, 10.00, URLIMAGE, Arrays.asList(URLIMAGE, URLIMAGE, URLIMAGE),
                new SkuPriceDomain(3004.85, 1458.32, LocalDateTime.now().minusDays(2).toInstant(ZoneOffset.of("-03:00")), LocalDateTime.now().plusDays(7).toInstant(ZoneOffset.of("-03:00"))),
                Arrays.asList(
                        new SkuAttributesDomain(RAM, "memory", "4GB"),
                        new SkuAttributesDomain(SSD, "ssd", "256GB de armazenamento SSD NVMe x4"),
                        new SkuAttributesDomain(SO, "os", "Windows 10 Home 64-bit")
                )
        );

        var fogaoEsmaltec = new SkuDatabase(null,
                fogao,
                "1589663525",
                "Fogão de Piso 4 Bocas Esmaltec",
                10, 10.00, 10.00, 10.00, 10.00, URLIMAGE, Arrays.asList(URLIMAGE, URLIMAGE, URLIMAGE),
                new SkuPriceDomain(433.52, 0.00, null, null),
                Collections.emptyList()
        );

        var iphone12ProMax128 = new SkuDatabase(
                null, iphone12ProMax, "MGD93BZA",
                "iPhone 12 Pro Max Dourado, com Tela de 6,7”, 5G, 128 GB e Câmera Tripla de 12MP",
                10, 10.00, 10.00, 10.00, 10.00, "https://i.imgur.com/m6VyNEE.jpg", Arrays.asList(URLIMAGE, URLIMAGE, URLIMAGE),
                new SkuPriceDomain(9495.36, 4500.98, startDate, endDate),
                Collections.emptyList()
        );

        var samsungBookI3core258GB = new SkuDatabase(
                null, samsungBook, "NP550XDA-KT3BR",
                "Notebook Samsung Book - Intel Core i3 - 4GB 256GB SSD 15,6” Full HD LED Windows 10",
                10, 10.00, 10.00, 10.00, 10.00, URLIMAGE, Arrays.asList(URLIMAGE, URLIMAGE, URLIMAGE),
                new SkuPriceDomain(4299.00, 3181.55, Instant.now().minusSeconds(86400), Instant.now().plusSeconds(86400)),
                Collections.emptyList()
        );

        skuRepository.saveAll(Arrays.asList(aspire5SkuI3, aspire5SkuI5, aspire5SkuI7, iphone12ProMax128, samsungBookI3core258GB, fogaoEsmaltec));
    }
}
