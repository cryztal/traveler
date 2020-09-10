package com.cryztal.traveler.domain.dto;

import java.util.List;

public class CityDto {

    private String cityName;

    private List<AnswerDto> answers;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public List<AnswerDto> getAnswers() {
        return answers;
    }

    public void setAnswers(List<AnswerDto> answers) {
        this.answers = answers;
    }
}
