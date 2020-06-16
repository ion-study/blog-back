package com.ion.blogapi.board.service;

import com.ion.blogapi.board.domain.Board;
import com.ion.blogapi.board.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {
	@Autowired
	BoardRepository boardRepository;

	public List<Board> getBoards() {
		return boardRepository.findAll();
	}

	public Board getBoard(Long id) {
		return boardRepository.findById(id).orElse(null);
	}

	public Board addBoard(Board board) {
		return boardRepository.save(board);
	}

	@Transactional
	public Board updateBoard(Long id, String subject, String contents) {
		Board board = boardRepository.findById(id).orElse(null);
		board.updateInformation(subject, contents);
		return board;
	}

	@Transactional
	public void deleteBoard(Long id) {
		boardRepository.deleteById(id);
	}
}
