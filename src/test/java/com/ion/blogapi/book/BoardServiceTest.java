package com.ion.blogapi.book;

import com.ion.blogapi.board.domain.Board;
import com.ion.blogapi.board.service.BoardService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by  : woonkicho
 * Created Day : 2020/06/10
 * Modified by  :
 * Modified Day :
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class BoardServiceTest {
	@Autowired
    private BoardService boardService;

    @Test
    public void getBoards_test() {

    	List<Board> boards = boardService.getBoards();
    	System.out.println(boards);
	    Assert.assertNotNull(boards);
    }
}
