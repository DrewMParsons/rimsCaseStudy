package com.rims.drew.parsons.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rims.drew.parsons.entity.MenuItem;

@Repository
public interface MenuItemRepository extends CrudRepository<MenuItem, Long>
{

	@Query(value= "SELECT m FROM MenuItem m WHERE m.title LIKE '%' || :keyword || '%'"
			+ "OR m.description LIKE '%' || :keyword || '%'")
	List<MenuItem> search(String keyword);

	MenuItem findByTitle(String title);

}
