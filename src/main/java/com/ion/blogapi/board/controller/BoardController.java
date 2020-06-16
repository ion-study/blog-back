package com.ion.blogapi.board.controller;

import com.ion.blogapi.board.service.BoardService;
import com.ion.blogapi.board.domain.Board;
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
	public Board create(@RequestBody Board resource) {
		//Board board = Board.builder().writer(resource.getWriter()).content(resource.getContent()).build();
		return boardService.addBoard(resource);
	}

	@PatchMapping("/boards/{id}")
	public Board update(@PathVariable("id") Long id, @RequestBody Board resource) {
		String subject = resource.getSubject();
		String contents = resource.getContents();
		return boardService.updateBoard(id, subject, contents);
	}

	@DeleteMapping("/boards/{id}")
	public @ResponseBody HashMap<String, String> delete(@PathVariable("id") Long id) {
		boardService.deleteBoard(id);

		HashMap<String, String> statusMap = new HashMap<>();
		statusMap.put("status", "ok");
		return statusMap;
	}
}