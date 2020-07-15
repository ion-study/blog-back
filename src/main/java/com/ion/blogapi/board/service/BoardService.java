package com.ion.blogapi.board.service;

import com.ion.blogapi.board.domain.Board;
import com.ion.blogapi.board.dto.BoardReqDto;
import com.ion.blogapi.board.dto.BoardResDto;
import com.ion.blogapi.board.repository.BoardRepository;
import com.ion.blogapi.common.dto.ResDtoCommon;
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

	public ResDtoCommon addBoard(BoardReqDto boardReqDto) {
		// 1. Repository에 인자로 넘겨주기 위한 DTO to Entity
		Board board = Board.of(boardReqDto);

		// 2. DB에 저장
		board = boardRepository.save(board);

		// 제대로 가져왔는지 확인 로직

		// 3. 저장한 결과를 DTO로 반환하기 위한 Entity to DTO
		return new ResDtoCommon(200, "success");
	}

	@Transactional
	public Board updateBoard(Board board){
		// board 존재하는지 판단
		board = getBoard(board.getBoardId());
		if(board == null) {
			System.out.println("Board 가 존재하지 않습니다. (board id:" + board.getBoardId() + ")");
			return null;
		}
		return boardRepository.save(board);
	}

	public void deleteBoard(Long id) {
		boardRepository.deleteById(id);
	}
}
