package aaa.model;

import java.util.ArrayList;
import java.util.List;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class Camping {
	@NotEmpty(message = "캠핑장명은 비어있을 수 없습니다")
	String campName;
	@NotEmpty(message = "사이트 종류는 비어있을 수 없습니다")
	@Pattern(regexp = "(대|중|소|[A-Z])", message = "대, 중, 소 혹은 대문자 A-Z까지 가능합니다")
	@Size(max = 1, message = "한글자만 가능합니다")
	String siteType;
	@NotEmpty(message = "비어있을 수 없습니다")
	@Pattern(regexp = "(^[0-9]+[mM]$|^[0-9]+[.][0-9]+[mM]$)",
			message = "10m(M) 혹은 10.5m(M)와 같은 형식이어야 합니다")
	String minSize;
	@NotEmpty(message = "비어있을 수 없습니다")
	@Pattern(regexp = "(^[0-9]+[mM]$|^[0-9]+[.][0-9]+[mM]$)",
			message = "10m(M) 혹은 10.5m(M)와 같은 형식이어야 합니다")
	String maxSize;
	@NotEmpty(message = "사업자 번호는 비어있을 수 없습니다")
	@Pattern(regexp = "[0-9]+", message = "숫자만 입력하세요")
	@Positive(message = "0이상 가능합니다")
	@Size(min = 10, max = 10, message = "10자리까지 가능합니다")
	String campBusinessNum;
	@Positive(message = "0이상 가능합니다")
	int siteTot;
	@Positive(message = "0이상 가능합니다")
	int minPerson;
	@Positive(message = "0이상 가능합니다")
	int maxPerson;
	@NotEmpty(message = "입실 시간은 비어있을 수 없습니다")
	String checkIn;
	@NotEmpty(message = "퇴실 시간은 비어있을 수 없습니다")
	String checkOut;
	
	public List<String> getSitesArray(){
		List<String> campArray = new ArrayList<>();
		campArray.add("사이트 1");
		campArray.add("사이트 2");
		campArray.add("사이트 3");
		return campArray;
	}
}