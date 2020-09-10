package com.cryztal.traveler.persistence.dao;

import org.hibernate.Session;
public interface BaseDao {

    Session getSession();
}
