package com.ion.blogapi.category.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@DynamicUpdate
public class Category {

	@Id
	@GeneratedValue
	private Long catId;

	@Column(nullable = false)
	private String catName;

	private Long parentCatId;
	private int orderNum;

	@Column(nullable = false)
	private Long blogId;

	@Transient
	private boolean removed;
}