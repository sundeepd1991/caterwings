/**
 * 
 */
package com.caterwings.productdemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caterwings.productdemo.controller.VendorView;
import com.caterwings.productdemo.data.entity.Vendor;
import com.caterwings.productdemo.data.repository.VendorRepository;
import com.caterwings.productdemo.service.VendorService;

/**
 * @author Sundeep D
 *
 * This class implements the CRUD operations in the service layer
 */
@Service
public class VendorServiceImpl implements VendorService {

	@Autowired
	private VendorRepository vendorRepository;

	@Override
	public Vendor findByUID(String uid) {
		return vendorRepository.findByVendorUID(uid);
	}

	@Override
	public Vendor findById(int uid) {
		return vendorRepository.findById(uid).get();
	}

	@Override
	public Vendor save(VendorView vendorView) {
		return vendorRepository.save(createVendor(vendorView));
	}

	private Vendor createVendor(VendorView vendorView) {
		Vendor vendor = new Vendor();
		vendor.setName(vendorView.getName());
		vendor.setVendorUID(vendorView.getUid());
		return vendor;
	}

}
