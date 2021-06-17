package com.rims.drew.parsons;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import com.rims.drew.parsons.entity.MenuItem;
import com.rims.drew.parsons.repository.MenuItemRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace= Replace.NONE)
public class MenuItemTest
{
	
	@Autowired
	private MenuItemRepository menuItemRepo;
	
	/*
	 * @Test to see if new menu item is added to the database
	 * test is successful if the item added returns a value for id
	 */
	@Test
	public void testAddMenuItem() {
		
		MenuItem menuItem = new MenuItem();
		menuItem.setTitle("test");
		menuItem.setDescription("this is a test item");
		menuItem.setPrice(new BigDecimal(99.99));
		
		MenuItem savedMenuItem =menuItemRepo.save(menuItem);
		assertTrue(savedMenuItem.getId()>=1);
		assertEquals(savedMenuItem.getTitle(), menuItem.getTitle());
		
	}
	
	/*
	 * @Test to see if menu item can be edited using the repo save method
	 * test is successful if menuItem title is updated, and the id is the same
	 */
	@Test
	public void testEditMenuItem() {
		MenuItem menuItem = new MenuItem();
		menuItem.setTitle("testEdit");
		menuItem.setDescription("this is a test item for edit");
		menuItem.setPrice(new BigDecimal(99.99));
		
		MenuItem savedMenuItem =menuItemRepo.save(menuItem);
		
		savedMenuItem.setTitle("new test title");
		MenuItem editedMenuItem = menuItemRepo.save(savedMenuItem);
		
		assertEquals(editedMenuItem.getId(), savedMenuItem.getId());
		assertNotEquals(editedMenuItem.getTitle(), "testEdit");
		
	}

}
