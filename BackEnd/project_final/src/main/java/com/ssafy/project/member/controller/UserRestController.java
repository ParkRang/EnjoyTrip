package com.ssafy.project.member.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
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

import com.ssafy.project.member.model.UserDto;
import com.ssafy.project.member.model.service.UserService;
import com.ssafy.project.util.JWTUtil;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
//import io.swagger.v3.oas.annotations.parameters.RequestBody;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/user")
@CrossOrigin(origins = "http://localhost:3000")
@Tag(name = "회원 컨트롤러", description = "회원 관련 로직 처리")
public class UserRestController {
	private final UserService userService;
	private final JWTUtil jwtUtil;
	
	public UserRestController(UserService userService, JWTUtil jwtUtil) {
		super();
		this.userService = userService;
		this.jwtUtil = jwtUtil;
	}
	
	@Operation
	@PostMapping("/login")
	public ResponseEntity<Map<String, Object>> login(
			@RequestBody @Parameter(required=true) UserDto userDto){
		Map<String, Object> resultMap = new HashMap<String, Object>();
		HttpStatus status = HttpStatus.ACCEPTED;
		try {
			UserDto loginUser = userService.login(userDto);
			if(loginUser!=null) {
				String accessToken = jwtUtil.createAccessToken(loginUser.getId());
				String refreshToken = jwtUtil.createRefreshToken(loginUser.getId());
				
//				Map<String, String> tokens = new HashMap<String, String>();
//				tokens.put("id", loginUser.getId());
//				tokens.put("refreshToken", refreshToken);
				userService.saveRefreshToken(loginUser.getId(), refreshToken);
				
				resultMap.put("access-token", accessToken);
				resultMap.put("refresh-token", refreshToken);
				
				status = HttpStatus.CREATED;
			} else {
				resultMap.put("message", "아이디 또는 패스워드를 확인해주세요");
				status = HttpStatus.UNAUTHORIZED;
			}
		} catch(Exception e) {
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap,status);
	}
	
	@GetMapping("/info/{id}")
	public ResponseEntity<Map<String, Object>> getInfo(
			@PathVariable("id") @Parameter(required=true) String id,
			HttpServletRequest request){
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		if(jwtUtil.checkToken(request.getHeader("Authorization"))) {
			try {
				UserDto userDto = userService.userInfo(id);
				resultMap.put("userInfo", userDto);
				status = HttpStatus.OK;
			} catch (Exception e) {
				resultMap.put("message", e.getMessage());
				status = HttpStatus.INTERNAL_SERVER_ERROR;
			}
		} else {
			status = HttpStatus.UNAUTHORIZED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@PostMapping("/refresh")
	public ResponseEntity<?> refreshToken(@RequestBody UserDto userDto, HttpServletRequest request) throws Exception{
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		String token = request.getHeader("refreshToken");
		if(jwtUtil.checkToken(token)) {
			if(token.equals(userService.getRefreshToken(userDto.getId()))) {
				String accessToken = jwtUtil.createAccessToken(userDto.getId());
				resultMap.put("acceess-token", accessToken);
				status = HttpStatus.CREATED;
			}
		} else {
			status = HttpStatus.UNAUTHORIZED;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@GetMapping("/logout/{id}")
	@Hidden
	public ResponseEntity<?> removeToken(@PathVariable ("id") @Parameter(required=true) String id){
		Map<String, Object> resultMap = new HashMap<>();
		HttpStatus status = HttpStatus.ACCEPTED;
		try {
			userService.deleteRefreshToken(id);
			status=HttpStatus.OK;
		} catch(Exception e) {
			resultMap.put("message", e.getMessage());
			status = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		return new ResponseEntity<Map<String, Object>>(resultMap, status);
	}
	
	@PostMapping
	public ResponseEntity<?> join(@RequestBody @Parameter(required=true)UserDto userDto) throws Exception{
		try {
			userService.join(userDto);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} catch(Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> userDelete(@PathVariable("id")String id) throws Exception{
		userService.userDelete(id);
		return ResponseEntity.ok().build();
	}	
	
	@PutMapping("/fix")
	public ResponseEntity<?> userFix(@RequestBody @Parameter UserDto userDto) throws Exception{
		userService.userFix(userDto);
		return ResponseEntity.ok().build();
	}
	
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
//	@GetMapping("/userList")
//	public ResponseEntity<?> getUserList(
//			@PathVariable("id") @Parameter(required=false) String role){
//		return new ResponseEntity<>();
//	}
}
