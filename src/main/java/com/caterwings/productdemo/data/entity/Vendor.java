/**
 * 
 */
package com.caterwings.productdemo.data.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Sundeep D
 *
 */
@Entity
@Table(name = "vendor")
public class Vendor {

	@Id
	private int id;

	@Column(name = "vendor_uid", unique = true)
	private String vendorUID;

	@Column(name = "vendor_name")
	private String name;

	public String getVendorUID() {
		return vendorUID;
	}

	public void setVendorUID(String vendorUID) {
		this.vendorUID = vendorUID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getId() {
		return id;
	}

}
