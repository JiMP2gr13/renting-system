package com.skteam.rentingsystem.service;

import com.skteam.rentingsystem.entity.Category;
import com.skteam.rentingsystem.entity.Comment;
import com.skteam.rentingsystem.entity.User;

import java.util.List;

public interface CategoryService {
    public void saveCategory(Category category);

    public Category getCategory(int id);

    public void deleteCategory(int id);
}
