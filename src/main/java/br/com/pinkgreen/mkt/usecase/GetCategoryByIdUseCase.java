package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.domain.exception.ObjectNotFoundException;
import br.com.pinkgreen.mkt.domain.CategoryDomain;
import br.com.pinkgreen.mkt.gateway.postgresql.GetCaregoryByIdCatewayImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class GetCategoryByIdUseCase {

    private final GetCaregoryByIdCatewayImpl getCaregoryByIdCateway;

    public CategoryDomain findById(Integer id) {
        return getCaregoryByIdCateway.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Categoria não encontrada: " + id));
    }
}
