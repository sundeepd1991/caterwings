/**
 * 
 */
package com.caterwings.productdemo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caterwings.productdemo.data.entity.Vendor;
import com.caterwings.productdemo.service.VendorService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Sundeep D
 *
 *This class performs all the CRUD operations for Vendor
 */
@RestController
@RequestMapping("/vendors")
@Api(value="Vendor API End points")
public class VendorController extends AbstractBaseController {

	@Autowired
	VendorService vendorService;

	@ApiOperation(value = "Create Vendor")
	@PostMapping
	public ResponseEntity<Vendor> createVendor(@Valid @RequestBody VendorView vendorView) {
		return response(vendorService.save(vendorView), HttpStatus.OK);
	}

	@ApiOperation(value = "Fetch Vendor by ID.")
	@GetMapping("/{id}")
	public ResponseEntity<Vendor> fetchByid(@PathVariable("id") int id) {
		return response(vendorService.findById(id),HttpStatus.OK);
	}

	@ApiOperation(value = "Delete Vendor by Unique UUID")
	@DeleteMapping("/uid/{uid}")
	public Vendor deleteByid(@PathVariable("uid") String id) {
		return vendorService.findByUID(id);
	}

}
