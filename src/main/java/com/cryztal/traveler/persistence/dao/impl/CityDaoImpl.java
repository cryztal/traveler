package com.cryztal.traveler.persistence.dao.impl;

import com.cryztal.traveler.domain.entity.CityEntity;
import com.cryztal.traveler.persistence.dao.CityDao;
import org.hibernate.Session;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class CityDaoImpl extends BaseDaoImpl implements CityDao {

    @Override
    public Optional<CityEntity> findByCityName(String cityName) {
        Session session = getSession();
        return session.createQuery("from City c where c.cityName = :cityName", CityEntity.class)
                .setParameter("cityName", cityName)
                .uniqueResultOptional();
    }

    @Override
    public Optional<CityEntity> findById(Integer id) {
        Session session = getSession();
        return session.createQuery("from City c where c.id = :id", CityEntity.class)
                .setParameter("id", id)
                .uniqueResultOptional();
    }

    @Override
    public List<CityEntity> findAll() {
        Session session = getSession();
        return session.createQuery("from City c", CityEntity.class)
                .list();
    }

    @Override
    public void saveOrUpdate(CityEntity cityEntity) {
        Session session = getSession();
        session.saveOrUpdate(cityEntity);
    }

}
