package com.kimscooperation.kimsboard.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kimscooperation.kimsboard.domain.board.Board;

public interface BoardRepository extends JpaRepository<Board, Long> {
	Board findByName(String name);
}
