package com.ssafy.project.group.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.project.group.model.GroupDto;
import com.ssafy.project.group.model.mapper.GroupMapper;

@Service
public class GroupServiceImpl implements GroupService {

	private GroupMapper groupMapper;
	
	@Autowired
	public GroupServiceImpl(GroupMapper groupMapper) {
		super();
		this.groupMapper = groupMapper;
	}
	
	@Override
	public List<GroupDto> findGroup(String name) throws Exception {
		return groupMapper.findGroup(name);
	}

}
