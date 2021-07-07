package br.com.pinkgreen.mkt.controller.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ElementType.TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = BrandInsertValidator.class)
public @interface BrandInsertData {

    String message() default "Invalid properties";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}