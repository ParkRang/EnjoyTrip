package com.ssafy.project.product.controller;

import java.nio.charset.Charset;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.project.product.model.ProductDto;
import com.ssafy.project.product.model.service.ProductService;

import io.swagger.v3.oas.annotations.Parameter;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	private ProductService productService;
	
	@Autowired
	public ProductController(ProductService productService) {
		super();
		this.productService = productService;
	}
	
	@GetMapping
	public ResponseEntity<?> listProduct(){
		try {
			List<ProductDto> list = productService.listProduct();
			HttpHeaders header = new HttpHeaders();
			header.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
			return ResponseEntity.ok().headers(header).body(list);
		} catch(Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> productDetail(@PathVariable("id") @Parameter(name="id", description="상품 번호", required=true) int id) throws Exception {
		return new ResponseEntity<ProductDto>(productService.productDetail(id), HttpStatus.OK);
	}
	
	
	private ResponseEntity<String> exceptionHandling(Exception e) {
		e.printStackTrace();
		return new ResponseEntity<String>("Error : " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
