package com.skteam.rentingsystem.test.daotest;

import static org.junit.Assert.assertTrue;

import java.util.List;

import javax.transaction.Transactional;

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
	
	@Test
	@Transactional
	@Rollback(true)
	public void saveItemTest() {
		User user = new User();
		user.setFirstName("Adam");
		user.setLastName("Kowalski");
		
		Category category = new Category("rowery");
		Item item = new Item("Rower", category, "C:/user/costam", "these are details", user, 10D);
		itemDAO.saveItem(item);
		categoryDAO.saveCategory(category);
		

		List<Item> items = itemDAO.getAllItems();

		assertTrue(items.size() == 1);
		assertTrue(items.get(0).getName().equals(item.getName()));

	}

}
