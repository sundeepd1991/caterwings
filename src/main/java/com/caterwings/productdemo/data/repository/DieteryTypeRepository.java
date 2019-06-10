/**
 * 
 */
package com.caterwings.productdemo.data.repository;

import java.util.Collection;
import java.util.Set;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.caterwings.productdemo.data.entity.DietaryType;

/**
 * @author Sundeep D
 * 
 * This class creates all the basic CRUD operations in the database by extending Crud Repository
 *
 */
@Repository
public interface DieteryTypeRepository extends CrudRepository<DietaryType, Integer> {

	@Query("from DietaryType where value in :values")
	Collection<DietaryType> findAllByValue(final @Param("values") Set<String> dietaryTypesFromRequest);

	DietaryType findByValue(final String value);
}
