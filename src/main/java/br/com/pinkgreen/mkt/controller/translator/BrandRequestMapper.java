package br.com.pinkgreen.mkt.controller.translator;

import br.com.pinkgreen.mkt.controller.model.BrandRequest;

import br.com.pinkgreen.mkt.domain.BrandDomain;
import org.mapstruct.Mapper;

@Mapper
public interface BrandRequestMapper {

    BrandDomain brandRequestToDomain(BrandRequest categoryRequest);

    BrandRequest brandDomainToRequest(BrandDomain categoryDomain);

}
