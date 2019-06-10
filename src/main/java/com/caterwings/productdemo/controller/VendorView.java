/**
 * 
 */
package com.caterwings.productdemo.controller;

import javax.validation.constraints.NotNull;

import com.caterwings.productdemo.data.entity.Vendor;
import com.fasterxml.jackson.annotation.JsonRootName;

/**
 * @author Sundeep D
 *
 */
@JsonRootName("vendor")
public class VendorView {
	@NotNull
	private String name;
	@NotNull
	private String uid;

	public VendorView() {
		super();
	}

	public String getName() {
		return name;
	}

	public String getUid() {
		return uid;
	}

	public VendorView(Vendor vendor) {
		super();
		this.name = vendor.getName();
		this.uid = vendor.getVendorUID();
	}

}
