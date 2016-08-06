package com.infy.bokbe6.dao;

import com.infy.bokbe6.beans.CoordinatesEntity;
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
public class CoordinatesDAO {

    /**
     * save a new coordinate into the database
     *
     * @param coordinatesEntity
     * @return
     */
    public Integer insert(CoordinatesEntity coordinatesEntity) {
        return DAOUtil.saveObject(coordinatesEntity);

    }

    /**
     * Fetch all the coordinates for this NACA id
     *
     * @param id naca id
     * @return
     */
    public List<CoordinatesEntity> find(long id) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        transaction.begin();
        Criteria criteria = session.createCriteria(CoordinatesEntity.class);
        criteria.add(Restrictions.eq("id", id));
        List<CoordinatesEntity> coordinatesEntities = criteria.list();
        transaction.commit();
        return coordinatesEntities;
    }
}
