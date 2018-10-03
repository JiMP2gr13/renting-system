package com.skteam.rentingsystem.service;

import com.skteam.rentingsystem.entity.User;

public interface UserService {
    public void saveUser(User user);

    public User getUser(String username);

    public void deleteUser(String username);
}
