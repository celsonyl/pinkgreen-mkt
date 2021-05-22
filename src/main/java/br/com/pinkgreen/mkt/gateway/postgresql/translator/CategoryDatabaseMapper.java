package br.com.pinkgreen.mkt.gateway.postgresql.translator;

import br.com.pinkgreen.mkt.domain.CategoryDomain;
import br.com.pinkgreen.mkt.gateway.postgresql.model.CategoryDatabase;
import org.mapstruct.Mapper;

@Mapper
public interface CategoryDatabaseMapper {

    CategoryDomain categoryDatabaseToDomain(CategoryDatabase categoryDatabase);

    CategoryDatabase categoryDomainToDatabase(CategoryDomain categoryDomain);

}
