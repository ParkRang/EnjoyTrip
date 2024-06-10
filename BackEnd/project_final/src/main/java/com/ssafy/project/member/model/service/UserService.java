package com.ssafy.project.member.model.service;

import java.util.List;
import java.util.Map;

import com.ssafy.project.member.model.UserDto;
import com.ssafy.project.product.model.ProductDto;

public interface UserService {
	UserDto login(UserDto userDto) throws Exception;
//	UserDto login(Map<String, String> info) throws Exception;
	UserDto userInfo(String id) throws Exception;
	List<UserDto> userList(String role) throws Exception;
	void saveRefreshToken(String id, String refreshToken) throws Exception;
	String getRefreshToken(String id) throws Exception;
	void deleteRefreshToken(String id) throws Exception;
	void join(UserDto userDto) throws Exception;
	void userDelete(String id) throws Exception;
	void userFix(UserDto userDto) throws Exception;
//	List<ProductDto> inventory(String id) throws Exception;
}
