package com.example.cities_service.controller;

import com.example.cities_service.Dto.CityDTO;
import com.example.cities_service.service.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/cities")
public class CitiesController {

    private ICityService cityService;
    public CitiesController(ICityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/hotels")
    public CityDTO getCitiesHotels(@RequestParam String name, @RequestParam String country) {
        return this.cityService.getCitiesHotels(name, country);
    }

}
