package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.CategoryDomain;
import br.com.pinkgreen.mkt.gateway.RegisterCustomerCategoryIntentionGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.CustomerCategoryIntentionsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
@RequiredArgsConstructor
public class RegisterCustomerCategoryIntentionGatewayImpl implements RegisterCustomerCategoryIntentionGateway {

    private final CustomerCategoryIntentionsRepository repository;

    @Transactional
    @Override
    public void execute(String customerId, List<CategoryDomain> categories) {
        categories.forEach(it -> repository.upsertIntention(customerId, it.getId()));
    }
}
