package com.infy.bokbe6.utils;

import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 * Created by Sakshi Kukreti on 06-08-2016.
 */
public class DAOUtil {
    public static Integer saveObject(Object object) {

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        transaction.begin();

        Integer id = (Integer) session.save(object);

        transaction.commit();
        return id;
    }


}
