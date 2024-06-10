package com.ssafy.project.attr.model.service;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ssafy.project.attr.model.AttrDto;
import com.ssafy.project.attr.model.AttrListDto;
import com.ssafy.project.attr.model.mapper.AttrMapper;

@Service
public class AttrServiceImpl implements AttrService {

	private AttrMapper attrMapper;
	
	@Autowired
	public AttrServiceImpl(AttrMapper attrMapper) {
		super();
		this.attrMapper = attrMapper;
	}
	
	@Override
	public AttrListDto listAttr(Map<String, String> map) throws Exception {
		Map<String, Object> param = new HashMap<String, Object>();
		param.put("word", map.get("word")==null? "": map.get("word"));
		int currentPage = Integer.parseInt(map.get("pgno")==null? "1" :map.get("pgno"));
		int sizePerPage = Integer.parseInt(map.get("spp")==null?"20":map.get("spp"));
		int start = currentPage * sizePerPage - sizePerPage;
		param.put("start", start);
		param.put("listsize", sizePerPage);
		
		String key = map.get("key");
		param.put("key", key == null ? "" : key);
		if("id".equals(key))
			param.put("key", key==null?"" : "id");
		List<AttrDto> list = attrMapper.listAttr();
		
		if("id".equals(key))
			param.put("key", key==null? "" : "id");
		int totalAttrCount = attrMapper.getTotalAttrCount(param);
		
		AttrListDto attrListDto = new AttrListDto();
		attrListDto.setAttrs(list);
		attrListDto.setCurrentPage(currentPage);
		attrListDto.setTotalPageCount(totalAttrCount);
		
		return attrListDto;
	}

	@Override
	public AttrDto getAttr(int content_id) throws Exception {
		
		return attrMapper.getAttr(content_id);
	}


	@Override
	@Transactional
	public void registAttr(AttrDto attrDto) throws Exception {
		attrMapper.registAttr(attrDto);
		
	}

	@Override
	public AttrListDto searchAttr(String title) throws Exception {
		
		return attrMapper.searchAttr(title);
	}

	@Override
	public List<AttrDto> listAttr() throws Exception {
		
		return attrMapper.listAttr();
	}

	@Override
	public List<AttrDto> listSearchAttr(String title) throws Exception{
		return attrMapper.listSearchAttr(title);
	}

}
