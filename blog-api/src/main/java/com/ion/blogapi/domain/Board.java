package com.ion.blogapi.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Board {
	private Long id;
	private String writer;
	private String content;

	public Board(String writer, String content) {
		this.writer = writer;
		this.content = content;
	}
}
