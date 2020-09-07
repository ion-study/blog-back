package com.ion.blogapi.category.domain;

import com.ion.blogapi.board.dto.BoardResDto;
import com.ion.blogapi.category.dto.CategoryResDto;
import com.ion.blogapi.common.domain.CommonField;
import com.ion.blogapi.config.ModelMapperUtils;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@DynamicUpdate
@Builder
public class Category extends CommonField {

	@Id
	@GeneratedValue
	private Long catId;

	@Column(nullable = false)
	private String catName;

	private int orderNum;
	private int depth;

	@Column(nullable = false)
	private Long blogId;

 	private Long parentCatId;
}