package com.study.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.study.springboot.domain.Board;
import com.study.springboot.repository.BoardRepository;

@Service
public class BoardService {
	@Autowired
	BoardRepository bRepository;
	
	public List<Board> list() {
		return bRepository.findAll();
	}

	public Board insert(Board board) {
		return bRepository.save(board);		
	}

	public Optional<Board> selectDetail(Long bno) {
		return bRepository.findById(bno);
	}
	
}

