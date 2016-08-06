package com.infy.bokbe6.service;

import com.infy.bokbe6.beans.AerofoilsEntity;
import com.infy.bokbe6.dao.AerofoilDAO;

import java.util.List;

/**
 * Created by Sakshi Kukreti on 06-08-2016.
 */
public class SelectionService {

    public List<AerofoilsEntity> getAerofoilsEntityList() {
        AerofoilDAO aerofoilDAO = new AerofoilDAO();
        List<AerofoilsEntity> aerofoilsEntityList = aerofoilDAO.findAll();
        return aerofoilsEntityList;

    }

}
