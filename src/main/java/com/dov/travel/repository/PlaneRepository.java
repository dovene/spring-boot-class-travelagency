package com.dov.travel.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.dov.travel.model.Plane;

public interface PlaneRepository  extends JpaRepository<Plane, Long> {
    
}
