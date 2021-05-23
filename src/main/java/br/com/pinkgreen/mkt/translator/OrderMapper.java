package br.com.pinkgreen.mkt.translator;

import br.com.pinkgreen.mkt.controller.model.OrderRequest;
import br.com.pinkgreen.mkt.controller.model.OrderResponse;
import br.com.pinkgreen.mkt.domain.OrderDomain;
import br.com.pinkgreen.mkt.gateway.postgresql.model.OrderDatabase;
import org.mapstruct.Mapper;

@Mapper
public interface OrderMapper {

    OrderDomain orderRequestToOrder(OrderRequest orderRequest);

    OrderRequest orderToOrderRequest(OrderDomain orderDomain);

    OrderDomain orderResponseToOrder(OrderResponse orderRequest);

    OrderResponse orderToOrderResponse(OrderDomain orderDomain);

    OrderDomain orderDatabaseToOrder(OrderDatabase orderRequest);

    OrderDatabase orderToOrderDatabase(OrderDomain orderDomain);
}
