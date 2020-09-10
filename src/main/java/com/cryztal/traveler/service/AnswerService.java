package com.cryztal.traveler.service;

import com.cryztal.traveler.domain.dto.AnswerDto;

import java.util.List;

public interface AnswerService {

    AnswerDto findById(Integer id);

    void addByCityId(Integer id, String answer);

    void addByCityName(String cityName, String answer);

    void addByCityId(Integer id, List<String> answers);

    void addByCityName(String cityName, List<String> answers);

    void deleteByAnswerId(Integer id);

    void deleteByCityId(Integer cityId);

    void deleteByCityName(String cityName);
}
