package com.ion.blogapi.board.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ion.blogapi.board.domain.Board;
import com.ion.blogapi.common.dto.CommonResDto;
import com.ion.blogapi.config.ModelMapperUtils;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
public class BoardResDto {

	private Long boardId;
	private Long catId;
	private String userId;
	private String subject;
	private String contents;

	// common field
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Timestamp createdDate;
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
	private Timestamp modifiedDate;

	//CommonResDto rtnInfo;

	public static BoardResDto of(Board board) {
		// 이름이 같은 필드명끼리는 ModelMapper를 통해 매핑
		BoardResDto boardResDto = ModelMapperUtils.getModelMapper().map(board, BoardResDto.class);

		// 이름이 다른 필드는 직접 set을 통해 매핑
		// catId null인 경우 생략 (초기 테스트데이터 통과 시켜야 함..)
		if(board.getCategory() != null) {
			boardResDto.setCatId(board.getCategory().getCatId());
		}

		//test
		System.out.println("board:");
		System.out.println(board);
		System.out.println("boardResDto:");
		System.out.println(boardResDto);

		return boardResDto;
	}

	public static List<BoardResDto> of(List<Board> boards) {
		List<BoardResDto> dtoList = boards.stream()
										  .map(board -> BoardResDto.of(board))
										  .collect(Collectors.toList());

		return dtoList;
	}
}