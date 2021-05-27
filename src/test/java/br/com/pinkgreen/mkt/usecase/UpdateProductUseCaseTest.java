package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.BrandDomain;
import br.com.pinkgreen.mkt.domain.CategoryDomain;
import br.com.pinkgreen.mkt.domain.ProductDomain;
import br.com.pinkgreen.mkt.gateway.UpdateProductGateway;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.mockito.ArgumentCaptor;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.ArgumentCaptor.forClass;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@AutoConfigureMockMvc
class UpdateProductUseCaseTest {

    private final ArgumentCaptor<ProductDomain> productDomainArgument = forClass(ProductDomain.class);
    private final GetProductByIdUseCase getProductByIdUseCase = mock(GetProductByIdUseCase.class);
    private final UpdateProductGateway updateProductGateway = mock(UpdateProductGateway.class);
    private final UpdateProductUseCase updateProductUseCase = new UpdateProductUseCase(getProductByIdUseCase, updateProductGateway);

    @Test
    void shouldUpdateAllProductFields() {
        Integer productId = 1;
        ProductDomain productFieldsToBeUpdated = getProductFieldsToBeUpdated(true, true, true);
        when(getProductByIdUseCase.findById(any())).thenReturn(getProductDatabase(productId));

        updateProductUseCase.updateProduct(productId, productFieldsToBeUpdated);

        verify(getProductByIdUseCase).findById(1);
        verify(updateProductGateway).updateProduct(productDomainArgument.capture());

        ProductDomain updatedProduct = productDomainArgument.getValue();

        assertEquals("iPhone 11", updatedProduct.getName());
        assertEquals(90.88, updatedProduct.getPrice());
        assertEquals(false, updatedProduct.getActive());
    }

    @ParameterizedTest
    @MethodSource
    void shouldUpdateOnlyReceivedFields(ProductDomain productFieldsToBeUpdated, String productName, Double productPrice, Boolean isActive) {
        Integer productId = 1;
        when(getProductByIdUseCase.findById(any())).thenReturn(getProductDatabase(productId));

        updateProductUseCase.updateProduct(productId, productFieldsToBeUpdated);

        verify(getProductByIdUseCase).findById(1);
        verify(updateProductGateway).updateProduct(productDomainArgument.capture());

        ProductDomain updatedProduct = productDomainArgument.getValue();

        assertEquals(productName, updatedProduct.getName());
        assertEquals(productPrice, updatedProduct.getPrice());
        assertEquals(isActive, updatedProduct.getActive());
    }

    private static Stream<Arguments> shouldUpdateOnlyReceivedFields() {
        return Stream.of(
                arguments(getProductFieldsToBeUpdated(true, false, false), "iPhone 11", 399.92, true),
                arguments(getProductFieldsToBeUpdated(false, true, false), "Galaxy S21", 90.88, true),
                arguments(getProductFieldsToBeUpdated(false, false, true), "Galaxy S21", 399.92, false)
        );
    }

    private static ProductDomain getProductFieldsToBeUpdated(boolean updateName, boolean updatePrice, boolean updateActive) {
        ProductDomain.ProductDomainBuilder builder = ProductDomain.builder();

        if (updateName) {
            builder.name("iPhone 11");
        }

        if (updatePrice) {
            builder.price(90.88);
        }

        if (updateActive) {
            builder.active(false);
        }

        return builder.build();
    }

    private static ProductDomain getProductDatabase(Integer id) {
        BrandDomain brand = BrandDomain.builder()
                .id(1)
                .name("Samsung")
                .build();

        List<CategoryDomain> categories = Arrays.asList(
                CategoryDomain.builder()
                        .id(1)
                        .name("Galaxy S21")
                        .build(),
                CategoryDomain.builder()
                        .id(2)
                        .name("Celulares e smartphones")
                        .build()
        );

        return ProductDomain.builder()
                .id(id)
                .name("Galaxy S21")
                .price(399.92)
                .active(true)
                .brand(brand)
                .categories(categories)
                .build();
    }
}