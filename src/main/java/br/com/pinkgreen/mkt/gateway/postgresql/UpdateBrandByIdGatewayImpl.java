package br.com.pinkgreen.mkt.gateway.postgresql;

import br.com.pinkgreen.mkt.domain.BrandDomain;
import br.com.pinkgreen.mkt.domain.exception.ObjectNotFoundException;
import br.com.pinkgreen.mkt.gateway.UpdateBrandByIdGateway;
import br.com.pinkgreen.mkt.gateway.postgresql.model.BrandDatabase;
import br.com.pinkgreen.mkt.gateway.postgresql.repository.BrandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UpdateBrandByIdGatewayImpl implements UpdateBrandByIdGateway {

    private final BrandRepository repository;

    @Override
    public void execute(Integer id, BrandDomain updatedBrand) {
        BrandDatabase brand = repository.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Marca não encontrada: " + id));

        fillValues(brand, updatedBrand);

        repository.save(brand);
    }

    private void fillValues(BrandDatabase brand, BrandDomain updatedBrand) {
        if (updatedBrand.getName() != null) brand.setName(updatedBrand.getName());
        if (updatedBrand.getBrandImage() != null) brand.setBrandImage(updatedBrand.getBrandImage());
    }
}
