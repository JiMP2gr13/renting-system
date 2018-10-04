package com.skteam.rentingsystem.dao;

import com.skteam.rentingsystem.entity.Category;
import com.skteam.rentingsystem.entity.RentDetails;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RentDetailsDAOImpl implements RentDetailsDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveRentDetails(RentDetails rentDetails) {
        Session session = sessionFactory.getCurrentSession();
        session.saveOrUpdate(rentDetails);
    }

    @Override
    public RentDetails getRentDetails(int id) {
        Session session = sessionFactory.getCurrentSession();
        return session.get(RentDetails.class, id);
    }

    @Override
    public void deleteRentDetails(int id) {
        Session session = sessionFactory.getCurrentSession();
        @SuppressWarnings("rawtypes")
        Query query = session.createQuery("delete from rent-item ri where ri.id=:id");
        query.setParameter("id", id);
        query.executeUpdate();
    }
}
