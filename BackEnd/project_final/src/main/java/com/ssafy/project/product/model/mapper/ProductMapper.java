package com.ssafy.project.product.model.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.project.product.model.ProductDto;

@Mapper
public interface ProductMapper {
	List<ProductDto> listProduct() throws Exception;
	ProductDto productDetail(int product_id) throws Exception;
	void buyProduct(String id, int product_id) throws Exception;
	void useProduct(String id, int product_id) throws Exception;
	List<ProductDto> userProductList(String id) throws Exception;
}
