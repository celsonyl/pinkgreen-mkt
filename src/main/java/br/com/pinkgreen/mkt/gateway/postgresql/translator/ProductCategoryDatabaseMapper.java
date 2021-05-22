package br.com.pinkgreen.mkt.gateway.postgresql.translator;

import br.com.pinkgreen.mkt.domain.OrderDomain;
import br.com.pinkgreen.mkt.gateway.postgresql.model.OrderDatabase;
import org.mapstruct.Mapper;

@Mapper
public interface OrderDatabaseMapper {

    OrderDomain orderDatabaseToOrder(OrderDatabase orderRequest);

    OrderDatabase orderToOrderDatabase(OrderDomain orderDomain);

}
