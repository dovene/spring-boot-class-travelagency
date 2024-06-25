package com.dov.travel.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "flight")
public class Flight {
    @Id
    @Column(name = "flight_number")
    private String flightNumber;

    @ManyToOne
    @JoinColumn(name = "airplane_id")
    private Plane plane;

    @ManyToOne
    @JoinColumn(name = "departure_city_id")
    private City departureCity;

    @ManyToOne
    @JoinColumn(name = "arrival_city_id")
    private City arrivalCity;

    @Column(name = "departure_time")
    private LocalDateTime departureTime;

    @Column(name = "arrival_time")
    private LocalDateTime arrivalTime;
}
