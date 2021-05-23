package br.com.pinkgreen.mkt.translator;

import br.com.pinkgreen.mkt.controller.model.BrandRequest;
import br.com.pinkgreen.mkt.controller.model.BrandResponse;
import br.com.pinkgreen.mkt.domain.BrandDomain;
import br.com.pinkgreen.mkt.gateway.postgresql.model.BrandDatabase;
import org.mapstruct.Mapper;

@Mapper
public interface BrandMapper {

    BrandDomain brandRequestToDomain(BrandRequest categoryRequest);

    BrandRequest brandDomainToRequest(BrandDomain categoryDomain);

    BrandDomain brandDatabaseToDomain(BrandDatabase orderRequest);

    BrandDatabase brandDomainToDatabase(BrandDomain orderDomain);

    BrandDomain brandResponseToDomain(BrandResponse categoryRequest);

    BrandResponse brandDomainToResponse(BrandDomain categoryDomain);

}
