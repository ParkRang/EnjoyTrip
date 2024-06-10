package com.ssafy.project.attr.model;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Schema(title="AttrDto : 관광지 정보", description="관광지 리스트 출력")
public class AttrDto {
	
	@Schema(description = "관광지 번호")
	private int content_id;
	@Schema(description = "관광지 타입")
	private int content_type_id;
	@Schema(description = "관광지 이름")
	private String title;
	@Schema(description = "관광지 주소")
	private String addr1;
	@Schema(description = "관광지 상세주소")
	private String addr2;
	@Schema(description = "관광지 코드")
	private String zipcode;
	@Schema(description = "관광지 전화번호")
	private String tel;
	@Schema(description = "관광지 이미지")
	private String first_image;
	@Schema(description = "관광지 이미지2")
	private String first_image2;
	@Schema(description = "관광지 조회수")
	private int readcount;
	@Schema(description = "관광지 시도코드")
	private int sido_code;
	@Schema(description = "관광지 구군코드")
	private int gugun_code;
	@Schema(description = "관광지 위도")
	private double latitude;
	@Schema(description = "관광지 경도")
	private double longitude;
	@Schema(description = "관광지 mlevel")
	private String mlevel;
	@Schema(description = "관광지 점수")
	private int point;
	@Schema(description = "관광지 카운트")
	private int count;
	
//	public int getContent_id() {
//		return content_id;
//	}
//	public void setContent_id(int content_id) {
//		this.content_id = content_id;
//	}
//	public int getContent_type_id() {
//		return content_type_id;
//	}
//	public void setContent_type_id(int content_type_id) {
//		this.content_type_id = content_type_id;
//	}
//	public String getTitle() {
//		return title;
//	}
//	public void setTitle(String title) {
//		this.title = title;
//	}
//	public String getAddr1() {
//		return addr1;
//	}
//	public void setAddr1(String addr1) {
//		this.addr1 = addr1;
//	}
//	public String getAddr2() {
//		return addr2;
//	}
//	public void setAddr2(String addr2) {
//		this.addr2 = addr2;
//	}
//	public String getZipcode() {
//		return zipcode;
//	}
//	public void setZipcode(String zipcode) {
//		this.zipcode = zipcode;
//	}
//	public String getTel() {
//		return tel;
//	}
//	public void setTel(String tel) {
//		this.tel = tel;
//	}
//	public String getFirst_image() {
//		return first_image;
//	}
//	public void setFirst_image(String first_image) {
//		this.first_image = first_image;
//	}
//	public String getFirst_image2() {
//		return first_image2;
//	}
//	public void setFirst_image2(String first_image2) {
//		this.first_image2 = first_image2;
//	}
//	public int getReadcount() {
//		return readcount;
//	}
//	public void setReadcount(int readcount) {
//		this.readcount = readcount;
//	}
//	public int getSido_code() {
//		return sido_code;
//	}
//	public void setSido_code(int sido_code) {
//		this.sido_code = sido_code;
//	}
//	public int getGugun_code() {
//		return gugun_code;
//	}
//	public void setGugun_code(int gugun_code) {
//		this.gugun_code = gugun_code;
//	}
//	public double getLatitude() {
//		return latitude;
//	}
//	public void setLatitude(double latitude) {
//		this.latitude = latitude;
//	}
//	public double getLongitude() {
//		return longitude;
//	}
//	public void setLongitude(double longitude) {
//		this.longitude = longitude;
//	}
//	public String getMlevel() {
//		return mlevel;
//	}
//	public void setMlevel(String mlevel) {
//		this.mlevel = mlevel;
//	}
//	public int getPoint() {
//		return point;
//	}
//	public void setPoint(int point) {
//		this.point = point;
//	}
//	public int getCount() {
//		return count;
//	}
//	public void setCount(int count) {
//		this.count = count;
//	}
	
	
}
