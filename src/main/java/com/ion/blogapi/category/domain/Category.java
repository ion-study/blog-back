package com.ion.blogapi.category.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import com.ion.blogapi.common.domain.CommonField;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.List;

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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "parentCatId", referencedColumnName = "catId")
	private Category parentCatId;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "parentCatId", cascade = CascadeType.ALL)
	private List<Category> children;

}