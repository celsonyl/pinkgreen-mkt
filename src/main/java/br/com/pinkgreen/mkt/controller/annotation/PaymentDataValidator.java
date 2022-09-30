package br.com.pinkgreen.mkt.controller.annotation;

import br.com.pinkgreen.mkt.controller.model.PaymentDataRequest;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashMap;
import java.util.Map;

public class PaymentDataValidator implements ConstraintValidator<ValidPaymentData, PaymentDataRequest> {

    public static final String CARD_REGEX = "^([0-9]{13,16})$";
    public static final String DATE_REGEX = "^(?:(?:31(\\/)(?:0?[13578]|1[02]))\\1|(?:(?:29|30)(\\/)(?:0?[13-9]|1[0-2])\\2))(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$|^(?:29(\\/)0?2\\3(?:(?:(?:1[6-9]|[2-9]\\d)?(?:0[48]|[2468][048]|[13579][26])|(?:(?:16|[2468][048]|[3579][26])00))))$|^(?:0?[1-9]|1\\d|2[0-8])(\\/)(?:(?:0?[1-9])|(?:1[0-2]))\\4(?:(?:1[6-9]|[2-9]\\d)?\\d{2})$";
    public static final String DOCUMENT_REGEX = "^([0-9]{3}[.]?[0-9]{3}[.]?[0-9]{3}-[0-9]{2})|([0-9]{11})";
    public static final String VALIDATION_DATE_REGEX = "^(1[0-2]|0[1-9]|\\d)\\/((?!0)\\d|[1-9]\\d)$";
    public static final String CVV_REGEX = "^([0-9]{3})";
    public static final String EMAIL_REGEX = "^[a-zA-Z0-9.!#$%&'*+\\/=?^_`{|}~-]+@[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?(?:\\.[a-zA-Z0-9](?:[a-zA-Z0-9-]{0,61}[a-zA-Z0-9])?)*$";
    public static final String PHONE_REGEX = "^(?:\\()[0-9]{2}(?:\\))\\s?[0-9]{4,5}(?:-)[0-9]{4}$";
    public static final String LIMIT_50_CHARACTERS_REGEX = "^.{1,50}";
    private final Map<String, String> requiredCardFields = new HashMap<>();
    private final Map<String, String> requiredBankSlipFields = new HashMap<>();

    @Override
    public void initialize(ValidPaymentData constraintAnnotation) {
        initializeRequiredCardFields();
        initializeRequiredBankSlipFields();
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    private void initializeRequiredBankSlipFields() {
        requiredBankSlipFields.put("document", DOCUMENT_REGEX);
        requiredBankSlipFields.put("ownerName", LIMIT_50_CHARACTERS_REGEX);
        requiredBankSlipFields.put("phone", PHONE_REGEX);
        requiredBankSlipFields.put("email", EMAIL_REGEX);
    }

    private void initializeRequiredCardFields() {
        requiredCardFields.put("cardNumber", CARD_REGEX);
        requiredCardFields.put("cvv", CVV_REGEX);
        requiredCardFields.put("validationDate", VALIDATION_DATE_REGEX);
        requiredCardFields.put("document", DOCUMENT_REGEX);
        requiredCardFields.put("ownerName", LIMIT_50_CHARACTERS_REGEX);
        requiredCardFields.put("birthday", DATE_REGEX);
        requiredCardFields.put("phone", PHONE_REGEX);
        requiredCardFields.put("email", EMAIL_REGEX);
    }

    @Override
    public boolean isValid(PaymentDataRequest paymentDataRequest, ConstraintValidatorContext constraintValidatorContext) {
        if (paymentDataRequest == null
                || paymentDataRequest.getPaymentMethod() == null
                || paymentDataRequest.getPaymentMethodProperties() == null) {
            return false;
        }

        return validatePaymentMethodProperties(paymentDataRequest);
    }

    private boolean validatePaymentMethodProperties(PaymentDataRequest paymentDataRequest) {
        switch (paymentDataRequest.getPaymentMethod()) {
            case CREDIT_CARD:
            case DEBIT_CARD:
                return validateProperties(paymentDataRequest.getPaymentMethodProperties(), requiredCardFields);
            case BANK_SLIP:
                return validateProperties(paymentDataRequest.getPaymentMethodProperties(), requiredBankSlipFields);
            default:
                return false;
        }
    }

    private boolean validateProperties(Map<String, String> paymentMethodProperties, Map<String, String> requiredFields) {
        if (paymentMethodProperties.size() != requiredFields.size()) {
            return false;
        }

        for (Map.Entry<String, String> entry : paymentMethodProperties.entrySet()) {
            String fieldRegex = requiredFields.get(entry.getKey());
            if (fieldRegex == null || !entry.getValue().matches(fieldRegex)) {
                return false;
            }
        }
        return true;
    }
}
