/**
 * 
 */
package com.caterwings.productdemo.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caterwings.productdemo.controller.ProductView;
import com.caterwings.productdemo.data.entity.DietaryType;
import com.caterwings.productdemo.data.entity.Product;
import com.caterwings.productdemo.data.entity.Vendor;
import com.caterwings.productdemo.data.repository.DieteryTypeRepository;
import com.caterwings.productdemo.data.repository.ProductRepository;
import com.caterwings.productdemo.exception.ProductServiceException;
import com.caterwings.productdemo.service.ProductService;
import com.caterwings.productdemo.service.VendorService;

/**
 * @author Sundeep D
 * 
 * This class implements the CRUD operations in the service layer
 *
 */
@Service("product-service")
public class ProductServiceImpl implements ProductService {

	@Autowired
	ProductRepository productRepository;

	@Autowired
	private VendorService vendorService;

	@Autowired
	DieteryTypeRepository dietaryRepository;

	private final Function<String, Vendor> VENDOR_FROM_UID = vendorUID -> vendorService.findByUID(vendorUID);
// saving a created product
	@Override
	public Product createProduct(ProductView productView) {
		return productRepository.save(productEntity(productView));
	}

	private Product productEntity(ProductView productView) {
		Product product = new Product();
		populateEntityFromView(productView, product);
		return product;
	}
// populating the product details
	private void populateEntityFromView(ProductView productView, Product product) {
		product.setTitle(productView.getTitle());
		product.setDescription(productView.getDescription());
		product.setPrice(productView.getPrice());
		product.setImage(productView.getImage());
		populateVendor(productView, product);
		populateDietaryTypes(productView, product);

	}
// populating the dietary types
	private void populateDietaryTypes(ProductView productView, Product product) {
		if (!Objects.isNull(productView.getDietaryTypes())) {
			product.setDiteryTypes(populateDietaryTypesFromValues(productView.getDietaryTypes()));
		}
	}
// populating the vendor details
	private void populateVendor(ProductView productView, final Product product) {
		if (!Objects.isNull(productView.getVendorUid())) {
			product.setVendor(VENDOR_FROM_UID.apply(productView.getVendorUid()));
		}
	}

	public Set<DietaryType> populateDietaryTypesFromValues(Set<String> dietaryTypesFromRequest) {
		Set<DietaryType> dietaryTypesEntitySet = new TreeSet<>();
		dietaryRepository.findAllByValue(dietaryTypesFromRequest).iterator()
				.forEachRemaining(dietaryTypesEntitySet::add);

		return dietaryTypesEntitySet;
	}

	@Override
	public Product fetch(final int id) {
		Optional<Product> optionProduct = productRepository.findById(id);
		if (optionProduct.isPresent()) {
			Product product = optionProduct.get();
			updateViews(product);
			return product;
		}

		throw new ProductServiceException(String.format("Product with id : %d doesnt exist.", id));
	}

	private void updateViews(Product product) {
		productRepository.updateViews(product.getId());
	}

	@Override
	public void delete(int productId) {
		productRepository.deleteById(productId);

	}

	@Override
	public Collection<Product> fetchAll() {
		Collection<Product> collection = new ArrayList<>();
		productRepository.findAll().iterator().forEachRemaining(collection::add);
		return collection;
	}

	@Override
	public List<Product> fetchByTitle(String name) {
		return productRepository.findByTitleContaining(name);
	}

	@Override
	public Product update(ProductView productView, final int id) {
		Optional<Product> productOptional = productRepository.findById(id);
		if (!productOptional.isPresent())
			return createProduct(productView);

		Product product = productOptional.get();
		populateEntityFromView(productView, product);
		return productRepository.save(product);
	}

	@Override
	public List<Product> fetchByDescription(final String description) {
		return productRepository.findByDescriptionContaining(description);
	}

}
