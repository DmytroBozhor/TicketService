package com.ticket.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class TicketNotCreatedHandler {
    private String message;
    private long timestamp;
}
