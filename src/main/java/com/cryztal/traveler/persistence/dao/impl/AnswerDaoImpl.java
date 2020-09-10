package com.cryztal.traveler.persistence.dao.impl;

import com.cryztal.traveler.domain.entity.AnswerEntity;
import com.cryztal.traveler.persistence.dao.AnswerDao;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class AnswerDaoImpl extends BaseDaoImpl implements AnswerDao {

    @Override
    public Optional<AnswerEntity> findById(Integer id) {
        Session session = getSession();
        return Optional.ofNullable(session
                .createQuery("from Answer a where a.id = :id", AnswerEntity.class)
                .setParameter("id", id)
                .uniqueResult());
    }

    @Override
    public void saveOrUpdate(AnswerEntity answerEntity) {
        Session session = getSession();
        session.saveOrUpdate(answerEntity);
    }

}
