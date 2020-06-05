package com.ion.blogapi.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BoardRepositoryImpl implements BoardRepository {

	private List<Board> boards = new ArrayList<>();

	public BoardRepositoryImpl() {
		boards.add(new Board(1L, "유진", "테스트내용입니다!!"));
		boards.add(new Board(2L, "승세", "테스트내용입니다!!22"));
	}

	@Override
	public List<Board> findAll() {
		return this.boards;
	}

	@Override
	public Board findById(Long id) {
		// id에 해당하는 board를 get
		return boards.stream()
				.filter(r -> r.getId().equals(id))
				.findFirst()
				.orElse(null);
	}

	@Override
	public Board save(Board board) {
		board.setId(Long.valueOf(boards.size()+1));
		boards.add(board);
		return board;
	}
}
