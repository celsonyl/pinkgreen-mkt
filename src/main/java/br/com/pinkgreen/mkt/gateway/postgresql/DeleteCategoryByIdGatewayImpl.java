package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.gateway.DeleteCategoryByIdGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DeleteCategoryByIdGatewayImpl implements DeleteCategoryByIdGateway {

    private final CategoryRepository repository;

    @Override
    public void execute(Integer id) {
        repository.deleteById(id);
    }
}
