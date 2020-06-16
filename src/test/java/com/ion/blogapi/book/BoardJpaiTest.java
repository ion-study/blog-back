//package com.ion.blogapi.book;
//
//import com.ion.blogapi.board.domain.Board;
//import com.ion.blogapi.board.repository.BoardRepository;
//import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
//import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
//import org.springframework.util.Assert;
//
///**
// * Created by  : woonkicho
// * Created Day : 2020/06/10
// * Modified by  :
// * Modified Day :
// */
//@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
//public class BoardJpaiTest {
//	@Autowired
//	private BoardRepository boardRepository;
//
//	@Test
//	public void saveTest(){
//		Board board = new Board();
//		board.setContent("content");
//		board.setWriter("writer");
//		boardRepository.save(board);
//		Assert.notNull(board.getId());
//	}
//
//	@Test
//	public void getTest(){
//		Board board = new Board();
//		board.setContent("content");
//		board.setWriter("writer");
//		boardRepository.save(board);
//
//		Board board2 = boardRepository.getOne(board.getId());
//		System.out.println(board2.toString());
//		Assert.notNull(board2,"get board2" + board2.toString());
//	}
//}
