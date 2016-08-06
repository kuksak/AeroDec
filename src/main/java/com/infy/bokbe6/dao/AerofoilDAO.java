package com.infy.bokbe6.dao;

import com.infy.bokbe6.beans.AerofoilsEntity;
import com.infy.bokbe6.utils.DAOUtil;
import com.infy.bokbe6.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import java.util.List;

/**
 * Created by Sakshi Kukreti on 06-08-2016.
 */
public class AerofoilDAO {

    /**
     * save a new Aerofoils Entity
     *
     * @param aerofoilsEntity new entity to save
     * @return newly created id
     */
    public Integer insert(AerofoilsEntity aerofoilsEntity) {
        return DAOUtil.saveObject(aerofoilsEntity);
    }

    /**
     * fetch aerofoil data for an aerofoil name
     *
     * @param aerofoilName
     * @return
     */
    public List<AerofoilsEntity> find(String aerofoilName) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        transaction.begin();

        Criteria criteria = session.createCriteria(AerofoilsEntity.class);
        criteria.add(Restrictions.eq("aerofoilName", aerofoilName));

        List<AerofoilsEntity> aerofoilsEntities = criteria.list();

        transaction.commit();
        return aerofoilsEntities;


    }

    public List<AerofoilsEntity> findAll() {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        transaction.begin();

        Criteria criteria = session.createCriteria(AerofoilsEntity.class);
        List<AerofoilsEntity> aerofoilsEntities = criteria.list();
        transaction.commit();

        return aerofoilsEntities;
    }
}
