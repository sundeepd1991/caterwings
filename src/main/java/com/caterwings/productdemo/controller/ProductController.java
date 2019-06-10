/**
 * 
 */
package com.caterwings.productdemo.controller;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.caterwings.productdemo.data.entity.Product;
import com.caterwings.productdemo.service.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

/**
 * @author Sundeep D
 * 
 * This class performs all the CRUD operations for Product
 */
@RestController
@RequestMapping("/products")
@Api(value="Product API End points")
public class ProductController extends AbstractBaseController {

	@Autowired
	@Qualifier("product-service")
	ProductService productService;

	@ApiOperation(value = "Create product")
	@PostMapping
	public ResponseEntity<Product> createProducts(@Valid @RequestBody ProductView productView) {
		return response(productService.createProduct(productView), HttpStatus.CREATED);
	}

	@ApiOperation(value = "Update a given product")
	@PutMapping("/{id}")
	public ResponseEntity<Product> update(@Valid @RequestBody ProductView productView, @PathVariable("id") int id) {
		return response(productService.update(productView, id), HttpStatus.OK);
	}

	@ApiOperation(value = "Fetch all existing products")
	@GetMapping
	public ResponseEntity<Collection<Product>> fetchAllProducts() {
		return response(productService.fetchAll(), HttpStatus.OK);
	}

	@ApiOperation(value = "Search for products by Title")
	@GetMapping("/name/{name}")
	public ResponseEntity<List<Product>> fetchByName(@PathVariable("name") String name) {
		return response(productService.fetchByTitle(name), HttpStatus.OK);
	}

	@ApiOperation(value = "Search for products by description")
	@GetMapping("/description/{description}")
	public ResponseEntity<List<Product>> fetchByDescription(@PathVariable("description") String description) {
		return response(productService.fetchByDescription(description), HttpStatus.OK);
	}

	@ApiOperation(value = "Search for product by unique Id", response = Product.class)
	@GetMapping("/{id}")
	public ResponseEntity<Product> fetchByid(@PathVariable("id") int id) {
		return response(productService.fetch(id), HttpStatus.OK);
	}

	@ApiOperation(value = "Remove product by unique Id", response = Void.class)
	@DeleteMapping("/{id}")
	public void deleteByid(@PathVariable("id") int id) {
		productService.delete(id);
	}

}
