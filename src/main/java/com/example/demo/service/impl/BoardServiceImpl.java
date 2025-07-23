package com.example.demo.service.impl;

import com.example.demo.dto.board.BoardCreateRequest;
import com.example.demo.mapper.BoardMapper;
import com.example.demo.model.Board;
import com.example.demo.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {
    private final BoardMapper boardMapper;

    public List<Board> getBoards(int page, int size) {
        return boardMapper.getBoards(page, size);
    }

    public void createBoard(BoardCreateRequest board) {
        boardMapper.createBoard(board);
    }
}
