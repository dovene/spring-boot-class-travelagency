package com.dov.travel.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dov.travel.model.Plane;
import com.dov.travel.repository.PlaneRepository;

@Service
public class PlaneServiceImpl implements PlaneService {

   @Autowired
   PlaneRepository planeRepository;

    @Override
    public List<Plane> getAll() {
       return planeRepository.findAll();
   }

    @Override
    public void add(Plane city) {
        planeRepository.save(city);
    }

    @Override
    public void update(Plane city) {
        if (findById(city.getId()) != null) {
            planeRepository.save(city);
        }
    }

    @Override
    public void delete(Long id) {
        planeRepository.deleteById(id);
    }

    @Override
    public Plane findById(Long id) {
        Optional<Plane> optionalCity = planeRepository.findById(id);
        if (optionalCity.isPresent()) {
            return optionalCity.get();
        }
        return null;
    }
    
}
