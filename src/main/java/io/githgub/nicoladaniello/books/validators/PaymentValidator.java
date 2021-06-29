package io.githgub.nicoladaniello.books.validators;

import io.githgub.nicoladaniello.books.data.payments.Payment;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.math.BigDecimal;

@Component("beforeCreatePaymentValidator")
public class PaymentValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Payment.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Payment payment = (Payment) target;
        if (payment.getInvoice() == null) {
            errors.rejectValue("invoice", "empty");
        } else if (checkInputString(payment.getDescription())) {
            errors.rejectValue("description", "empty");
        } else if (payment.getDated() == null) {
            errors.rejectValue("dated", "empty");
        } else if (payment.getAmount() == null) {
            errors.rejectValue("amount", "empty");
        } else if (payment.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            errors.rejectValue("amount", "invalid");
        }
    }

    private boolean checkInputString(String input) {
        return (input == null || input.trim().length() == 0);
    }
}
