package br.com.pinkgreen.mkt.controller.annotation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({FIELD})
@Retention(RUNTIME)
@Constraint(validatedBy = PaymentDataValidator.class)
public @interface ValidPaymentData {

    String message() default "Invalid properties";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
