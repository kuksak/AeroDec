package com.infy.bokbe6.dao;

import com.infy.bokbe6.beans.AerofoilsEntity;
import com.infy.bokbe6.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * Created by Sakshi Kukreti on 06-08-2016.
 */
public class AerofoilDAOTest {

    @Before
    public void setup() {
        AerofoilsEntity aerofoilsEntity = new AerofoilsEntity();
        aerofoilsEntity.setAerofoilDescription("0006");
        aerofoilsEntity.setAerofoilName("0006");

        Session session = HibernateUtil.getSessionFactory().getCurrentSession();
        Transaction transaction = session.beginTransaction();
        transaction.begin();
        session.save(aerofoilsEntity);
        transaction.commit();
    }

    @Test
    public void testFind() {

        AerofoilDAO aerofoilDAO = new AerofoilDAO();
        List<AerofoilsEntity> aerofoilsEntities = aerofoilDAO.find("0006");
        Assert.assertNotNull(aerofoilsEntities);
        Assert.assertTrue(aerofoilsEntities.size() > 0);
        Assert.assertEquals(1, aerofoilsEntities.size());

    }

}
