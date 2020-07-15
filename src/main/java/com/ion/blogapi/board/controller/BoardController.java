package com.ion.blogapi.board.controller;

import com.ion.blogapi.board.domain.Board;
import com.ion.blogapi.board.dto.BoardReqDto;
import com.ion.blogapi.board.service.BoardService;
import com.ion.blogapi.common.dto.ResDtoCommon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class BoardController {

	@Autowired
	private BoardService boardService;

	@GetMapping("/boards")
	public List<Board> list() {
		return boardService.getBoards();
	}

	@GetMapping("/boards/{id}")
	public Board detail(@PathVariable("id") Long id) {
		return boardService.getBoard(id);
	}

	@PostMapping("/boards")
	public ResDtoCommon create(@RequestBody BoardReqDto resource) {
		return boardService.addBoard(resource);
	}

	@PatchMapping("/boards")
	public Board update(@RequestBody Board resource) {
		return boardService.updateBoard(resource);
	}

	@DeleteMapping("/boards/{id}")
	public @ResponseBody HashMap<String, String> delete(@PathVariable("id") Long id) {
		boardService.deleteBoard(id);

		HashMap<String, String> statusMap = new HashMap<>();
		statusMap.put("status", "ok");
		return statusMap;
	}
}
