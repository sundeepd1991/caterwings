/**
 * 
 */
package com.caterwings.productdemo.data.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

import com.caterwings.productdemo.data.entity.Product;

/**
 * @author Sundeep D
 * 
 * This class creates all the basic CRUD operations in the database by extending Crud Repository
 *
 */
@Repository
@Transactional
public interface ProductRepository extends CrudRepository<Product, Integer> {

	// Updating views for a product using productID
	// the views incremented here are asynchronous and handled according to concurrent threads
	@Modifying
	@Query("update Product p set p.views=p.views+1 where id=:id")
	@Async
	void updateViews(final @Param("id") int id);
	// finds the products by title and description
	List<Product> findByTitleContaining(final String title);
	List<Product> findByDescriptionContaining(final String description);
}
