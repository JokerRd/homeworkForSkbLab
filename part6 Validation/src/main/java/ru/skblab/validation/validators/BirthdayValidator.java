package ru.skblab.validation.validators;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class BirthdayValidator implements ConstraintValidator<OldBirthday, LocalDate> {
    @Override
    public void initialize(OldBirthday constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(LocalDate value, ConstraintValidatorContext context) {
        if (value == null)
            return false;
        LocalDate nowDate = LocalDate.now().minusYears(100);
        return !value.isBefore(nowDate);
    }
}
