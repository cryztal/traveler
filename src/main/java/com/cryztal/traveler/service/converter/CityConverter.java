package com.cryztal.traveler.service.converter;

import com.cryztal.traveler.domain.dto.CityDto;
import com.cryztal.traveler.domain.entity.CityEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class CityConverter {

    @Autowired
    private AnswerConverter answerConverter;

    public CityDto convert(CityEntity cityEntity) {
        CityDto cityDto = new CityDto();
        cityDto.setCityName(cityEntity.getCityName());
        cityDto.setAnswerDto(cityEntity.getAnswers().stream().map(answerConverter::convert).collect(Collectors.toList()));
        return cityDto;
    }
}
