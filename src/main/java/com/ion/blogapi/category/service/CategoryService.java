package com.ion.blogapi.category.service;

import com.ion.blogapi.category.domain.Category;
import com.ion.blogapi.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;

	public List<Category> getCategories(Long blogId) {
		return categoryRepository.findByBlogId(blogId);
	}

	public Category getCategory(Long id) {
		return categoryRepository.findById(id).orElse(null);
	}

	public Category addCategory(Category category) {
		return categoryRepository.save(category);
	}

	@Transactional
	public void deleteCategory(Long id) {
		categoryRepository.deleteById(id);
	}

	/*
	@Transactional
	public void settingCategory(Long id, List<Category> list) {
		list.stream().forEach(category -> {
			//process
		});
		List<Category>  listCate = list.stream().map(category -> {
			//data 가공
			category.setBlogId(1l);
			return category;
		}).collect(Collectors.toList());



		for(Category category : list) {
			category.setBlogId(id);
			if(category.isRemoved()) { // 카테고리 삭제
				deleteCategory(category.getCatId());
			}else {                    // 카테고리 생성/수정
				addCategory(category);
			}
		}

	}
	*/
}
