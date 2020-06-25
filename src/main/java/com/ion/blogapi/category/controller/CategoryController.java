package com.ion.blogapi.category.controller;

import com.ion.blogapi.category.domain.Category;
import com.ion.blogapi.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class CategoryController {
	@Autowired
	private CategoryService categoryService;

	@PostMapping("/categories")
	public Category create(@RequestBody Category category) {
		System.out.println(category.toString());
		return categoryService.addCategory(category);
	}

//	@GetMapping("/categories")
//	public  list(@RequestParam("blogId") Long blogId) {
//
//	}

	@DeleteMapping("/categories/{id}")
	public @ResponseBody HashMap<String, String> delete(@PathVariable("id") Long id) {
		categoryService.deleteCategory(id);

		HashMap<String, String> statusMap = new HashMap<>();
		statusMap.put("status", "ok");
		return statusMap;
	}



}