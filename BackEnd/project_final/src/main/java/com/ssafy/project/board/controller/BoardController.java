package com.ssafy.project.board.controller;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.project.board.model.BoardDto;
import com.ssafy.project.board.model.service.BoardService;

import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/board")
@CrossOrigin(origins = "http://localhost:3000")
public class BoardController {

    private BoardService boardService;

    public BoardController(BoardService boardService) {
        super();
        this.boardService = boardService;
    }

    @PostMapping
    public ResponseEntity<?> writeBoard(@RequestBody @Parameter BoardDto boardDto) {
        try {
            boardService.writeBoard(boardDto);
            return new ResponseEntity<Void>(HttpStatus.CREATED);
        }catch(Exception e) {
            return exceptionHandling(e);
        }
    }
    
    @GetMapping
    public ResponseEntity<?> listBoard() throws Exception{
        try {
            List<BoardDto> list = boardService.listBoard();
            HttpHeaders header = new HttpHeaders();
            header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
            return ResponseEntity.ok().headers(header).body(list);
        } catch(Exception e) {
            return exceptionHandling(e);
        }
    }

    @GetMapping("/{group_id}")
    public ResponseEntity<?> listGroupBoard(
            @PathVariable("group_id") @Parameter(name="group_id", required=true) int group_id) throws Exception{
        try {
            List<BoardDto> list = boardService.listGroupBoard(group_id);
            HttpHeaders header = new HttpHeaders();
            header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
            return ResponseEntity.ok().headers(header).body(list);
        } catch(Exception e) {
            return exceptionHandling(e);
        }
    }

@GetMapping("/detail/{id}")
public ResponseEntity<BoardDto> getBoard(
        @PathVariable("id") @Parameter(name="id", required = true) int id) throws Exception
{
    boardService.updateHit(id);
    return new ResponseEntity<BoardDto>(boardService.getBoard(id), HttpStatus.OK);
}

@GetMapping("/good/{id}/{userId}")
public ResponseEntity<?> goodBoard(
        @PathVariable("id") @Parameter(name = "id") int id,
        @PathVariable("userId") @Parameter(name = "userId") String userId
) throws Exception {
    try {
        boardService.good(id, userId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    } catch (Exception e) {
        return exceptionHandling(e);
    }
}

@GetMapping("/bad/{id}/{userId}")
public ResponseEntity<?> badBoard(
        @PathVariable("id") @Parameter(name = "id") int id,
        @PathVariable("userId") @Parameter(name = "userId") String userId
) throws Exception {
    try {
        boardService.bad(id, userId);
        return new ResponseEntity<Void>(HttpStatus.OK);
    } catch (Exception e) {
        return exceptionHandling(e);
    }
}

@PutMapping
public ResponseEntity<String> modifyBoard(
        @RequestBody @Parameter BoardDto boardDto) throws Exception {
    boardService.modifyBoard(boardDto);
    return ResponseEntity.ok().build();
}

@DeleteMapping("/{id}")
public ResponseEntity<String> deleteBoard(@PathVariable("id") @Parameter(name="id") int id) throws Exception{
    boardService.deleteBoard(id);
    return ResponseEntity.ok().build();
}

@GetMapping("/modify/{id}")
public ResponseEntity<BoardDto> getModifyBoard(
        @PathVariable("id") @Parameter(name="id", required = true) int id) throws Exception
{
    return new ResponseEntity<BoardDto>(boardService.getBoard(id), HttpStatus.OK);
}

private ResponseEntity<String> exceptionHandling(Exception e) {
    e.printStackTrace();
    return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
}
}