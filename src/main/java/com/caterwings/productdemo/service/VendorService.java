/**
 * 
 */
package com.caterwings.productdemo.service;

import org.springframework.stereotype.Service;

import com.caterwings.productdemo.controller.VendorView;
import com.caterwings.productdemo.data.entity.Vendor;

/**
 * @author Sundeep D
 *
 */
@Service
public interface VendorService {

	Vendor findByUID(final String uid);

	Vendor findById(final int id);

	Vendor save(VendorView vendor);
	
}
