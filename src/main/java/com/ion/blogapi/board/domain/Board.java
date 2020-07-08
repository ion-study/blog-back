package com.ion.blogapi.board.domain;

import com.ion.blogapi.category.domain.Category;
import com.ion.blogapi.common.domain.CommonField;
import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@DynamicUpdate
public class Board extends CommonField {

	@Id
	@GeneratedValue
	private Long boardId;

	@ManyToOne
	@JoinColumn(name = "catId")
	private Category category;

	@Column(nullable = false, updatable = false)
	private String userId;

	private String subject;

	@Column(columnDefinition = "TEXT")
	private String contents;

}
