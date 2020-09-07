package com.ion.blogapi.category.service;

import com.ion.blogapi.board.dto.BoardResDto;
import com.ion.blogapi.category.domain.Category;
import com.ion.blogapi.category.dto.CategoryResDto;
import com.ion.blogapi.category.repository.CategoryRepository;
import com.ion.blogapi.common.dto.CommonResDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
	@Autowired
	CategoryRepository categoryRepository;

	public List<Category> getCategories(Long blogId, Long parentCatId) {
		List<Category> categories;
		if(parentCatId != null) {
			categories = categoryRepository.findByBlogIdAndParentCatId(blogId, parentCatId);
		}else {
			categories = categoryRepository.findByBlogId(blogId);
		}
		return categories;
	}

	public CategoryResDto getCategory(Long id) {

		Category category = categoryRepository.findById(id).orElse(null);
		CategoryResDto res = new CategoryResDto();

		if(category == null) {
			res.setResLog(CommonResDto.setNotFound());
		}else {
			res = CategoryResDto.of(category);
		}

		return res;
	}

	public CategoryResDto setCategory(Category category) {
		Category newCategory = categoryRepository.save(category);
		// 확인로직
		// ...

		return CategoryResDto.of(newCategory);
	}

	public CommonResDto deleteCategory(Long blogId, Long id) {
		// 자식 삭제
		List<Category> categories = getCategories(blogId, id);

		System.out.println(categories);
		categoryRepository.deleteAll(categories);
		// 부모 삭제
		categoryRepository.deleteById(id);

		// 확인 로직
		// ...
		return CommonResDto.setSuccess();
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
