package com.dov.travel.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dov.travel.model.City;
import com.dov.travel.model.Flight;

import java.time.LocalDateTime;
import java.util.List;

public interface FlightRepository extends JpaRepository<Flight, String> {
    List<Flight> findByDepartureTimeBetween(LocalDateTime start, LocalDateTime end);
    List<Flight> findByDepartureCityNameAndDepartureTime(String cityName, LocalDateTime date);
    List<Flight> findByArrivalCityNameAndArrivalTime(String cityName, LocalDateTime date);
    List<Flight> findByDepartureCity(City city);
    List<Flight> findByArrivalCity(City city);
    List<Flight> findByDepartureCityId(Long cityId);
}
