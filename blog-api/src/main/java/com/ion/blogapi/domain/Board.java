package com.ion.blogapi.domain;

import lombok.*;

@Getter
@ToString
@NoArgsConstructor
public class Board {
	private static Long idCnt;
	private Long id;
	private String writer;
	private String content;

	static {
		idCnt = 0L;
	}

	@Builder
	public Board(String writer,String content) {
		this.id = ++idCnt;
		this.writer = writer;
		this.content = content;
	}
}
