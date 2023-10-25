package com.ticket.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "ticket")
@Getter
@Setter
@NoArgsConstructor
public class TicketEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    @NotBlank
    @Column(name = "route_number")
    private String routeNumber;
    @NotNull
    @Column(name = "timestamp")
    private LocalDateTime timestamp;

    public TicketEntity(String routeNumber, LocalDateTime timestamp) {
        this.routeNumber = routeNumber;
        this.timestamp = timestamp;
    }
}
