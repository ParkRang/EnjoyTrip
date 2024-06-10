package com.ssafy.project.attr.model.service;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.ssafy.project.attr.model.AttrDto;
import com.ssafy.project.attr.model.AttrListDto;

public interface AttrService {
	AttrListDto listAttr(Map<String, String> map) throws Exception;
	List<AttrDto> listAttr() throws Exception;
	AttrDto getAttr(int content_id) throws Exception;
	void registAttr(AttrDto attrDto) throws Exception;
	AttrListDto	searchAttr(String title) throws Exception;
	List<AttrDto> listSearchAttr(String title) throws Exception;
}
