package com.caterwings.productdemo.service;

import org.springframework.stereotype.Service;

import com.caterwings.productdemo.controller.DietaryTypeView;
import com.caterwings.productdemo.data.entity.DietaryType;

@Service
public interface DietaryTypeService {
	DietaryType findById(final int id);
	DietaryType save(DietaryTypeView dietaryView);
	DietaryType findByValue(String value);

}
