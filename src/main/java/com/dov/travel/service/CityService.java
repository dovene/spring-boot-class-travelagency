package com.dov.travel.service;

import java.util.List;

import com.dov.travel.model.City;

public interface CityService {
 public List<City> getAll();
 public void add(City city);
 public void update(City city);
 public void delete(Long id);
 public City findById(Long id);
}
