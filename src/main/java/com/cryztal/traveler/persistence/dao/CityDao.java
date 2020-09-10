package com.cryztal.traveler.persistence.dao;

import com.cryztal.traveler.domain.entity.CityEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CityDao {
    Optional<CityEntity> findByCityName(String cityName);

    Optional<CityEntity> findById(Integer id);

    List<CityEntity> findAll();

    void saveOrUpdate(CityEntity cityEntity);

    void deleteCityById(Integer id);

    void deleteCityByCityName(String cityName);
}
