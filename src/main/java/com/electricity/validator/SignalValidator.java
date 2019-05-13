package com.electricity.validator;

import com.electricity.model.Signal;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class SignalValidator implements Validator {


    @Override
    public boolean supports(Class<?> clazz) {
        return Signal.class.equals(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        Signal sig = (Signal) target;

        if (sig.getAddress().isEmpty() || sig.getAddress().length() < 3)
            errors.rejectValue("address", "Size.signalForm.address");
        if (sig.getDescription().isEmpty() || sig.getAddress().length() < 3)
            errors.rejectValue("description", "Size.signalForm.description");
    }
}
