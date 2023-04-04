package br.com.pinkgreen.mkt.controller;

import br.com.pinkgreen.mkt.controller.client.OrderAdministrationControllerApi;
import br.com.pinkgreen.mkt.controller.model.OrderResponse;
import br.com.pinkgreen.mkt.domain.enums.OrderStatus;
import br.com.pinkgreen.mkt.usecase.GetAllOrdersUseCase;
import br.com.pinkgreen.mkt.usecase.UpdateAndPublishOrderEvent;
import br.com.pinkgreen.mkt.usecase.exception.InvalidStatusTransitionException;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import static java.util.stream.Collectors.toList;
import static org.springframework.http.ResponseEntity.noContent;
import static org.springframework.http.ResponseEntity.ok;

@Slf4j
@Component
@RequiredArgsConstructor
@RequestMapping("/order-administration")
public class OrderAdministrationController implements OrderAdministrationControllerApi {

    private final GetAllOrdersUseCase getAllOrdersUseCase;
    private final UpdateAndPublishOrderEvent updateAndPublishOrderEvent;

    @Override
    @SneakyThrows
    @GetMapping("/order")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<List<OrderResponse>> getAllOrders() {
        var orders = getAllOrdersUseCase.execute();
        return ok(orders.stream()
                .map(OrderResponse::response)
                .collect(toList()));
    }

    @Override
    @SneakyThrows
    @PatchMapping("/order/{orderId}/update/{orderStatus}")
    @CrossOrigin(origins = "http://localhost:3000")
    public ResponseEntity<Void> updateOrderStatus(Integer orderId, OrderStatus orderStatus) throws InvalidStatusTransitionException {
        updateAndPublishOrderEvent.execute(orderId, orderStatus);
        return noContent().build();
    }
}
