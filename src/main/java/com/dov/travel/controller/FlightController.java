package com.dov.travel.controller;


import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dov.travel.model.Flight;
import com.dov.travel.service.CityService;
import com.dov.travel.service.FlightService;
import com.dov.travel.service.PlaneService;

@Controller
@RequestMapping("/flight")
public class FlightController {
    @Autowired
    private CityService cityService;
    @Autowired
    private PlaneService planeService;
    @Autowired
    private FlightService flightService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("flights", flightService.getAll());
        model.addAttribute("cities", cityService.getAll());
        return "flight/list";
    }

    @GetMapping("/add")
    public String displayAddForm(Flight flight, Model model) {
        model.addAttribute("cities", cityService.getAll());
        model.addAttribute("planes", planeService.getAll());
        return "flight/add";
    }

    @PostMapping("/add")
    public String processAdd(Flight flight) {
        flightService.add(flight);
        return "redirect:/flight/list";
    }

    @GetMapping("/update/{flightNumber}")
    public String displayUpdateForm(@PathVariable("flightNumber") String flightNumber, Model model) {
        model.addAttribute("cities", cityService.getAll());
        model.addAttribute("planes", planeService.getAll());
        Flight flight = flightService.findById(flightNumber);
        model.addAttribute("flight", flight);
        return "flight/update";
    }

    @PostMapping("/update")
    public String processUpdate(Flight flight) {
        flightService.update(flight);
        return "redirect:/flight/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") String flightNumber) {
        flightService.delete(flightNumber);
        return "redirect:/flight/list";
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/flight/list";
    }

    @GetMapping("/sorted")
    public String sorted(Model model) {
        model.addAttribute("flights", flightService.getFlightsStoredByPlane());
        model.addAttribute("cities", cityService.getAll());
        return "flight/list";
    }

    @GetMapping("/city")
    public String filterByCity(@RequestParam("cityId") Long cityId, Model model) {
        model.addAttribute("flights", flightService.getFlightsByCity(cityId));
        model.addAttribute("cities", cityService.getAll());
        return "flight/list";
    }

    @GetMapping("/period")
    public String getFlightsByPeriod(@RequestParam("start") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
                                     @RequestParam("end") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end,
                                     Model model) {
        List<Flight> flights = flightService.getFlightsByPeriod(start, end);
        model.addAttribute("flights", flights);
        model.addAttribute("cities", cityService.getAll());
        return "flight/list";
    }

}
