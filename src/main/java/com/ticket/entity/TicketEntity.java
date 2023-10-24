package com.ticket.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @NotNull
    @Column(name = "route_number")
    private String routeNumber;
    @NotNull
    @Column(name = "timestamp")
    private long timestamp;

    public TicketEntity(String routeNumber, long timestamp) {
        this.routeNumber = routeNumber;
        this.timestamp = timestamp;
    }
}
