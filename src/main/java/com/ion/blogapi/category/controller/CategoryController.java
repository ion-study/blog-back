package com.ion.blogapi.category.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ion.blogapi.category.domain.Category;
import com.ion.blogapi.category.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class CategoryController {
	@Autowired
	private CategoryService categoryService;
	private HashMap<String, Object> category;

	@GetMapping("/categories")
	public HashMap<String, Object> list(@RequestParam("blogId") Long blogId) {
		List<Category> list = categoryService.getCategories(blogId);
		System.out.println(list);

		HashMap<String, Object> map = new HashMap<>();
		map.put("blogId", list.get(0).getBlogId());
		map.put("list", list);

		category = new HashMap<>();
		category.put("category", map);

		return category;
	}

	@PostMapping("/categories")
	public void setting(@RequestBody HashMap<String, Object> data) {
		category = (HashMap)data.get("category");
		List<Category> list = (List) category.get("list");

		ObjectMapper mapper = new ObjectMapper();
		List<Category> catList =  mapper.convertValue(list, new TypeReference<List<Category>>() {});

		Long blogId = ((Number) category.get("blogId")).longValue();

		categoryService.settingCategory(blogId, catList);
	}

}
