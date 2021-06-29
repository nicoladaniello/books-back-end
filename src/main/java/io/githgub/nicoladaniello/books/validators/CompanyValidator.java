package io.githgub.nicoladaniello.books.validators;

import io.githgub.nicoladaniello.books.data.companies.Company;
import io.githgub.nicoladaniello.books.data.companies.CompanyRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("beforeCreateCompanyValidator")
public class CompanyValidator implements Validator {

    @Autowired
    private CompanyRepository companyRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return Company.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Company company = (Company) target;

        if (checkInputString(company.getName())) {
            LoggerFactory.getLogger(getClass().getName()).info("Nome non presente");
            errors.rejectValue("name", "empty");
        } else if (companyRepository.findByName(company.getName()).isPresent()) {
            LoggerFactory.getLogger(getClass().getName()).info("Nome gia presente");
            errors.rejectValue("name", "taken");
        } else if (checkInputString(company.getPassword())) {
            errors.rejectValue("password", "empty");
        }
    }

    private boolean checkInputString(String input) {
        return (input == null || input.trim().length() == 0);
    }
}
