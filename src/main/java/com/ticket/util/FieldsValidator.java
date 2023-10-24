package com.ticket.util;

import com.ticket.exception.TicketNotCreatedException;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;

import java.util.HashMap;
import java.util.Map;

@Component
public class FieldsValidator {
    public void checkForErrors(BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            Map<String, String> errorMap = new HashMap<>();
            bindingResult.getFieldErrors().forEach(fieldError ->
                    errorMap.put(fieldError.getField(), fieldError.getDefaultMessage()));
            throw new TicketNotCreatedException(errorMap.toString());
        }
    }
}
