package aaa.service;

import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import aaa.model.Camping;

@Service
public class CampingChk {
	public boolean businessChk(Camping camp, BindingResult br) {
		// 마지막 번호
		String checkNum = camp.getCampBusinessNum().substring(camp.getCampBusinessNum().length()-1);
		// 10자리 숫자를 각각 배열로 만들어 계산
		String[] checkArr = camp.getCampBusinessNum().split("");
		int[] calcArr = {1,3,7,1,3,7,1,3,5}; // 9자리에 각각 하나씩 곱할 수
		int sum = 0;
		int rest = 0;
		int chk = Integer.parseInt(checkNum);
		
		// System.out.println(chk);
		
		for(int i=0; i<calcArr.length; i++) {
			sum += calcArr[i] * Integer.parseInt(checkArr[i]);
			
			// 곱하는 마지막 9번째 수는 곱한 값에 10을 나눠 한 번 더 더함
			if(i==calcArr.length-1) {
				sum += (calcArr[i] * Integer.parseInt(checkArr[i]))/10;
			}
		}
		// System.out.println(sum);
		// 합계에 나머지 대입
		rest = sum%10;
		// System.out.println(rest);
		// 일치하면 사업자 번호가 맞음
		if(chk==10-rest) {
			return false;
		}
		br.rejectValue("campBusinessNum", null, "사업자 번호가 아닙니다");
		return true;
	}
}
