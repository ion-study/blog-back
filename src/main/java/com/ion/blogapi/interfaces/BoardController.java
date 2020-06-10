package com.ion.blogapi.interfaces;

import com.ion.blogapi.application.BoardService;
import com.ion.blogapi.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;
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

}
