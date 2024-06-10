package com.ssafy.project.visit.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ssafy.project.visit.model.VisitDto;
import com.ssafy.project.visit.model.VisitDtoWithTitle;
import com.ssafy.project.visit.model.mapper.VisitMapper;

@Service
public class VisitServiceImpl implements VisitService {

	private VisitMapper visitMapper;
	
	@Autowired
	public VisitServiceImpl(VisitMapper visitMapper) {
		super();
		this.visitMapper = visitMapper;
	}
	
	@Override
	public void visitAuthentication(VisitDto visitDto) throws Exception {
		if(statusCheck(visitDto.getUser_id(), visitDto.getAttraction_info_content_id())<1)
			visitMapper.visitAuthentication(visitDto);
	}

	@Override
	public void visitChecked(int no) throws Exception {
		visitMapper.visitChecked(no);
	}

	@Override
	public void visitRejected(int no) throws Exception {
		visitMapper.visitRejected(no);
	}

	@Override
	public int statusCheck(String id, int attr_id) throws Exception {
		return visitMapper.statusCheck(id, attr_id);
	}

	@Override
	public void pointUp(int no) throws Exception {
		visitMapper.pointUp(no);
		
	}

	@Override
	public List<VisitDtoWithTitle> showAllList() throws Exception {
		return visitMapper.showAllList();
		
	}

	@Override
	public List<VisitDtoWithTitle> showWaited() throws Exception {
		return visitMapper.showWaited();
	}
	
	
	
//	alter table visit add status varchar(10) default "waited" not null;
//	-- waited / accepted / rejected 
//
//	insert into visit(user_id, attraction_info_content_id) values("vue", 127722);

}
