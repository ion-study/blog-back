package com.ion.blogapi.board.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardReqDto {
	private Long boardId;
	private Long catId;
	private String userId;
	private String subject;
	private String contents;
}