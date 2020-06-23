package com.ion.blogapi.category.repository;

import com.ion.blogapi.category.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category, Long> {
	List<Category> findByBlogId(Long id);
}
