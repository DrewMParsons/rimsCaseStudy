package com.rims.drew.parsons;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import com.rims.drew.parsons.entity.MenuItem;
import com.rims.drew.parsons.entity.OrderItem;
import com.rims.drew.parsons.entity.User;
import com.rims.drew.parsons.repository.OrderItemRepository;

@DataJpaTest
@AutoConfigureTestDatabase(replace= Replace.NONE)
public class OrderItemTest
{
	@Autowired
	private OrderItemRepository orderRepo;
	
	@Autowired
	private TestEntityManager entityManager;
	
	
	/*
	 * Test Repository. Adds a new order item to the order_menu_item table
	 * checks that the item is added by asserting the primary key is created, and is >=1
	 */
	@Test
	public void testAddMenuItemToOrder() {
		MenuItem menuItem = entityManager.find(MenuItem.class, 1L);
		User user = entityManager.find(User.class, 1L);
		
		OrderItem orderItem = new OrderItem();
		orderItem.setMenuItem(menuItem);
		orderItem.setUser(user);
		orderItem.setQuantity(2);
		
		OrderItem savedOrderItem = orderRepo.save(orderItem);
		
		assertTrue(savedOrderItem.getId()>=1);
	}
	
	
	/*
	 * @Test to see if the created query in orderItemsRepository is working
	 */
	@Test
	public void testFindOrderItemsByUser() {
		User user = new User();
		user.setId(1L);  //user is currently in the db and has order_items
		
		List<OrderItem> orderItems = orderRepo.findByUser(user);
		
		int actualAmountOfItemsInDB = 1;
		//check that length of orderItems == whats currently in the db(2)
		assertEquals(actualAmountOfItemsInDB,orderItems.size());
	}
	
	/*
	 * @Test to see if item is deleted from the OrderItem table
	 */
	@Test
	public void testDeleteOrderItemByUser() {
		User user = entityManager.find(User.class, 1L);
	
		List<OrderItem> orderItems = orderRepo.findByUser(user);
		orderRepo.deleteById(orderItems.get(0).getId());
		List<OrderItem> orderItemsAfterDelete = orderRepo.findByUser(user);
		//check if length of lists are not equal after the delete
		assertNotEquals(orderItems.size(), orderItemsAfterDelete.size());
	}

}
