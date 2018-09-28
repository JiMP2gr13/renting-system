package com.skteam.rentingsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skteam.rentingsystem.dao.ItemDAO;
import com.skteam.rentingsystem.entity.Item;
import com.skteam.rentingsystem.entity.User;

@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	ItemDAO itemDAO;

	@Transactional
	@Override
	public void saveItem(Item item) {
		itemDAO.saveItem(item);
	}

	@Transactional
	@Override
	public Item getItem(int id) {
		return itemDAO.getItem(id);
	}

	@Transactional
	@Override
	public List<Item> getAllItems() {
		return itemDAO.getAllItems();
	}

	@Transactional
	@Override
	public List<Item> getUserOwnedItems(User user) {
		return itemDAO.getUserOwnedItems(user);
	}

	@Transactional
	@Override
	public void deleteItem(int id) {
		itemDAO.deleteItem(id);
	}

}
