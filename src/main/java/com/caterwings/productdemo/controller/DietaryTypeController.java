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

import com.caterwings.productdemo.data.entity.DietaryType;
import com.caterwings.productdemo.service.DietaryTypeService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Sundeep D
 *
 *         This class performs all the CRUD operations for Dietary type
 */
@RestController
@RequestMapping
@Api(value = "Dietary API End points")
public class DietaryTypeController extends AbstractBaseController {

	@Autowired
	DietaryTypeService dietaryService;

	@ApiOperation(value = "Create Dietary Type")
	@PostMapping
	public ResponseEntity<DietaryType> createDietary(@Valid @RequestBody DietaryTypeView dietaryView) {
		return response(dietaryService.save(dietaryView), HttpStatus.OK);
	}
	@ApiOperation(value = "Fetch Dietary type by ID.")
	@GetMapping("/{id}")
	public ResponseEntity<DietaryType> fetchByid(@PathVariable("id") int id) {
		return response(dietaryService.findById(id),HttpStatus.OK);
	}
	@ApiOperation(value = "Fetch Dietary type by Value.")
	@GetMapping("/{value}")
	public ResponseEntity<DietaryType> fetchByValue(@PathVariable("value") String value) {
		return response(dietaryService.findByValue(value),HttpStatus.OK);
	}

	@ApiOperation(value = "Delete Dietary Type by  ID")
	@DeleteMapping("/id/{id}")
	public DietaryType deleteByid(@PathVariable("id") int id) {
		return dietaryService.findById(id);
	}
}
