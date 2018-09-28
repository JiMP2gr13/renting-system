package com.skteam.rentingsystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.skteam.rentingsystem.entity.Item;
import com.skteam.rentingsystem.entity.User;

public class ItemDAOImpl implements ItemDAO {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public void saveItem(Item item) {
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(item);
	}

	@Override
	public Item getItem(int id) {
		Session session = sessionFactory.getCurrentSession();
		return session.get(Item.class, id);
	}

	@Override
	public List<Item> getAllItems() {
		Session session = sessionFactory.getCurrentSession();
		return session.createQuery("select i from Item i", Item.class).getResultList();
	}

	@Override
	public List<Item> getUserOwnedItems(User user) {
		Session session = sessionFactory.getCurrentSession();
		//Query<Item> query = session.createQuery("select i from Item i where i.owner.") do zas
		return null;
	}

	@Override
	public void deleteItem(int id) {
		// TODO Auto-generated method stub

	}

}
