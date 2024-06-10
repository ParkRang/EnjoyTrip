package com.ssafy.project.attr.model;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AttrListDto {
	
	@Schema(description = "관광지 목록")
	private List<AttrDto> Attrs;
	@Schema(description = "현재 페이지번호")
	private int currentPage;
	@Schema(description = "전체 페이지 수")
	private int totalPageCount;
	
}
