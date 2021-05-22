package br.com.pinkgreen.mkt.usecase;

import br.com.pinkgreen.mkt.controller.model.CategoryRequest;
import br.com.pinkgreen.mkt.gateway.GetAllCategoriesGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class GetAllCategoriesUseCase {

    private final GetAllCategoriesGateway getAllCategoriesGateway;

    public List<CategoryRequest> listCategories(){
        return getAllCategoriesGateway.listCategories();
    }
}
