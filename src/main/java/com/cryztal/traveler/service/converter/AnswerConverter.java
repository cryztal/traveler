package com.cryztal.traveler.service.converter;

import com.cryztal.traveler.domain.dto.AnswerDto;
import com.cryztal.traveler.domain.entity.AnswerEntity;
import org.springframework.stereotype.Component;

@Component
public class AnswerConverter {

    public AnswerDto convert(AnswerEntity answerEntity){
        AnswerDto answerDto = new AnswerDto();
        answerDto.setAnswer(answerEntity.getAnswer());
        return answerDto;
    }
}
