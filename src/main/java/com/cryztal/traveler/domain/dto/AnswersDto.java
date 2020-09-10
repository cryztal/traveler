package com.cryztal.traveler.domain.dto;

import java.util.List;

public class AnswersDto {

    private List<String> answers;

    public AnswersDto(List<String> answers) {
        this.answers = answers;
    }

    public List<String> getAnswers() {
        return answers;
    }

    public void setAnswers(List<String> answers) {
        this.answers = answers;
    }
}
