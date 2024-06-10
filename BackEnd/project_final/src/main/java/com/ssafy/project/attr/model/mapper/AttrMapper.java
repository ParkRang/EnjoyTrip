package com.ssafy.project.attr.model.mapper;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.project.attr.model.AttrDto;
import com.ssafy.project.attr.model.AttrListDto;

@Mapper
public interface AttrMapper {
	List<AttrDto> listAttr() throws Exception;
	AttrDto getAttr(int content_id) throws Exception;
	void registAttr(AttrDto attrDto) throws Exception;
	AttrListDto	searchAttr(String title) throws Exception;
	int getTotalAttrCount(Map<String, Object> param) throws SQLException;
	List<AttrDto> listSearchAttr(String title) throws Exception;
}
