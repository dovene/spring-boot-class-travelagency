package com.dov.travel.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.dov.travel.model.Plane;
import com.dov.travel.service.PlaneService;

@Controller
@RequestMapping("/plane")
public class PlaneController {
     @Autowired
    private PlaneService planeService;

    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("planes", planeService.getAll());
        return "plane/list";
    }

    @GetMapping("/add")
    public String displayAddForm(Plane plane) {
        return "plane/add";
    }

    @PostMapping("/add")
    public String processAdd(Plane plane) {
        planeService.add(plane);
        return "redirect:/plane/list";
    }

    @GetMapping("/update/{id}")
    public String displayUpdateForm(@PathVariable("id") Long id, Model model) {
        Plane plane = planeService.findById(id);
        model.addAttribute("plane", plane);
        return "plane/update";
    }

    @PostMapping("/update")
    public String processUpdate(Plane plane) {
        planeService.update(plane);
        return "redirect:/plane/list";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        planeService.delete(id);
        return "redirect:/plane/list";
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/plane/list";
    }
}
