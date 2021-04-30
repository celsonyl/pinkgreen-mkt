package br.com.pinkgreen.mkt.controller.translator;

import br.com.pinkgreen.mkt.controller.model.OrderRequest;
import br.com.pinkgreen.mkt.domain.OrderDomain;
import org.mapstruct.Mapper;

@Mapper
public interface OrderRequestMapper {

    OrderDomain orderRequestToOrder(OrderRequest orderRequest);
    OrderRequest orderToOrderRequest(OrderDomain orderDomain);

}
