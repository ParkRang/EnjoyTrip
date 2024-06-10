package com.ssafy.project.visit.controller;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.project.visit.model.VisitDto;
import com.ssafy.project.visit.model.VisitDtoWithTitle;
import com.ssafy.project.visit.model.service.VisitService;

import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/visit")
@CrossOrigin(origins = "http://localhost:3000")
public class VisitController {
	
	private VisitService visitService;
	
	public VisitController(VisitService visitService) {
		super();
		this.visitService = visitService;
	}
	
	@GetMapping("/all")
	public ResponseEntity<?> showAllList(){
		try {
			List<VisitDtoWithTitle> list = visitService.showAllList();
			HttpHeaders header = new HttpHeaders();
			header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
			return ResponseEntity.ok().headers(header).body(list);
		} catch(Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@GetMapping("/waited")
	public ResponseEntity<?> showWaited(){
		try {
			List<VisitDtoWithTitle> list = visitService.showWaited();
			HttpHeaders header = new HttpHeaders();
			header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
			return ResponseEntity.ok().headers(header).body(list);
		} catch(Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@PostMapping
	public ResponseEntity<?> visitAuthentication(
			@RequestBody @Parameter(description = "작성 정보.", required = true)VisitDto visitDto) {
		try {
			visitService.visitAuthentication(visitDto);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} catch(Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@PutMapping("/{no}/check")
	public ResponseEntity<?> visitChecked(
			@PathVariable("no") @RequestBody @Parameter(name="no", description = "확인", required = true)int no) throws Exception{
		visitService.visitChecked(no);
		return ResponseEntity.ok().build();
	}
	
	@PutMapping("/{no}/reject")
	public ResponseEntity<?> visitRejected(
			@PathVariable("no") @RequestBody @Parameter(name="no", description = "반려", required = true)int no) throws Exception{
		visitService.visitRejected(no);
		return ResponseEntity.ok().build();
	}
	
	
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
