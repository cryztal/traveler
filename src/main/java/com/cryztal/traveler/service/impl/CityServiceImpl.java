package com.cryztal.traveler.service.impl;

import com.cryztal.traveler.domain.dto.CityDto;
import com.cryztal.traveler.domain.entity.CityEntity;
import com.cryztal.traveler.persistence.dao.CityDao;
import com.cryztal.traveler.service.CityService;
import com.cryztal.traveler.service.converter.CityConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CityServiceImpl implements CityService {

    @Autowired
    private CityDao cityDao;

    @Autowired
    private CityConverter cityConverter;

    @Override
    public CityDto findById(Integer id) {
        return cityConverter.convert(cityDao.findById(id).get());
    }

    @Override
    public CityDto findByCityName(String cityName) {
        return cityConverter.convert(cityDao.findByCityName(cityName).orElse(new CityEntity()));
    }

    @Override
    public List<CityDto> findAllCities() {
        return cityDao.findAll().stream().map(cityConverter::convert).collect(Collectors.toList());
    }

    @Override
    public void addCity(CityEntity cityEntity) {
        cityDao.saveOrUpdate(cityEntity);
    }

    @Override
    public void addCity(String cityName) {
        CityEntity cityEntity = cityDao.findByCityName(cityName).orElse(new CityEntity());
        cityEntity.setCityName(cityName);
        cityDao.saveOrUpdate(cityEntity);
    }

    @Override
    public void editCity(Integer id, String cityName) {
        CityEntity cityEntity = cityDao.findById(id).orElse(new CityEntity());
        cityEntity.setCityName(cityName);
        cityDao.saveOrUpdate(cityEntity);
    }

    @Override
    public void deleteByCityId(Integer id) {
        cityDao.deleteCityById(id);
    }

    @Override
    public void deleteByCityName(String cityName) {
        cityDao.deleteCityByCityName(cityName);
    }
}
