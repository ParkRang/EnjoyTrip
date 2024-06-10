package com.ssafy.project.group.controller;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssafy.project.group.model.GroupDto;
import com.ssafy.project.group.model.service.GroupService;

import io.swagger.v3.oas.annotations.Parameter;

@Controller
@RequestMapping("/group")
public class GroupController {
	private GroupService groupService;
	
	public GroupController(GroupService groupService) {
		super();
		this.groupService = groupService;
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<?> findGroup(
			@PathVariable("name") @Parameter(name = "name", description = "그룹 이름", required = true) String name){
		try {
			List<GroupDto> list = groupService.findGroup(name);
			HttpHeaders header = new HttpHeaders();
			header.setContentType(new MediaType("appliaction", "json", Charset.forName("UTF-8")));
			return ResponseEntity.ok().headers(header).body(list);
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
