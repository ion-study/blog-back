package com.ion.blogapi.application;

import com.ion.blogapi.domain.Board;
import com.ion.blogapi.domain.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {
	@Autowired
	BoardRepository boardRepository;

	public List<Board> getBoards() {
		return boardRepository.findAll();
	}

	public Board addBoard(Board board) {
		return boardRepository.save(board);
	}
}
