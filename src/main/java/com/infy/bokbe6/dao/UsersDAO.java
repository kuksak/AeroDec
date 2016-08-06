package com.infy.bokbe6.dao;

import com.infy.bokbe6.beans.UsersEntity;
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
public class UsersDAO {

    /**
     * add a new user
     *
     * @param usersEntity user object to add
     * @return newly added user id
     */
    public Integer insert(UsersEntity usersEntity) {
        return DAOUtil.saveObject(usersEntity);
    }

    /**
     * find a user by its username
     *
     * @param username user name to find
     * @return user data
     */
    public List<UsersEntity> find(String username) {
        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        transaction.begin();
        Criteria criteria = session.createCriteria(UsersEntity.class);
        criteria.add(Restrictions.eq("username", username));
        List<UsersEntity> usersEntities = criteria.list();
        transaction.commit();
        return usersEntities;
    }
}
