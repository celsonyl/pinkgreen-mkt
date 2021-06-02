package br.com.pinkgreen.mkt.translator;

import br.com.pinkgreen.mkt.controller.model.SkuByProductIdResponse;
import br.com.pinkgreen.mkt.controller.model.SkuRequest;
import br.com.pinkgreen.mkt.controller.model.SkuResponse;
import br.com.pinkgreen.mkt.controller.model.SkuUpdateRequest;
import br.com.pinkgreen.mkt.domain.SkuDomain;
import br.com.pinkgreen.mkt.gateway.postgresql.model.SkuDatabase;
import org.mapstruct.Mapper;

@Mapper
public interface SkuProductMapper {

    SkuDatabase skuDomainToDatabase(SkuDomain skuDomain);

    SkuDomain skuDatabaseToDomain(SkuDatabase skuDatabase);

    SkuDomain skuRequestToDomain(SkuRequest skuRequest);

    SkuResponse skuDomainToResponse(SkuDomain skuDomain);

    SkuDomain skuUpdateRequestToDomain(SkuUpdateRequest skuUpdateRequest);

    SkuByProductIdResponse skuDomainToSkuByProductIdResponse(SkuDomain skuDomain);

}
