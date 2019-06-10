/**
 * 
 */
package com.caterwings.productdemo.controller;

import javax.validation.constraints.NotNull;

import com.caterwings.productdemo.data.entity.DietaryType;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * @author Sundeep D
 *
 */
@JsonRootName("dietaryType")
public class DietaryTypeView {
	@NotNull
	private int id;
	@NotNull
	private String value;

	public DietaryTypeView() {
		super();
	}

	public int getId() {
		return id;
	}

	public String getValue() {
		return value;
	}

	public DietaryTypeView(DietaryType dietary) {
		super();
		this.id = dietary.getId();
		this.value = dietary.getValue();
	}

}
