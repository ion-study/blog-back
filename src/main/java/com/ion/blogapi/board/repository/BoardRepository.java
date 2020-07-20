package com.ion.blogapi.board.repository;

import com.ion.blogapi.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BoardRepository extends JpaRepository<Board, Long> {
	@Query("select b from Board b inner join b.category c where c.catId = :catId")
	List<Board> findByCatId(@Param("catId") Long catId);
}