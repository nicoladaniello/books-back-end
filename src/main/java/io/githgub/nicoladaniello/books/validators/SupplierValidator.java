package io.githgub.nicoladaniello.books.validators;

import io.githgub.nicoladaniello.books.data.suppliers.Supplier;
import io.githgub.nicoladaniello.books.data.suppliers.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("beforeCreateSupplierValidator")
public class SupplierValidator implements Validator {

    @Autowired
    public SupplierRepository supplierRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return Supplier.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Supplier supplier = (Supplier) target;
        if (checkInputString(supplier.getName())) {
            errors.rejectValue("name", "empty");
        } else if (supplierRepository.findByName(supplier.getName()).isPresent()) {
            errors.rejectValue("name", "taken");
        }
    }

    private boolean checkInputString(String input) {
        return (input == null || input.trim().length() == 0);
    }
}
