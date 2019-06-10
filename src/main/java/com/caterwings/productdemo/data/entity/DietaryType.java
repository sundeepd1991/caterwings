/**
 * 
 */
package com.caterwings.productdemo.data.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Sundeep D
 *
 */
@Entity
@Table(name = "dietary_type")
public class DietaryType implements Comparable<DietaryType>, Serializable {

	private static final long serialVersionUID = -7752953849199364791L;

	@Id
	private int id;

	@Column(name = "value", unique = true)
	private String value;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getId() {
		return id;
	}

	@Override
	public int compareTo(DietaryType dietaryType) {
		if (null != value && null != dietaryType.getValue())
			return 0;
		return this.value.compareTo(dietaryType.getValue());

	}

}
