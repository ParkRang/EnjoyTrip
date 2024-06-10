package com.ssafy.project.product.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.project.product.model.ProductDto;
import com.ssafy.project.product.model.mapper.ProductMapper;

@Service
public class ProductServiceImpl implements ProductService {

	private ProductMapper productMapper;
	
	@Autowired
	public ProductServiceImpl(ProductMapper productMapper) {
		super();
		this.productMapper =productMapper;
	}
	
	@Override
	public List<ProductDto> listProduct() throws Exception {
		
		return productMapper.listProduct();
	}

	@Override
	public void buyProduct(String id, int product_id) throws Exception {
		productMapper.buyProduct(id, product_id);
		
	}

	@Override
	public void useProduct(String id, int product_id) throws Exception {
		productMapper.useProduct(id,product_id);
		
	}

	@Override
	public ProductDto productDetail(int product_id) throws Exception {
		return productMapper.productDetail(product_id);
	}

	@Override
	public List<ProductDto> userProductList(String id) throws Exception {

		return productMapper.userProductList(id);
	}

}
