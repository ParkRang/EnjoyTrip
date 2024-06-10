package com.ssafy.project.wishlist.model;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Schema(title="WishlistImageDto : 위시리스트 이미지", description="정보 출력")
public class WishlistImageDto {
	@Schema(description="유저 아이디")
	private String user_id;
	@Schema(description="이미지1")
	private String image1;
	@Schema(description="이미지2")
	private String image2;
	@Schema(description="이미지3")
	private String image3;
	@Schema(description="이미지4")
	private String image4;
	@Schema(description="이미지5")
	private String image5;
}
