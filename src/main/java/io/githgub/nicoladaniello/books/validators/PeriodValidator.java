package io.githgub.nicoladaniello.books.validators;

import io.githgub.nicoladaniello.books.data.periods.Period;
import io.githgub.nicoladaniello.books.data.periods.PeriodRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component("beforeCreatePeriodValidator")
public class PeriodValidator implements Validator {

    @Autowired
    public PeriodRepository periodRepository;

    @Override
    public boolean supports(Class<?> clazz) {
        return Period.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Period period = (Period) target;
        if (checkInputString(period.getName())) {
            errors.rejectValue("name", "empty");
        } else if (periodRepository.findByName(period.getName()).isPresent()) {
            errors.rejectValue("name", "taken");
        } else if (period.getStartDate() == null) {
            errors.rejectValue("startDate", "empty");
        } else if (period.getEndDate() == null) {
            errors.rejectValue("endDate", "empty");
        } else if (period.getStartDate().isAfter(period.getEndDate()) ||
                period.getEndDate().isEqual(period.getStartDate())) {
            errors.rejectValue("endDate", "invalid");
        }
    }

    private boolean checkInputString(String input) {
        return (input == null || input.trim().length() == 0);
    }
}
