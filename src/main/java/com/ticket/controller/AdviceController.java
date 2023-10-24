package com.ticket.controller;

import com.ticket.exception.TicketNotCreatedException;
import com.ticket.exception.TicketNotCreatedHandler;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class AdviceController {

    @ExceptionHandler(TicketNotCreatedException.class)
    public TicketNotCreatedHandler handleException(TicketNotCreatedException e) {
        return new TicketNotCreatedHandler(e.getMessage(), System.currentTimeMillis());
    }

}
