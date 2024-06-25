package com.dov.travel.service;

import java.time.LocalDateTime;
import java.util.List;

import com.dov.travel.model.Flight;

public interface FlightService {
 public List<Flight> getAll();
 public void add(Flight flight);
 public void update(Flight flight);
 public void delete(String flightNumber);
 public Flight findById(String flightNumber);
 public List<Flight> getFlightsStoredByPlane();
 public List<Flight> getFlightsByPeriod(LocalDateTime debut, LocalDateTime end);
 public List<Flight> getFlightsByCity(Long cityId);
}
