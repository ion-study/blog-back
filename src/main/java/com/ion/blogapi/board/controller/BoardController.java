package com.ion.blogapi.board.controller;

import com.ion.blogapi.board.dto.BoardReqDto;
import com.ion.blogapi.board.dto.BoardResDto;
import com.ion.blogapi.board.service.BoardService;
import com.ion.blogapi.common.dto.CommonResDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoardController {

	@Autowired
	private BoardService boardService;

	@GetMapping("/boards")
	public List<BoardResDto> list(@RequestParam(required = false, value = "catId") Long catId) {
		if(catId == null) return boardService.getBoards();
		return boardService.getBoardsByCatId(catId);
	}

	@GetMapping("/boards/{id}")
	public BoardResDto detail(@PathVariable("id") Long id) {
		return boardService.getBoard(id);
	}

	@PostMapping("/boards")
	public CommonResDto create(@RequestBody BoardReqDto resource) {
		return boardService.addBoard(resource);
	}

	@PatchMapping("/boards")
	public CommonResDto update(@RequestBody BoardReqDto resource) {
		//test
		System.out.println("test1:");
		System.out.println(resource);
		return boardService.updateBoard(resource);
	}

	@DeleteMapping("/boards/{id}")
	public CommonResDto delete(@PathVariable("id") Long id) {
		return boardService.deleteBoard(id);
	}
}
