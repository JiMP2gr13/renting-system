package com.skteam.rentingsystem.test.daotest;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import com.skteam.rentingsystem.dao.UserDAO;
import com.skteam.rentingsystem.entity.User;
import com.skteam.rentingsystem.test.config.TestConfig;

@ContextConfiguration(classes = TestConfig.class, loader = AnnotationConfigContextLoader.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class UserDAOTest {
	
	@Autowired
	private UserDAO userDAO;
	
	@Test
	@Transactional
	@Rollback
	public void testSaveUser() {
		User user = new User("sasza", "Adam", "Kowalski", "kowal@gmail.com");
		
		userDAO.saveUser(user);
		
		User resultUser = userDAO.getUser("sasza");
		
		assertNotNull(resultUser);
		assertTrue(user.getEmail().equals(resultUser.getEmail()));
		assertTrue(user.getUsername().equals(resultUser.getUsername()));
	}
	
}
