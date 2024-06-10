package com.ssafy.project.member.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Schema(title="UserDto : 유저 정보", description="유저 정보 출력")
public class UserDto {
	@Schema(description="유저 아이디")
	private String id;
	@Schema(description="유저 비밀번호")
	private String password;
	@Schema(description="유저 닉네임")
	private String nickname;
	@Schema(description="유저 프사")
	private String img;
	@Schema(description="유저 포인트")
	private int point;
	@Schema(description="유저 토큰")
	private String token;
	@Schema(description="유저 역할")
	private String role;
//	public String getId() {
//		return id;
//	}
//	public void setId(String id) {
//		this.id = id;
//	}
//	public String getPassword() {
//		return password;
//	}
//	public void setPassword(String password) {
//		this.password = password;
//	}
//	public String getNickname() {
//		return nickname;
//	}
//	public void setNickname(String nickname) {
//		this.nickname = nickname;
//	}
//	public String getImg() {
//		return img;
//	}
//	public void setImg(String img) {
//		this.img = img;
//	}
//	public int getPoint() {
//		return point;
//	}
//	public void setPoint(int point) {
//		this.point = point;
//	}
//	public String getToken() {
//		return token;
//	}
//	public void setToken(String token) {
//		this.token = token;
//	}
//	public String getRole() {
//		return role;
//	}
//	public void setRole(String role) {
//		this.role = role;
//	}
	
	
}
