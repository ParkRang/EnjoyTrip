package com.ssafy.project.product.model;

public class ProductDto {
	private int id;
	private String type;
	private int discount;
	private int count_cost;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getCount_cost() {
		return count_cost;
	}
	public void setCount_cost(int count_cost) {
		this.count_cost = count_cost;
	}
	
	
}
