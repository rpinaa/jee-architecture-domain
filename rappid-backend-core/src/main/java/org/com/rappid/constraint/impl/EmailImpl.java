package org.com.rappid.constraint.impl;

import org.com.rappid.constraint.Email;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Optional;

/**
 * Created by PINA on 09/06/2017.
 */
public class EmailImpl implements ConstraintValidator<Email, String> {

    private Email email;

    @Override
    public void initialize(final Email email) {
        this.email = email;

    }

    @Override
    public boolean isValid(final String value, final ConstraintValidatorContext constraintValidatorContext) {
        final Optional<String> optionalValue = Optional.of(value);

        return optionalValue.map(v -> v.matches("^[\\w\\d-]+(\\.[\\w\\d-]+)*@[\\w\\d {/\\-\\}]+(\\.[\\w\\d-]+)*(\\.[a-z]{2,3})$"))
                .orElse(true);
    }
}
