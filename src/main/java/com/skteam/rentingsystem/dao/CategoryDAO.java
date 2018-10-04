package com.skteam.rentingsystem.dao;

import com.skteam.rentingsystem.entity.Category;
import com.skteam.rentingsystem.entity.Comment;
import com.skteam.rentingsystem.entity.User;

import java.util.List;


public interface CategoryDAO {
    public void saveCategory(Category category);

    public Category getCategory(int id);

    public void deleteCategory(int id);
}
