package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.SkuDomain;
import br.com.pinkgreen.mkt.gateway.GetAllFavoriteSkuProductsByUserIdGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.FavoriteProductRepository;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.SkuRepository;
import br.com.pinkgreen.mkt.translator.SkuProductMapperImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

import static java.util.stream.Collectors.toList;

@Component
@RequiredArgsConstructor
public class GetAllFavoriteSkuProductsByUserIdGatewayImpl implements GetAllFavoriteSkuProductsByUserIdGateway {

    @Autowired
    private final FavoriteProductRepository repository;
    private final SkuRepository skuRepository;

    @Override
    public List<SkuDomain> execute(String customerId) {
        return repository.findAllByUserId(customerId)
                .stream()
                .map(it -> skuRepository.findSkuByCode(it.getSkuCode()))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(new SkuProductMapperImpl()::skuDatabaseToDomain)
                .collect(toList());
    }
}
