package com.rims.drew.parsons.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.rims.drew.parsons.entity.MenuItem;
import com.rims.drew.parsons.util.Constants;

@Repository
public interface MenuItemRepository extends CrudRepository<MenuItem, Long>
{

	@Query(value= Constants.SEARCH_QUERY)
	List<MenuItem> search(String keyword);

	MenuItem findByTitle(String title);

}
