package br.com.pinkgreen.mkt.controller.annotation;

import br.com.pinkgreen.mkt.controller.handler.model.FieldMessage;
import br.com.pinkgreen.mkt.controller.model.BrandRequest;
import br.com.pinkgreen.mkt.gateway.postgresql.BrandRepository;
import lombok.RequiredArgsConstructor;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class BrandInsertValidator implements ConstraintValidator<BrandInsertData, BrandRequest> {
    private final BrandRepository brandRepository;

    @Override
    public void initialize(BrandInsertData constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(BrandRequest brandRequest, ConstraintValidatorContext constraintValidatorContext) {
        List<FieldMessage> list = new ArrayList<>();

        var brand = brandRepository.findBranddatabaseByName(brandRequest.getName());
        if (brand.isPresent()) {
            list.add(new FieldMessage("Name", "Já existe uma marca com esse nome registrada!"));
        }
        for (FieldMessage e : list) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName()).addConstraintViolation();
        }
        return list.isEmpty();
    }
}
