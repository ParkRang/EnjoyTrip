package com.ssafy.project.group.model.mapper;

import java.util.List;

import com.ssafy.project.group.model.GroupDto;

public interface GroupMapper {
	List<GroupDto> findGroup(String name) throws Exception;
}
