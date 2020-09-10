package com.cryztal.traveler.service;

import com.cryztal.traveler.domain.dto.CityDto;
import com.cryztal.traveler.domain.entity.CityEntity;

import java.util.List;

public interface CityService {

    CityDto findById(Integer id);

    CityDto findByCityName(String cityName);

    List<CityDto> findAllCities();

    void addCity(CityEntity cityEntity);

    void addCity(String cityName);


    void editCity(Integer id, String cityName);
}
