package br.com.pinkgreen.mkt.controller.translator;

import br.com.pinkgreen.mkt.controller.model.OrderResponse;
import br.com.pinkgreen.mkt.domain.OrderDomain;
import org.mapstruct.Mapper;

@Mapper
public interface OrderResponseMapper {

    OrderDomain orderResponseToOrder(OrderResponse orderRequest);

    OrderResponse orderToOrderResponse(OrderDomain orderDomain);

}
