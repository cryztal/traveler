package com.cryztal.traveler.persistence.dao;

import com.cryztal.traveler.domain.entity.AnswerEntity;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AnswerDao {

    Optional<AnswerEntity> findById(Integer id);

    void saveOrUpdate(AnswerEntity answerEntity);
}
