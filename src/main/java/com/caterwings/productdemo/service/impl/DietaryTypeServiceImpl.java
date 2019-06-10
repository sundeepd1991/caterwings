package com.caterwings.productdemo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.caterwings.productdemo.controller.DietaryTypeView;
import com.caterwings.productdemo.data.entity.DietaryType;
import com.caterwings.productdemo.data.repository.DieteryTypeRepository;
import com.caterwings.productdemo.service.DietaryTypeService;

@Service
public class DietaryTypeServiceImpl implements DietaryTypeService {

	@Autowired
	private DieteryTypeRepository dietaryRepository;

	@Override
	public DietaryType findById(int id) {
		return dietaryRepository.findById(id).get();
	}
	@Override
	public DietaryType findByValue(String value) {
		return dietaryRepository.findByValue(value);
	}


	@Override
	public DietaryType save(DietaryTypeView dietaryView) {
		return dietaryRepository.save(createDietaryType(dietaryView));
	}
	

	private DietaryType createDietaryType(DietaryTypeView dietaryView) {
		DietaryType dietaryType = new DietaryType();
		dietaryType.setValue(dietaryView.getValue());
		return dietaryType;
	}


	
}
