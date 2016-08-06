package com.infy.bokbe6.service;

import com.infy.bokbe6.beans.CoordinatesEntity;
import com.infy.bokbe6.dao.CoordinatesDAO;

import java.util.List;

/**
 * Created by Sakshi Kukreti on 06-08-2016.
 */
public class DetailService {

    public List<CoordinatesEntity> getCoordinates(Long aerofoilID) {

        CoordinatesDAO coordinatesDAO = new CoordinatesDAO();
        List<CoordinatesEntity> coordinatesEntities = coordinatesDAO.find(aerofoilID);
        return coordinatesEntities;

    }


}
