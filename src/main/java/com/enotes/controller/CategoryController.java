package com.enotes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.enotes.Entity.Category;
import com.enotes.Service.CategoryService;

@RestController
@RequestMapping(CategoryController.basePath)
public class CategoryController {
	
	public static final String basePath= "/api/v1/category";  //WE ARE TAKING IT AS STATIC AND FINAL BECAUSE WITHOUT CREATING
	
	@Autowired                                                    // AN OBJECT OF THE CONTROLLER, WE WILL BE ABLE TO ACCESS THE 
	private CategoryService categoryservice;													  //BASEPATH, AND FINAL BECAUSE ANNOTATION REQUIRED CONSTANTS
	
	@PostMapping("/save-category")
	public ResponseEntity<?> saveCategory(@RequestBody Category category)
	{
		Boolean saveCategory = categoryservice.saveCategory(category);
		if(saveCategory) return new ResponseEntity<>("saved", HttpStatus.CREATED);
		
		else
		return new ResponseEntity<>("Unable to Save", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	
	@GetMapping("/get-all")
	public ResponseEntity<?> getAllCategory()
	{
		List<Category> categories = categoryservice.getAllCategory();
		if(CollectionUtils.isEmpty(categories))
		{
			return ResponseEntity.noContent().build();
		}
		else
		{
			return new ResponseEntity<>(categories, HttpStatus.OK);
		}
	}

}
