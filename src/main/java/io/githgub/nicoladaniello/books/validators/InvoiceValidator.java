package io.githgub.nicoladaniello.books.validators;

import io.githgub.nicoladaniello.books.data.invoices.Invoice;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.math.BigDecimal;

@Component("beforeCreateInvoiceValidator")
public class InvoiceValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return Invoice.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Invoice invoice = (Invoice) target;
        if (invoice.getSupplier() == null) {
            errors.rejectValue("supplier", "empty");
        } else if (checkInputString(invoice.getDescription())) {
            errors.rejectValue("description", "empty");
        } else if (invoice.getDated() == null) {
            errors.rejectValue("dated", "empty");
        } else if (invoice.getAmount() == null) {
            errors.rejectValue("amount", "empty");
        } else if (invoice.getAmount().compareTo(BigDecimal.ZERO) <= 0) {
            errors.rejectValue("amount", "invalid");
        }
    }

    private boolean checkInputString(String input) {
        return (input == null || input.trim().length() == 0);
    }
}
