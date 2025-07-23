package com.example.demo.mapper;

import com.example.demo.dto.board.BoardCreateRequest;
import com.example.demo.model.Board;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    List<Board> getBoards(int page, int size);

    void createBoard(BoardCreateRequest board);
}
