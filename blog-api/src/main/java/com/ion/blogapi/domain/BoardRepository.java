package com.ion.blogapi.domain;

import java.util.List;

public interface BoardRepository {
	List<Board> findAll();
	Board findById(Long id);
	Board save(Board board);
}
