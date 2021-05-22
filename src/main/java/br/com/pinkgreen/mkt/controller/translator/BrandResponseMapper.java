package br.com.pinkgreen.mkt.controller.translator;

import br.com.pinkgreen.mkt.controller.model.BrandResponse;
import br.com.pinkgreen.mkt.domain.BrandDomain;
import org.mapstruct.Mapper;

@Mapper
public interface BrandResponseMapper {

    BrandDomain brandResponseToDomain(BrandResponse categoryRequest);

    BrandResponse brandDomainToResponse(BrandDomain categoryDomain);

}
