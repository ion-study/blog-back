package com.ion.blogapi.domain;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class BoardRepositoryImpl implements BoardRepository {

	private List<Board> boards = new ArrayList<>();

	public BoardRepositoryImpl() {
		boards.add(Board.builder().writer("유진").content("유진 테스트").build());
		boards.add(Board.builder().writer("승세").content("승세 테스트").build());
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
		boards.add(board);
		return board;
	}
}
