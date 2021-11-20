package com.example.service.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.Category;
import com.example.repository.CategoryRepository;
import com.example.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categoryRespository;

	@Override
	public void createCategory(Category category) {
		categoryRespository.save(category);
	}

	@Override
	public List<Category> listCategory() {
		return categoryRespository.findAll();
	}

	@Override
	public Category readCategory(String categoryName) {
		return categoryRespository.findByCategoryName(categoryName);
	}

	@Override
	public Category findById(int id) {
		return categoryRespository.findById(id).orElse(null);
	}

	@Override
	public void updateCategory(Integer categoryId, Category category) {
		Category updateCategory = new Category();
		updateCategory.setId(category.getId());
		updateCategory.setCategoryName(category.getCategoryName());
		updateCategory.setDescription(category.getDescription());
		updateCategory.setImageUrl(category.getImageUrl());
		categoryRespository.save(updateCategory);
	}

}
