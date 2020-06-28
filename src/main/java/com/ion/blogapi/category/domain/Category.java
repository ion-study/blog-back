package com.ion.blogapi.category.domain;

import com.ion.blogapi.common.domain.CommonField;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@DynamicUpdate
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