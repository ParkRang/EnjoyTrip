package com.ssafy.project.visit.model.mapper;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.ssafy.project.visit.model.VisitDto;
import com.ssafy.project.visit.model.VisitDtoWithTitle;

@Mapper
public interface VisitMapper {
	void visitAuthentication(VisitDto visitDto) throws Exception;
	void visitChecked(int no) throws Exception;
	void visitRejected(int no) throws Exception;
	int statusCheck(String id, int attr_id) throws Exception;
	void pointUp(int no) throws Exception;
	List<VisitDtoWithTitle> showAllList() throws Exception;
	List<VisitDtoWithTitle> showWaited() throws Exception;
}
