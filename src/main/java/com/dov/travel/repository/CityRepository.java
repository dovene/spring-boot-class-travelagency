package com.dov.travel.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dov.travel.model.City;

public interface CityRepository  extends JpaRepository<City, Long> {
    
}
