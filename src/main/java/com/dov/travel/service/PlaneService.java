package com.dov.travel.service;

import java.util.List;

import com.dov.travel.model.Plane;

public interface PlaneService {
 public List<Plane> getAll();
 public void add(Plane plane);
 public void update(Plane plane);
 public void delete(Long id);
 public Plane findById(Long id);
}
