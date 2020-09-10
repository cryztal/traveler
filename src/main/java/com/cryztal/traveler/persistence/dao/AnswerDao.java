package com.cryztal.traveler.persistence.dao;

import com.cryztal.traveler.domain.entity.AnswerEntity;
import com.cryztal.traveler.domain.entity.CityEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnswerDao {

    Optional<AnswerEntity> findById(Integer id);

    void saveOrUpdate(AnswerEntity answerEntity);

    void deleteAnswerById(Integer id);

    void deleteAnswersByCity(CityEntity cityEntity);
}
