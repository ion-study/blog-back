package com.ion.blogapi.board.domain;

import com.ion.blogapi.board.dto.BoardReqDto;
import com.ion.blogapi.category.domain.Category;
import com.ion.blogapi.common.domain.CommonField;
import com.ion.blogapi.config.ModelMapperUtils;
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

	public static Board of(BoardReqDto boardReqDto) {
		// 이름이 같은 필드명끼리는 ModelMapper를 통해 매핑
		Board board = ModelMapperUtils.getModelMapper().map(boardReqDto, Board.class);

		// 이름이 다른 필드는 직접 set을 통해 매핑
		Category category = new Category();
		category.setCatId(boardReqDto.getCatId());
		board.setCategory(category);

		//test
		System.out.println(boardReqDto);
		System.out.println(board.getCategory());

		return board;
	}

}
