package com.example.demo.controller;

import com.example.demo.dto.board.BoardCreateRequest;
import com.example.demo.model.Board;
import com.example.demo.service.BoardService;
import com.example.demo.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService boardService;

    @GetMapping
    public List<Board> getMenu(
      @RequestParam(defaultValue = "1") int page,
      @RequestParam(defaultValue = "10") int size
    ) {
        return boardService.getBoards(page,size);
    }

    @PostMapping
    public void createMenu(@RequestBody BoardCreateRequest board) {
        boardService.createBoard(board);
    }
}
