package com.enotes.Service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.enotes.Entity.Category;
import com.enotes.Repository.CategoryRepository;
import com.enotes.Service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Override
	public Boolean saveCategory(Category category) {
		category.setIsDeleted(false);
		category.setCreatedBy(1);
		category.setCreatedOn(new Date());
		Category saveResult = categoryRepo.save(category);
		
		if(ObjectUtils.isEmpty(saveResult)) return false;
		
		return true;
	}

	@Override
	public List<Category> getAllCategory() {
		
		List<Category> categories = categoryRepo.findAll();
		return categories;
	}

}
