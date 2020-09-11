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

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
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
        Optional<CityEntity> cityEntity = cityDao.findById(id);
        cityEntity.ifPresent(value -> answerDao.saveOrUpdate(new AnswerEntity(value, answerStr)));
    }

    @Override
    public void addByCityName(String cityName, String answerStr) {
        Optional<CityEntity> cityEntity = cityDao.findByCityName(cityName);
        cityEntity.ifPresent(value -> answerDao.saveOrUpdate(new AnswerEntity(value, answerStr)));
    }

    @Override
    public void addByCityId(Integer id, List<String> answers) {
        Optional<CityEntity> cityEntity = cityDao.findById(id);
        cityEntity.ifPresent(entity -> addListOfAnswers(entity, answers));
    }

    @Override
    public void addByCityName(String cityName, List<String> answers) {
        Optional<CityEntity> cityEntity = cityDao.findByCityName(cityName);
        cityEntity.ifPresent(entity -> addListOfAnswers(entity, answers));
    }

    @Override
    public void deleteByAnswerId(Integer id) {
        answerDao.deleteAnswerById(id);
    }

    @Override
    public void deleteByCityId(Integer cityId) {
        Optional<CityEntity> cityEntity = cityDao.findById(cityId);
        cityEntity.ifPresent(entity -> answerDao.deleteAnswersByCity(entity));
    }

    @Override
    public void deleteByCityName(String cityName) {
        Optional<CityEntity> cityEntity = cityDao.findByCityName(cityName);
        cityEntity.ifPresent(entity -> answerDao.deleteAnswersByCity(entity));
    }

    private void addListOfAnswers(CityEntity cityEntity, List<String> answers) {
        List<AnswerEntity> answerEntities = answers.stream().map(value -> new AnswerEntity(cityEntity, value)).collect(Collectors.toList());
        answerEntities.stream().forEach(value -> answerDao.saveOrUpdate(value));
    }
}
