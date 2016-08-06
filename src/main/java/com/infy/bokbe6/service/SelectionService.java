package com.infy.bokbe6.service;

import com.infy.bokbe6.beans.AerofoilsEntity;
import com.infy.bokbe6.dao.AerofoilDAO;

import java.util.List;

/**
 * Created by Sakshi Kukreti on 06-08-2016.
 */
public class SelectionService {
    /**
     * returns all aerofoil rows as objects
     *
     * @return
     */
    public List<AerofoilsEntity> getAerofoilsEntityList() {
        AerofoilDAO aerofoilDAO = new AerofoilDAO();
        List<AerofoilsEntity> aerofoilsEntityList = aerofoilDAO.findAll();
        return aerofoilsEntityList;

    }


    /**
     * returns the aerofoil object of specific aerofoil
     *
     * @param aerofoilName
     * @return
     */
    public List<AerofoilsEntity> getAerofoilEntity(String aerofoilName) {
        //aerofoil name contains NACA prefix which needs to be removed before searching in database

        aerofoilName = aerofoilName.replace("NACA ", "");

        AerofoilDAO aerofoilDAO = new AerofoilDAO();
        List<AerofoilsEntity> aerofoilsEntityList = aerofoilDAO.find(aerofoilName);

        return aerofoilsEntityList;
    }

}
