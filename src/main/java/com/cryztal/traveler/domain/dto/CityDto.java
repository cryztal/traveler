package com.cryztal.traveler.domain.dto;

import java.util.List;

public class CityDto {

    private String cityName;

    private List<AnswerDto> answerDto;

    public List<AnswerDto> getAnswerDto() {
        return answerDto;
    }

    public void setAnswerDto(List<AnswerDto> answerDto) {
        this.answerDto = answerDto;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

}
