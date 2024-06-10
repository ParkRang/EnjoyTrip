package com.ssafy.project.product.model.service;

import java.util.List;

import com.ssafy.project.product.model.ProductDto;

public interface ProductService {
	List<ProductDto> listProduct() throws Exception;
	ProductDto productDetail(int product_id) throws Exception;
	void buyProduct(String id, int product_id) throws Exception;
	void useProduct(String id, int product_id) throws Exception;
	List<ProductDto> userProductList(String id) throws Exception;
}
