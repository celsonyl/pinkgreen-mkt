package br.com.pinkgreen.mkt.usecase;


import br.com.pinkgreen.mkt.domain.OrderDomain;
import org.springframework.stereotype.Component;

@Component
public class CheckoutOrderUseCase {
    // TODO - Consultar catalogo para validar dados do produto recebido -> futuro
    // TODO - Validar customerId recebido (se customerId existe na base) -> futuro

    public OrderDomain execute(OrderDomain orderDomain) {
        // TODO - Codar escrevendo testes unitários!
        // TODO - Calcular valor do pagamento final de acordo com os produtos -> criar usecase?
        // TODO - Persistir pedido no banco de dados
        // TODO - Postar pedido criado em uma fila no rabbit como payload o orderId e um header com o status de ORDER_CREATED
        // TODO - Retornar OrderDomain com orderId preenchido

        return null;
    }
}
