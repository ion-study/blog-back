package com.ion.blogapi.board.service;

import com.ion.blogapi.board.domain.Board;
import com.ion.blogapi.board.dto.BoardReqDto;
import com.ion.blogapi.board.dto.BoardResDto;
import com.ion.blogapi.board.repository.BoardRepository;
import com.ion.blogapi.category.domain.Category;
import com.ion.blogapi.category.repository.CategoryRepository;
import com.ion.blogapi.common.dto.CommonResDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BoardService {
	@Autowired
	BoardRepository boardRepository;
	@Autowired
	CategoryRepository categoryRepository;

	public List<BoardResDto> getBoards() {
		List<Board> boards = boardRepository.findAll();

		// Entity to Dto
		List<BoardResDto> boardResDtoList = BoardResDto.of(boards);

		return boardResDtoList;
	}

	public BoardResDto getBoard(Long id) {
		Board board = boardRepository.findById(id).orElse(null);

		// Entity to Dto
		BoardResDto boardResDto = BoardResDto.of(board);

		// return 정보 셋팅
		//CommonResDto res;

		/*
		if(board != null) { // 성공
			res = CommonResDto.builder()
						.returnCode(200)
						.returnMessage("success")
						.build();
			boardResDto.setRtnInfo(res);

		}else {             // 실패
			res = CommonResDto.builder()
					.returnCode(500)
					.returnMessage("fail")
					.build();

		}
		boardResDto.setRtnInfo(res);
		 */

		return boardResDto;
	}

	public CommonResDto addBoard(BoardReqDto boardReqDto) {
		// 1. Repository에 인자로 넘겨주기 위한 DTO to Entity
		Board board = Board.of(boardReqDto);

		// 2. DB에 저장
		board = boardRepository.save(board);

		// 제대로 가져왔는지 확인 로직

		// 3. 저장한 결과를 DTO로 반환하기 위한 Entity to DTO
		return CommonResDto.builder().returnCode(200).returnMessage("success").build();
	}

	@Transactional
	public CommonResDto updateBoard(BoardReqDto boardReqDto){

		Board beforeBoard = boardRepository.findById(boardReqDto.getBoardId()).orElse(null);
		System.out.println(beforeBoard);

		// board 존재하는지 판단
		if(beforeBoard == null) {
			System.out.println("Board 가 존재하지 않습니다. (board id:" + boardReqDto.getBoardId() + ")");
			return null;
		}

		// 객체 셋팅
		beforeBoard.setSubject(boardReqDto.getSubject());
		beforeBoard.setContents(boardReqDto.getContents());
		Category category = categoryRepository.findById(boardReqDto.getCatId()).orElse(null);
		beforeBoard.setCategory(category);

		System.out.println(beforeBoard);

		// DB 저장
		boardRepository.save(beforeBoard);

		// Entity To Dto
		return CommonResDto.builder().returnCode(200).returnMessage("success").build();
	}


	public CommonResDto deleteBoard(Long id) {
		boardRepository.deleteById(id);

		// 삭제 판단 로직
		// ...

		return CommonResDto.builder().returnCode(200).returnMessage("success").build();
	}
}
