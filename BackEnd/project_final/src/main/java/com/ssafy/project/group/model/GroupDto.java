package com.ssafy.project.group.model;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Schema(title = "GroupDto", description = "그룹 정보를 나타낸다.")
public class GroupDto {
	@Schema(description="그룹 번호")
	private int id;
	@Schema(description="그룹 이름")
	private String groupName;
	@Schema(description="게시글 번호")
	private int board_id;
	@Schema(description="유저 아이디")
	private String user_id;
	
}
