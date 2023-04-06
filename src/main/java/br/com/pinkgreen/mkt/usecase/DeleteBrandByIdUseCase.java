package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.exception.BrandIsNotAbleToBeDeletedException;
import br.com.pinkgreen.mkt.gateway.DeleteBrandByIdGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteBrandByIdUseCase {

    private final GetAllEnabledProductsByBrandIdUseCase getAllEnabledProductsByBrandIdUseCase;
    private final DeleteBrandByIdGateway deleteBrandByIdGateway;

    public void execute(Integer id) throws BrandIsNotAbleToBeDeletedException {
        if (getAllEnabledProductsByBrandIdUseCase.execute(id).isEmpty()) deleteBrandByIdGateway.execute(id);
        else throw new BrandIsNotAbleToBeDeletedException();
    }
}
