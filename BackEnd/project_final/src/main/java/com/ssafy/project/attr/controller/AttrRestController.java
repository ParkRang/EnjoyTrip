package com.ssafy.project.attr.controller;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.project.attr.model.AttrDto;
import com.ssafy.project.attr.model.AttrListDto;
import com.ssafy.project.attr.model.service.AttrService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/attr")
@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
@Tag(name = "관광지 컨트롤러", description = "관광지 등록, 수정, 삭제, 목록, 상세보기등 전반적인 처리를 하는 클래스.")
public class AttrRestController {
	
	private AttrService attrService;
	
	public AttrRestController(AttrService attrService) {
		super();
		this.attrService = attrService;
	}
	
//	@Operation(summary="관광지 정보", description="모든 관광지 리스트")
//	@GetMapping
//	public ResponseEntity<?> listAttr(
//			@RequestParam @Parameter(description = "관광지 얻기위한 부가정보.", required = true) Map<String, String> map
//			){
//		try {
//			AttrListDto attrListDto = attrService.listAttr(map);
//			HttpHeaders header = new HttpHeaders();
//			header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
//			return ResponseEntity.ok().headers(header).body(attrListDto);
//		} catch(Exception e) {
//			return exceptionHandling(e);
//		}
//	}
//	@CrossOrigin(origins = "http://localhost:3000")
	@Operation(summary="관광지 정보", description="모든 관광지 리스트")
	@GetMapping
	public ResponseEntity<?> listAttr(){
		try {
			List<AttrDto> list = attrService.listAttr();
			HttpHeaders header = new HttpHeaders();
			header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
			return ResponseEntity.ok().headers(header).body(list);
		} catch(Exception e) {
			return exceptionHandling(e);
		}
	}
//	@CrossOrigin(origins = "http://localhost:3000")
	@GetMapping("/{content_id}")
	public ResponseEntity<AttrDto> getAttr(@PathVariable("content_id") @Parameter(name="content_id", required=true) int content_id) throws Exception {
		return new ResponseEntity<AttrDto>(attrService.getAttr(content_id), HttpStatus.OK);
	}
	
	@GetMapping("/search/{title}")
	public ResponseEntity<?> listSearchAttr(@PathVariable("title") @Parameter(name="title", required= true) String title) {
		try {
			List<AttrDto> list = attrService.listSearchAttr(title);
			HttpHeaders header = new HttpHeaders();
			header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
			return ResponseEntity.ok().headers(header).body(list);
		} catch(Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@PostMapping("/regist")
	public ResponseEntity<?> registAttr(
			@RequestBody @Parameter(required=true) AttrDto attrDto) throws Exception {
		try {
			attrService.registAttr(attrDto);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} catch(Exception e) {
			return exceptionHandling(e);
		}
	}
	
//	public ResponseEntity<AttrListDto> searchAttr(@PathVariable("title") @Parameter(name = "title", required=true) String title) throws Exception{
//		
//		return new ResponseEntity<AttrListDto>(attrService.searchAttr(title), HttpStatus.OK);
//	}
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	

    public static String encodeParameter(String parameter) {
        try {
            return URLEncoder.encode(parameter, StandardCharsets.UTF_8.toString());
        } catch (UnsupportedEncodingException e) {
            // UTF-8 인코딩을 지원하지 않는 경우 처리할 예외 처리 코드
            e.printStackTrace();
            return null; // 또는 예외를 throw하여 처리
        }
    }
}
