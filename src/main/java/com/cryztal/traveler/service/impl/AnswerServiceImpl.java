package com.cryztal.traveler.service.impl;

import com.cryztal.traveler.domain.dto.AnswerDto;
import com.cryztal.traveler.domain.entity.AnswerEntity;
import com.cryztal.traveler.domain.entity.CityEntity;
import com.cryztal.traveler.persistence.dao.AnswerDao;
import com.cryztal.traveler.persistence.dao.CityDao;
import com.cryztal.traveler.service.AnswerService;
import com.cryztal.traveler.service.converter.AnswerConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AnswerServiceImpl implements AnswerService {

    @Autowired
    private AnswerDao answerDao;

    @Autowired
    private CityDao cityDao;

    @Autowired
    private AnswerConverter answerConverter;
    @Override
    public AnswerDto findById(Integer id) {
        return answerConverter.convert(answerDao.findById(id).orElse(new AnswerEntity()));
    }

    @Override
    public void addByCityId(Integer id, String answerStr) {
        Optional<CityEntity> city = cityDao.findById(id);
        city.ifPresent(value -> answerDao.saveOrUpdate(new AnswerEntity(value, answerStr)));
    }

    @Override
    public void addByCityName(String cityName, String answerStr) {
        Optional<CityEntity> city = cityDao.findByCityName(cityName);
        city.ifPresent(value -> answerDao.saveOrUpdate(new AnswerEntity(value, answerStr)));
    }
}
