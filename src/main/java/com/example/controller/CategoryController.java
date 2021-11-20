package com.example.controller;

import java.util.List;
import java.util.Objects;

import org.aspectj.weaver.patterns.TypeCategoryTypePattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Category;
import com.example.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@GetMapping("/")
	public ResponseEntity<List<Category>> listCategory() {
		List<Category> categoryList = categoryService.listCategory();
		return ResponseEntity.ok().body(categoryList);
	}

	@PostMapping("/create")
	public ResponseEntity<String> createCategory(@RequestBody Category category) {
		if (Objects.nonNull(categoryService.readCategory(category.getCategoryName()))) {
			return ResponseEntity.internalServerError().body("Created Successfully");
		}
		categoryService.createCategory(category);
		return ResponseEntity.ok().body("Created Successfully");
	}

	@PostMapping("/update/{categoryId}")
	public ResponseEntity<String> updateCategory(@PathVariable("categoryId") Integer categoryId,
			@RequestBody Category category) {
		if (!Objects.nonNull(categoryService.findById(categoryId))) {
			return ResponseEntity.internalServerError().body("Category not existed");
		}
		categoryService.updateCategory(categoryId, category);
		return ResponseEntity.ok().body("Category Updated Successfully");
	}

}
