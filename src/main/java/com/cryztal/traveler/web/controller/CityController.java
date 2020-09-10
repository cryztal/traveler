package com.cryztal.traveler.web.controller;

import com.cryztal.traveler.domain.dto.CityDto;
import com.cryztal.traveler.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/cities")
    public List<CityDto> getCities() {
        return cityService.findAllCities();
    }

    @GetMapping("/cities/{cityId}")
    public CityDto getCity(@PathVariable("cityId") Integer id) {
        return cityService.findById(id);
    }

    @GetMapping("/city")
    public CityDto getCity(@RequestParam("cityName") String cityName) {
        return cityService.findByCityName(cityName);
    }

    @PostMapping("/city")
    public void addCity(@RequestParam("cityName") String cityName) {
        cityService.addCity(cityName);
    }

    @PutMapping("/city/{cityId}")
    public void editCity(@PathVariable("cityId") Integer id, @RequestParam("cityName") String cityName) {
        cityService.editCity(id, cityName);
    }
}
