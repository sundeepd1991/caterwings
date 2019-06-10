/**
 * 
 */
package com.caterwings.productdemo.controller;

import java.util.Set;
import java.util.TreeSet;

import javax.validation.constraints.NotNull;

import com.caterwings.productdemo.data.entity.Product;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * @author Sundeep D
 *
 */
@JsonRootName("product")
public class ProductView {

	@NotNull(message = "Product title is needed.")
	private String title;
	private String description;
	private int id;
	private String vendorUid;
	private float price;
	private byte[] image;
	private Set<String> dietaryTypes = new TreeSet<>();
	
	public ProductView() {
		super();
	}

	public ProductView(@NotNull(message = "Product title is needed.") String title, String description,
			String vendorUid) {
		super();
		this.title = title;
		this.description = description;
		this.vendorUid = vendorUid;
	}

	public ProductView(@NotNull(message = "Product title is needed.") String title, String vendorUid) {
		this(title, vendorUid, null);
	}

	public ProductView(Product product) {
		this.title = product.getTitle();
		this.description = product.getDescription();
		this.id = product.getId();
		this.vendorUid = product.getVendor().getVendorUID();
	}

	public Set<String> getDietaryTypes() {
		return dietaryTypes;
	}

	public byte[] getImage() {
		return image;
	}

	public float getPrice() {
		return price;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "ProductView [title=" + title + ", description=" + description + ", id=" + id + ", vendorUid="
				+ vendorUid + "]";
	}

	public int getId() {
		return id;
	}

	public String getVendorUid() {
		return vendorUid;
	}

}
