/**
 * 
 */
package com.caterwings.productdemo.service;

import java.util.Collection;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Service;

import com.caterwings.productdemo.controller.ProductView;
import com.caterwings.productdemo.data.entity.Product;

/**
 * @author Sundeep D
 *
 */
@Service
public interface ProductService {

	public Product createProduct(ProductView product);

	public Product fetch(final int id);

	public void delete(final int productId);

	public Collection<Product> fetchAll();

	public List<Product> fetchByTitle(String name);
	
	public List<Product> fetchByDescription(String description);

	public Product update(@Valid ProductView productView, final int id); 
}
