package com.skteam.rentingsystem.dao;

import java.util.List;

import com.skteam.rentingsystem.entity.Item;
import com.skteam.rentingsystem.entity.User;

public interface ItemDAO {
	public void saveItem(Item item);

	public Item getItem(int id);

	public List<Item> getAllItems();

	public List<Item> getUserOwnedItems(User user);

	public void deleteItem(int id);
}
