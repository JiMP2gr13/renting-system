package com.skteam.rentingsystem.dao;

import com.skteam.rentingsystem.entity.Category;
import com.skteam.rentingsystem.entity.Comment;
import com.skteam.rentingsystem.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CategoryDAOImpl implements CategoryDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveCategory(Category category) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(category);
    }

    @Override
    public Category getCategory(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(Category.class, id);
    }

    @Override
    public void deleteCategory(int id) {
        Session session = sessionFactory.getCurrentSession();
        @SuppressWarnings("rawtypes")
        Query query = session.createQuery("delete from category c where c.id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }

}
