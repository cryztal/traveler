package com.cryztal.traveler.service;

import com.cryztal.traveler.domain.dto.AnswerDto;

public interface AnswerService {

    AnswerDto findById(Integer id);

    void addByCityId(Integer id, String answer);

    void addByCityName(String cityName, String answer);

}
