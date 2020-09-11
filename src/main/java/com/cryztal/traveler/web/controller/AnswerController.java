package com.cryztal.traveler.web.controller;

import com.cryztal.traveler.domain.dto.AnswersDto;
import com.cryztal.traveler.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AnswerController {

    @Autowired
    private AnswerService answerService;

    @PostMapping("/answers/{cityId}")
    public void addAnswerForCity(@PathVariable("cityId") Integer id, @RequestBody AnswersDto answersDto) {
        answerService.addByCityId(id, answersDto.getAnswers());
    }

    @PostMapping("/answers/city")
    public void addAnswersForCity(@RequestParam("cityName") String cityName, @RequestBody AnswersDto answersDto) {
        answerService.addByCityName(cityName, answersDto.getAnswers());
    }

    @DeleteMapping("/answers/{answerId}")
    public void deleteAnswers(@PathVariable("answerId") Integer id) {
        answerService.deleteByAnswerId(id);
    }

    @DeleteMapping(value = "/answers")
    public void deleteAnswersByCityName(@RequestParam("cityName") String cityName) {
        answerService.deleteByCityName(cityName);
    }
}
