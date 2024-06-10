package com.ssafy.project.member.model.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.project.member.model.UserDto;
import com.ssafy.project.product.model.ProductDto;

@Mapper
public interface UserMapper {
	UserDto login(UserDto userDto) throws Exception;
//	UserDto login(Map<String, String> info) throws Exception;
	UserDto userInfo(String id) throws Exception;
	List<UserDto> userList(String role) throws Exception;
	void saveRefreshToken(Map<String, String> data) throws Exception;
	String getRefreshToken(String id) throws Exception;
	void deleteRefreshToken(Map<String, String> data) throws Exception;
	void join(UserDto userDto) throws Exception;
	void userDelete(String id) throws Exception;
	void userFix(UserDto userDto) throws Exception;
//	List<ProductDto> inventory(String id) throws Exception;
}
