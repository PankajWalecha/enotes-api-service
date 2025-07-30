package com.enotes.Service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import com.enotes.Entity.Category;
import com.enotes.Repository.CategoryRepository;
import com.enotes.Service.CategoryService;
import com.enotes.dto.CategoryDTO;
import com.enotes.dto.CategoryResponse;

@Service
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryRepository categoryRepo;
	
	@Autowired
	private ModelMapper mapper;
	
	@Override
	public Boolean saveCategory(CategoryDTO categoryDto) { // till service , we will use DTO, and here we will map the dto to entity. as our repo will use entity.
		
		//below is the boiler plate code, before using the model mapper, we have to manually set everything
		
//		Category category = new Category();
//		category.setName(categoryDto.getName());
//		category.setDescription(categoryDto.getDescription());
//		category.setIsActive(categoryDto.getIsActive());
		
		
		Category category = mapper.map(categoryDto, Category.class);  //source -> destination
		category.setCreatedBy(1);
		category.setCreatedOn(new Date());
		category.setIsDeleted(false);
		Category savedCategory = categoryRepo.save(category);
		if(ObjectUtils.isEmpty(savedCategory))
		{
			return false;
		}
		return true;
	}

	@Override
	public List<CategoryDTO> getAllCategory() {
		
		List<Category> categories = categoryRepo.findAll();
		 List<CategoryDTO> categoryDtoList = categories.stream().map(cat->mapper.map(cat, CategoryDTO.class)).toList();
		return categoryDtoList;
	}

	@Override
	public List<CategoryResponse> getActiveCategory() {
		
		List<Category> categories = categoryRepo.findByIsActiveTrue();
		List<CategoryResponse> isActiveCategories = categories.stream().map(cat->mapper.map(cat, CategoryResponse.class)).toList();
		return isActiveCategories;
	}
	
	

}
