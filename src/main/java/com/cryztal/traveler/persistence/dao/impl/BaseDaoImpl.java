package com.cryztal.traveler.persistence.dao.impl;

import com.cryztal.traveler.persistence.dao.BaseDao;
import org.hibernate.Session;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class BaseDaoImpl implements BaseDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public Session getSession() {
        return entityManager.unwrap(Session.class);
    }
}

