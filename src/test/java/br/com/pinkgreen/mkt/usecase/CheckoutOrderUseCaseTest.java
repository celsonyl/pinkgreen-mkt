package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.*;
import br.com.pinkgreen.mkt.domain.enums.PaymentMethod;
import br.com.pinkgreen.mkt.gateway.CheckoutOrderGateway;
import br.com.pinkgreen.mkt.gateway.PublishOrderToProcessPayment;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;

import java.time.Instant;
import java.util.Arrays;
import java.util.HashMap;

import static br.com.pinkgreen.mkt.domain.enums.OrderStatus.ORDER_CREATED;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentCaptor.forClass;
import static org.mockito.Mockito.*;

@AutoConfigureMockMvc
class CheckoutOrderUseCaseTest {

    private final ArgumentCaptor<OrderDomain> orderDomainArgument = forClass(OrderDomain.class);
    private final ArgumentCaptor<OrderDomain> publishOrderDomainArgument = forClass(OrderDomain.class);
    private final ArgumentCaptor<PaymentDomain> publishPaymentDomainArgument = forClass(PaymentDomain.class);
    private final CheckoutOrderGateway checkoutOrderGateway = mock(CheckoutOrderGateway.class);
    private final PublishOrderToProcessPayment publishOrderToProcessPayment = mock(PublishOrderToProcessPayment.class);
    private final CheckoutOrderUseCase checkoutOrderUseCase = new CheckoutOrderUseCase(checkoutOrderGateway, publishOrderToProcessPayment);

    @Test
    void shouldCheckoutOrderSuccessfully() {
        OrderDomain orderDomain = getOrder();
        when(checkoutOrderGateway.execute(any())).thenReturn(getPersistedOrder());

        checkoutOrderUseCase.execute(orderDomain, orderDomain.getPaymentData());

        verify(checkoutOrderGateway).execute(orderDomainArgument.capture());
        verify(publishOrderToProcessPayment, times(1)).publish(publishOrderDomainArgument.capture(), publishPaymentDomainArgument.capture());

        OrderDomain orderDomainArgumentValue = orderDomainArgument.getValue();
        OrderDomain publishOrderDomainArgumentValue = publishOrderDomainArgument.getValue();
        PaymentDomain publishPaymentDomainArgumentValue = publishPaymentDomainArgument.getValue();

        assertEquals("1234", publishOrderDomainArgumentValue.getId());
        assertEquals(ORDER_CREATED, orderDomainArgumentValue.getStatus());
        assertEquals(9066.00, orderDomainArgumentValue.getPaymentData().getAmount());
        assertEquals("1111222233334444", publishPaymentDomainArgumentValue.getPaymentMethodProperties().get("cardNumber"));
        assertEquals("123", publishPaymentDomainArgumentValue.getPaymentMethodProperties().get("cvv"));
        assertEquals("01/22", publishPaymentDomainArgumentValue.getPaymentMethodProperties().get("validationDate"));
        assertEquals("947.229.723-46", publishPaymentDomainArgumentValue.getPaymentMethodProperties().get("document"));
        assertEquals("Elza Luna Rocha", publishPaymentDomainArgumentValue.getPaymentMethodProperties().get("ownerName"));
        assertEquals("21/05/2000", publishPaymentDomainArgumentValue.getPaymentMethodProperties().get("birthday"));
        assertEquals("+55 19 99999-9999", publishPaymentDomainArgumentValue.getPaymentMethodProperties().get("phone"));
        assertEquals("test@test.com.br", publishPaymentDomainArgumentValue.getPaymentMethodProperties().get("email"));
    }

