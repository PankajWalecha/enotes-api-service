package com.enotes.Service;

import java.util.List;
import com.enotes.Entity.Category;

public interface CategoryService {
	
	public Boolean saveCategory(Category category);
	
	public List<Category> getAllCategory();
}
