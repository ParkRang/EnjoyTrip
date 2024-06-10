package com.ssafy.project.visit.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Schema(title="VisitDto : 방문 정보", description="유저 방문 정보 출력")
public class VisitDto {
	@Schema(description="방문 번호")
	private int no;
	@Schema(description="유저 아이디")
	private String user_id;
	@Schema(description="관광지 아이디")
	private int attraction_info_content_id;
	@Schema(description="요청 상태")
	private String status;
	
}
