package com.dov.travel.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dov.travel.model.Flight;
import com.dov.travel.repository.FlightRepository;

@Service
public class FlightServiceImpl implements FlightService {

   @Autowired
   FlightRepository flightRepository;

    @Override
    public List<Flight> getAll() {
        return flightRepository.findAll();
    }

    @Override
    public void add(Flight flight) {
        flightRepository.save(flight);
    }

    @Override
    public void update(Flight flight) {
        if (findById(flight.getFlightNumber()) != null) {
            flightRepository.save(flight);
        }
    }

    @Override
    public void delete(String flightNumber) {
        flightRepository.deleteById(flightNumber);
    }

    @Override
    public Flight findById(String flightNumber) {
        Optional<Flight> optionalFlight = flightRepository.findById(flightNumber);
        if (optionalFlight.isPresent()) {
            return optionalFlight.get();
        }
        return null;
    }

    @Override
    public List<Flight> getFlightsStoredByPlane() {
        return getAll().stream()
		.sorted((o1, o2) -> o1.getPlane().getName().compareTo(o2.getPlane().getName()))
		.collect(Collectors.toList());
    }

    @Override
    public List<Flight> getFlightsByPeriod(LocalDateTime debut, LocalDateTime end) {
        return flightRepository.findByDepartureTimeBetween(debut, end);
    }

    @Override
    public List<Flight> getFlightsByCity(Long cityId) {
       return flightRepository.findByDepartureCityId(cityId);
    }
    
}
