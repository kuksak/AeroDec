package com.infy.bokbe6.service;

import com.infy.bokbe6.beans.UsersEntity;
import com.infy.bokbe6.dao.UsersDAO;

import java.util.List;

/**
 * Created by Sakshi Kukreti on 06-08-2016.
 */
public class LoginService {

    /**
     * checking the user credentials
     *
     * @param username
     * @param password
     * @return
     */
    public boolean login(String username, String password) {
        boolean flag = false;
        UsersDAO usersDAO = new UsersDAO();
        List<UsersEntity> usersEntityList = usersDAO.find(username);
        for (UsersEntity usersEntity : usersEntityList) {
            if (usersEntity.getPassword().equals(password)) {
                flag = true;
            }
        }
        return flag;
    }

}
