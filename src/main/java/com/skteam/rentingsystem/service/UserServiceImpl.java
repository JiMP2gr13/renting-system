package com.skteam.rentingsystem.service;

import com.skteam.rentingsystem.dao.UserDAO;
import com.skteam.rentingsystem.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserDAO userDAO;

    @Transactional
    @Override
    public void saveUser(User user) {
        userDAO.saveUser(user);
    }

    @Transactional
    @Override
    public User getUser(String username) {
        return userDAO.getUser(username);
    }

    @Override
    public void deleteUser(String username) {
        userDAO.deleteUser(username);
    }
}
