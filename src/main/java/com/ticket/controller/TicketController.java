package com.ticket.controller;

import com.ticket.dto.TicketDto;
import com.ticket.service.TicketService;
import com.ticket.util.FieldsValidator;
import jakarta.validation.Valid;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/tickets")
public class TicketController {
    private final TicketService ticketService;
    private final ModelMapper modelMapper;
    private final FieldsValidator fieldsValidator;

    @Autowired
    public TicketController(TicketService ticketService, ModelMapper modelMapper, FieldsValidator fieldsValidator) {
        this.ticketService = ticketService;
        this.modelMapper = modelMapper;
        this.fieldsValidator = fieldsValidator;
    }

    @PostMapping("/new")
    public ResponseEntity<Map<String, String>> register(@RequestBody @Valid TicketDto ticketDto, BindingResult bindingResult) {

        fieldsValidator.checkForErrors(bindingResult);

        int ticketId = ticketService.save(ticketDto);

        return new ResponseEntity<>(Map.of("application_id", "" + ticketId), HttpStatus.OK);
    }
}
