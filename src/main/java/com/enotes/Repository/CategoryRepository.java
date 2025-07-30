package com.enotes.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.enotes.Entity.Category;
import com.enotes.dto.CategoryResponse;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>{

	public List<Category> findByIsActiveTrue();

}
