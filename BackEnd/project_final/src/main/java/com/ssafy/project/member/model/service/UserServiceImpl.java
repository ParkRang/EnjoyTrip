package com.ssafy.project.member.model.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.project.member.model.UserDto;
import com.ssafy.project.member.model.mapper.UserMapper;
import com.ssafy.project.product.model.ProductDto;

@Service
public class UserServiceImpl implements UserService {

	private UserMapper userMapper;
	
	public UserServiceImpl(UserMapper userMapper) {
		super();
		this.userMapper = userMapper;
	}
	
	@Override
	public UserDto login(UserDto userDto) throws Exception {
//		Map<String, String> map = new HashMap<String, String>();
//		map.put("id", userDto.getId());
//		map.put("password", userDto.getPassword());
		return userMapper.login(userDto);
	}

	@Override
	public UserDto userInfo(String id) throws Exception {
		
		return userMapper.userInfo(id);
	}

	@Override
	public void saveRefreshToken(String id, String refreshToken) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("token", refreshToken);
		userMapper.saveRefreshToken(map);
	}

	@Override
	public String getRefreshToken(String id) throws Exception {
		
		return userMapper.getRefreshToken(id);
	}

	@Override
	public void deleteRefreshToken(String id) throws Exception {
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", id);
		map.put("token", null);
		userMapper.deleteRefreshToken(map);
	}

	@Override
	public List<UserDto> userList(String role) throws Exception {

		return userMapper.userList(role);
	}

	@Override
	public void join(UserDto userDto) throws Exception {
		userDto.setPoint(0);
		userDto.setToken("1");
		userDto.setRole("normal");
		userMapper.join(userDto);
		
	}

	@Override
	@Transactional
	public void userDelete(String id) throws Exception {
		userMapper.userDelete(id);
		
	}

	@Override
	@Transactional
	public void userFix(UserDto userDto) throws Exception {
		userMapper.userFix(userDto);
		
	}


}
