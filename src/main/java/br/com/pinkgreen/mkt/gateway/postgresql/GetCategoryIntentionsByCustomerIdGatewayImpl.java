package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.CategoryDomain;
import br.com.pinkgreen.mkt.gateway.GetCategoryIntentionsByCustomerIdGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.model.CustomerCategoryIntentionsDatabase;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.CustomerCategoryIntentionsRepository;
import br.com.pinkgreen.mkt.translator.CategoryMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

import static java.lang.Integer.compare;
import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor
public class GetCategoryIntentionsByCustomerIdGatewayImpl implements GetCategoryIntentionsByCustomerIdGateway {

    private final CustomerCategoryIntentionsRepository repository;

    @Override
    public List<CategoryDomain> execute(String customerId) {
        return repository.findAllByCustomerId(customerId).stream()
                .sorted((a, b) -> compare(b.getCounter(), a.getCounter()))
                .map(CustomerCategoryIntentionsDatabase::getCategory)
                .map(new CategoryMapperImpl()::categoryDatabaseToDomain)
                .collect(toList());
    }
}
