package com.ion.blogapi.category.service;

import com.ion.blogapi.category.domain.Category;
import com.ion.blogapi.category.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;

	public List<Category> getCategories(Long blogId) {
		return categoryRepository.findByBlogId(blogId);
	}

	public List<Category> getCategories(Long blogId, Long parentCatId) {
		return categoryRepository.findByBlogIdAndParentCatId(blogId, parentCatId);
	}

	public Category getCategory(Long id) {
		return categoryRepository.findById(id).orElse(null);
	}

	public Category setCategory(Category category) {
		return categoryRepository.save(category);
	}

	public void deleteCategory(Long blogId, Long id) {
		// 자식 삭제
		List<Category> children = getCategories(blogId, id);
		System.out.println(children);
		categoryRepository.deleteAll(children);
		// 부모 삭제
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
