package com.ion.blogapi.board.repository;

import com.ion.blogapi.board.domain.Board;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardRepository extends JpaRepository<Board, Long> {
}
