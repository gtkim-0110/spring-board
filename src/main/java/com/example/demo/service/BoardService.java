package com.example.demo.service;

import com.example.demo.dto.board.BoardCreateRequest;
import com.example.demo.model.Board;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BoardService {
    List<Board> getBoards(@Param("page") int page, @Param("size") int size);

    void createBoard(BoardCreateRequest board);
}
