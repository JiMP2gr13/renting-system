package com.skteam.rentingsystem.service;

import com.skteam.rentingsystem.dao.CategoryDAO;
import com.skteam.rentingsystem.entity.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    CategoryDAO categoryDAO;

    @Transactional
    @Override
    public void saveCategory(Category category) {
        categoryDAO.saveCategory(category);
    }

    @Transactional
    @Override
    public Category getCategory(int id) {
        return categoryDAO.getCategory(id);
    }

    @Transactional
    @Override
    public void deleteCategory(int id) {

        categoryDAO.deleteCategory(id);
    }
}
