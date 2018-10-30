package com.skteam.rentingsystem.test.daotest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.transaction.Transactional;

import com.skteam.rentingsystem.dao.UserDAO;
import com.skteam.rentingsystem.service.ItemService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.skteam.rentingsystem.dao.CategoryDAO;
import com.skteam.rentingsystem.dao.ItemDAO;
import com.skteam.rentingsystem.entity.Category;
import com.skteam.rentingsystem.entity.Item;
import com.skteam.rentingsystem.entity.User;
import com.skteam.rentingsystem.test.config.TestConfig;

@ContextConfiguration(classes = TestConfig.class, loader = AnnotationConfigContextLoader.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class ItemDAOTest {

	@Autowired
	private ItemDAO itemDAO;

	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	private UserDAO userDAO;
	
	@Test
	@Transactional
	@Rollback(true)
	public void saveItemTest() {
		User user = new User();
		user.setUsername("adasKKK");
		user.setFirstName("Adam");
		user.setLastName("Kowalski");
		userDAO.saveUser(user);

		Category category = new Category("rowery");
		categoryDAO.saveCategory(category);

		Item item = new Item("Rower", category, "C:/user/costam", "these are details", user, 10D);
		itemDAO.saveItem(item);

		List<Item> items = itemDAO.getAllItems();

		assertNotNull(items);
		assertTrue(items.size() == 1);
		assertTrue(items.get(0).getName().equals(item.getName()));
	}

	@Test
	@Transactional
	@Rollback(true)
	public void getAllItemsTest() {
		User user = new User();
		user.setUsername("adasKKK");
		user.setFirstName("Adam");
		user.setLastName("Kowalski");
		userDAO.saveUser(user);

		User user2 = new User();
		user2.setUsername("janKKK2");
		user2.setFirstName("Jan");
		user2.setLastName("Kowalski");
		userDAO.saveUser(user2);

		Category category = new Category("rowery");
		categoryDAO.saveCategory(category);

		Item item = new Item("Rower", category, "C:/user/costam",
				"these are details", user, 10D);
		itemDAO.saveItem(item);

		Item item2 = new Item("Rower2", category, "C:/user/costam2",
				"these 2 are details", user2, 10D);
		itemDAO.saveItem(item2);

		List<Item> items = itemDAO.getAllItems();

		assertNotNull(items);
		assertTrue(items.size() == 2);
		assertTrue(items.get(0).getName().equals(item.getName()));
		assertTrue(items.get(1).getName().equals(item2.getName()));

	}

	@Test
	@Transactional
	@Rollback(true)
	public void getUserOwnedItemsTest() {
		User user = new User();
		user.setUsername("adasKKK");
		user.setFirstName("Adam");
		user.setLastName("Kowalski");
		userDAO.saveUser(user);

		Category category = new Category("rowery");
		categoryDAO.saveCategory(category);

		Item item = new Item("Rower", category, "C:/user/costam",
				"these are details", user, 10D);
		itemDAO.saveItem(item);

		Item item2 = new Item("Rower2", category, "C:/user/costam2",
				"these 2 are details", user, 10D);
		itemDAO.saveItem(item2);

		List<Item> items = itemDAO.getAllItems();

		assertNotNull(items);
		assertTrue(items.size() == 2);
		assertTrue(items.get(0).getName().equals(item.getName()));
		assertTrue(items.get(1).getName().equals(item2.getName()));

	}

	@Test
	@Transactional
	@Rollback(true)
	public void deleteItemTest() {
		User user = new User();
		user.setUsername("adasKKK");
		user.setFirstName("Adam");
		user.setLastName("Kowalski");
		userDAO.saveUser(user);

		Category category = new Category("rowery");
		categoryDAO.saveCategory(category);

		Item item = new Item("Rower", category, "C:/user/costam", "these are details", user, 10D);
		itemDAO.saveItem(item);

		itemDAO.deleteItem(1);

		List<Item> items = itemDAO.getAllItems();

		assertTrue(items.size() == 0);

	}





}
