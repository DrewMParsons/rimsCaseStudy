package com.rims.drew.parsons.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rims.drew.parsons.entity.MenuItem;
import com.rims.drew.parsons.util.Constants;
/**
 * simple CRUD repository for the menu item table
 * includes custom query used in the search form
 * 
 * @see Constants
 * @author Drew
 *
 */
@Repository
public interface MenuItemRepository extends CrudRepository<MenuItem, Long>
{

	/*
	 * custom query used in menu item search form
	 */
	@Query(value= Constants.SEARCH_QUERY)
	List<MenuItem> search(String keyword);

	MenuItem findByTitle(String title);

}
