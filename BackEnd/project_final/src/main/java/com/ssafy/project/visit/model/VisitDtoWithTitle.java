package com.ssafy.project.visit.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Schema(title="VisitDtoWithTitle : 방문 정보", description="유저 방문 정보 출력")
public class VisitDtoWithTitle{
	@Schema(description="방문 번호")
	private int no;
	@Schema(description="유저 아이디")
	private String user_id;
	@Schema(description="관광지 제목")
	private String title;
	@Schema(description="포인트")
	private int point;
	@Schema(description="요청 상태")
	private String status;
	
}
