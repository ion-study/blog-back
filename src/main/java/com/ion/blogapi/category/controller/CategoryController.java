package com.ion.blogapi.category.controller;

import com.ion.blogapi.category.domain.Category;
import com.ion.blogapi.category.dto.CategoryResDto;
import com.ion.blogapi.category.service.CategoryService;
import com.ion.blogapi.common.dto.CommonResDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	@GetMapping("/categories")
	public List<Category> list(@RequestParam("blogId") Long blogId, @RequestParam(required = false, value = "parentCatId") Long parentCatId) {
		if(parentCatId == null) return categoryService.getCategories(blogId);
		else return categoryService.getCategories(blogId, parentCatId);
	}

	@GetMapping("/categories/{id}")
	public CategoryResDto detail(@PathVariable("id") Long id) {
		return categoryService.getCategory(id);
	}

	@PostMapping("/categories")
	public CategoryResDto create(@RequestBody Category category) {
		System.out.println(category.toString());
		return categoryService.setCategory(category);
	}

	@PatchMapping("/categories")
	public CategoryResDto update(@RequestBody Category category) {
		System.out.println(category.toString());
		return categoryService.setCategory(category);
	}

	@DeleteMapping("/categories/{id}")
	public CommonResDto delete(@PathVariable("id") Long id, @RequestParam("blogId") Long blogId) {
		return categoryService.deleteCategory(blogId, id);
	}


}