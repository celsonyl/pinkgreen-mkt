package br.com.pinkgreen.mkt.gateway.postgresql.translator;

import br.com.pinkgreen.mkt.domain.BrandDomain;
import br.com.pinkgreen.mkt.gateway.postgresql.model.BrandDatabase;
import org.mapstruct.Mapper;

@Mapper
public interface BrandDatabaseMapper {

    BrandDomain brandDatabaseToDomain(BrandDatabase orderRequest);

    BrandDatabase brandDomainToDatabase(BrandDomain orderDomain);

}
