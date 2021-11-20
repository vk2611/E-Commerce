package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.Category;

@Service
public interface CategoryService {

	public void createCategory(Category category);

	public List<Category> listCategory();

	public Category readCategory(String categoryName);

	public Category findById(int id);

	public void updateCategory(Integer categoryId, Category category);

}
