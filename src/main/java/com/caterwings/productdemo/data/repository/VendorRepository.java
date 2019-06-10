/**
 * 
 */
package com.caterwings.productdemo.data.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.caterwings.productdemo.data.entity.Vendor;

/**
 * @author Sundeep D
 * 
 * This class creates all the basic CRUD operations in the database by extending Crud Repository
 *
 */
@Repository
public interface VendorRepository extends CrudRepository<Vendor, Integer> {
	Vendor findByVendorUID(final String uid);
}
