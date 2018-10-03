package com.skteam.rentingsystem.dao;

import com.skteam.rentingsystem.entity.Category;
import com.skteam.rentingsystem.entity.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAOImpl implements UserDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveUser(User user) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(user);
    }

    @Override
    public User getUser(String username) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(User.class, username);
    }

    @Override
    public void deleteUser(String username) {

        Session session = sessionFactory.getCurrentSession();
        @SuppressWarnings("rawtypes")
        Query query = session.createQuery("delete from user u where u.username=:username");
        query.setParameter("username", username);
        query.executeUpdate();

    }
}
