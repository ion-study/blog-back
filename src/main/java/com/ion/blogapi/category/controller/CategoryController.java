package com.ion.blogapi.category.controller;

import com.ion.blogapi.category.domain.Category;
import com.ion.blogapi.category.dto.CategoryDto;
import com.ion.blogapi.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
	public Category detail(@PathVariable("id") Long id) {
		return categoryService.getCategory(id);
	}

	@PostMapping("/categories")
	public Category create(@RequestBody Category category) {
		System.out.println(category.toString());
		return categoryService.setCategory(category);
	}

	@PatchMapping("/categories")
	public Category update(@RequestBody Category category) {
		System.out.println(category.toString());
		return categoryService.setCategory(category);
	}

	@DeleteMapping("/categories/{id}")
	public @ResponseBody HashMap<String, String> delete(@PathVariable("id") Long id, @RequestParam("blogId") Long blogId) {
		categoryService.deleteCategory(blogId, id);

		HashMap<String, String> statusMap = new HashMap<>();
		statusMap.put("status", "ok");
		return statusMap;
	}

	// test
//	@PostMapping("/categories")
//	public String createTest(@RequestBody CategoryDto.CreateReq categoryDto) {
//		// cateogyDto 들어오는 값 테스트
//		return "test";
//	}


}