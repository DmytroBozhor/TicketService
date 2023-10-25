package com.ticket.service;

import com.ticket.dto.TicketDto;
import com.ticket.entity.TicketEntity;
import com.ticket.repository.TicketRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@Transactional
public class TicketService {
    private final TicketRepository ticketRepository;
    private final ModelMapper modelMapper;

    @Autowired
    public TicketService(TicketRepository ticketRepository, ModelMapper modelMapper) {
        this.ticketRepository = ticketRepository;
        this.modelMapper = modelMapper;
    }

    public int save(TicketEntity ticket) {
        ticket.setTimestamp(LocalDateTime.now());
        ticketRepository.save(ticket);
        return ticket.getId();
    }

    public int save(TicketDto ticketDto) {
        TicketEntity ticket = modelMapper.map(ticketDto, TicketEntity.class);
        return save(ticket);
    }
}
