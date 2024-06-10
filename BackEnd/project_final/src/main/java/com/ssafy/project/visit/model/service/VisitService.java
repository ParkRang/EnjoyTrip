package com.ssafy.project.visit.model.service;

import java.util.List;

import com.ssafy.project.visit.model.VisitDto;
import com.ssafy.project.visit.model.VisitDtoWithTitle;

public interface VisitService {
	void visitAuthentication(VisitDto visitDto) throws Exception;
	void visitChecked(int no) throws Exception;
	void visitRejected(int no) throws Exception;
	int statusCheck(String id, int attr_id) throws Exception;
	void pointUp(int no) throws Exception;
	List<VisitDtoWithTitle> showAllList() throws Exception;
	List<VisitDtoWithTitle> showWaited() throws Exception;
}
