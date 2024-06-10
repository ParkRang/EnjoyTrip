package com.ssafy.project.wishlist.controller;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.project.wishlist.model.WishlistDto;
import com.ssafy.project.wishlist.model.WishlistImageDto;
import com.ssafy.project.wishlist.model.service.WishlistService;

import io.swagger.v3.oas.annotations.Parameter;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/wishlist")
@CrossOrigin(origins = "http://localhost:3000")
@Slf4j
public class WishlistController {
	
	private WishlistService wishlistService;
	
	@Autowired
	public WishlistController(WishlistService wishlistService) {
		super();
		this.wishlistService = wishlistService;
	}
	
	@GetMapping
	public ResponseEntity<?> showWishlist(
			) {
		try {
			List<WishlistDto> list = wishlistService.showWishlist();
			HttpHeaders header = new HttpHeaders();
			header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
			return ResponseEntity.ok().headers(header).body(list);
		} catch(Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@PostMapping("/add")
	public ResponseEntity<?> addWishlist(
			@RequestBody @Parameter(required=true)WishlistDto wishlistDto){
		try {
			wishlistService.addWishlist(wishlistDto);
			return new ResponseEntity<Void>(HttpStatus.CREATED);
		} catch(Exception e) {
			return exceptionHandling(e);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> removeWishlist(@PathVariable("id") @Parameter(name="id", description="삭제할 위시리스트 번호", required=true) int id) throws Exception{
		wishlistService.removeWishlist(id);
		return ResponseEntity.ok().build();
	}
	
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
