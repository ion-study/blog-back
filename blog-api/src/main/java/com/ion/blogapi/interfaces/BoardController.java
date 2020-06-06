package com.ion.blogapi.interfaces;

import com.ion.blogapi.application.BoardService;
import com.ion.blogapi.domain.Board;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
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

	@PostMapping("/boards")
	public ResponseEntity<?> create(@RequestBody Board resource) throws URISyntaxException {

		Board board = Board.builder().writer(resource.getWriter()).content(resource.getContent()).build();
		boardService.addBoard(board);

		URI location = new URI("/boards/" + board.getId());
		return ResponseEntity.created(location).body(board.toString());
	}

}
