package com.ssafy.project.group.model.service;

import java.util.List;

import com.ssafy.project.group.model.GroupDto;

public interface GroupService {
	List<GroupDto> findGroup(String name) throws Exception;
}
