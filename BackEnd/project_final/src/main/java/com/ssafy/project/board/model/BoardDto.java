package com.ssafy.project.board.model;

import java.util.List;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Schema(title="BoardDto : 게시판 정보", description="게시판 출력")
public class BoardDto {
	@Schema(description ="게시글 번호")
	private int id;
	@Schema(description ="유저 아이디")
	private String user_id;
	@Schema(description ="게시글 제목")
	private String title;
	@Schema(description ="게시글 내용")
	private String subject;
	@Schema(description ="이미지")
	private String img;
	@Schema(description ="그룹 번호")
	private int matching_group_id;
	@Schema(description ="조회수")
	private int hit;
	@Schema(description ="좋아요")
	private int good;
	@Schema(description ="별로에요")
	private int bad;

}