    public OrderDomain getOrder() {
        CustomerDomain customerDomain = CustomerDomain.builder()
                .id("3zyaa7ge0zh64rgooswxbzkmfucl3k")
                .document("947.229.723-46")
                .name("Elza")
                .lastname("Luna Rocha")
                .email("test@test.com.br")
                .phone("+55 (19) 99999-9999")
                .build();

        AddressDomain addressDomain = AddressDomain.builder()
                .country("Brasil")
                .state("SP")
                .city("Limeira")
                .neighborhood("Centro")
                .street("Rua Boa Morte")
                .number("380")
                .zipcode("13480-180")
                .complement("")
                .phone("(19) 99999-9999")
                .build();

        ShippingDataDomain shippingDataDomain = ShippingDataDomain.builder()
                .deliveryDays(6)
                .freightPrice(19.79)
                .address(addressDomain)
                .build();

        ProductDomain productDomain = ProductDomain.builder()
                .name("Samsung Galaxy S21 Cinza")
                .price(3859.00)
                .quantity(1000)
                .sku("888888888")
                .build();

        ProductDomain productDomain2 = ProductDomain.builder()
                .name("Apple iPhone 12 Roxo")
                .price(5207.00)
                .quantity(1000)
                .sku("99999999")
                .build();

        return OrderDomain.builder()
                .customerData(customerDomain)
                .shippingData(shippingDataDomain)
                .productList(Arrays.asList(productDomain, productDomain2))
                .paymentData(getPaymentByPaymentMethod(addressDomain, PaymentMethod.CREDIT_CARD))
                .build();
    }

    public OrderDomain getPersistedOrder() {
        CustomerDomain customerDomain = CustomerDomain.builder()
                .id("3zyaa7ge0zh64rgooswxbzkmfucl3k")
                .document("947.229.723-46")
                .name("Elza")
                .lastname("Luna Rocha")
                .email("test@test.com.br")
                .phone("+55 (19) 99999-9999")
                .build();

        AddressDomain addressDomain = AddressDomain.builder()
                .country("Brasil")
                .state("SP")
                .city("Limeira")
                .neighborhood("Centro")
                .street("Rua Boa Morte")
                .number("380")
                .zipcode("13480-180")
                .complement("")
                .phone("(19) 99999-9999")
                .build();

        ShippingDataDomain shippingDataDomain = ShippingDataDomain.builder()
                .deliveryDays(6)
                .freightPrice(19.79)
                .address(addressDomain)
                .build();

        ProductDomain productDomain = ProductDomain.builder()
                .name("Samsung Galaxy S21 Cinza")
                .price(3859.00)
                .quantity(1000)
                .sku("888888888")
                .build();

        ProductDomain productDomain2 = ProductDomain.builder()
                .name("Apple iPhone 12 Roxo")
                .price(5207.00)
                .quantity(1000)
                .sku("99999999")
                .build();

        PaymentDomain paymentDomain = PaymentDomain.builder()
                .paymentMethod(PaymentMethod.CREDIT_CARD)
                .paymentAddress(addressDomain)
                .amount(9066.00)
                .build();

        return OrderDomain.builder()
                .id("1234")
                .customerData(customerDomain)
                .status(ORDER_CREATED)
                .shippingData(shippingDataDomain)
                .productList(Arrays.asList(productDomain, productDomain2))
                .paymentData(paymentDomain)
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .build();
    }

    public PaymentDomain getPaymentByPaymentMethod(AddressDomain addressDomain, PaymentMethod paymentMethod) {
        HashMap<String, String> paymentMethodProperties = new HashMap<>();
        switch (paymentMethod) {
            case DEBIT_CARD:
            case CREDIT_CARD:
                paymentMethodProperties.put("cardNumber", "1111222233334444");
                paymentMethodProperties.put("cvv", "123");
                paymentMethodProperties.put("validationDate", "01/22");
                paymentMethodProperties.put("document", "947.229.723-46");
                paymentMethodProperties.put("ownerName", "Elza Luna Rocha");
                paymentMethodProperties.put("birthday", "21/05/2000");
                paymentMethodProperties.put("phone", "+55 19 99999-9999");
                paymentMethodProperties.put("email", "test@test.com.br");
                break;
            case BANK_SLIP:
                paymentMethodProperties.put("document", "947.229.723-46");
                paymentMethodProperties.put("ownerName", "Elza Luna Rocha");
                paymentMethodProperties.put("phone", "+55 19 99999-9999");
                paymentMethodProperties.put("email", "test@test.com.br");
                break;
        }

        return PaymentDomain.builder()
                .paymentAddress(addressDomain)
                .paymentMethod(paymentMethod)
                .paymentMethodProperties(paymentMethodProperties)
                .build();
    }
}