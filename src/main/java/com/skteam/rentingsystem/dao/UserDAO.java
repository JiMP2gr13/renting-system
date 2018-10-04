package com.skteam.rentingsystem.dao;

import com.skteam.rentingsystem.entity.Category;
import com.skteam.rentingsystem.entity.User;

public interface UserDAO {
    public void saveUser(User user);

    public User getUser(String username);

    public void deleteUser(String username);
}
