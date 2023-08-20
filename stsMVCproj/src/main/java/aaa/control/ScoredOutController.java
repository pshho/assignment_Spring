package aaa.control;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import aaa.schools.Classroom;
import aaa.schools.StudentsData;

@Controller
@RequestMapping("schools/")
public class ScoredOutController {
	// 분류 선택
	String[] stdDisGr = "분류,이름별,학급별,학급 내 등수,전체 학급 등수".split(",");
	
	@RequestMapping("scoredOut")
	String scoredOut(Model mm,
			@ModelAttribute("stdDis") String stdDis,
			StudentsData sdD) {
		System.out.println("scoredOut");
		// 모든 데이터 Set된 후 학급 내 등수, 전체 등수 계산
		sdD.rankCalc(sdD);
		// System.out.println(sdD);
		// System.out.println(sdD.getStdData().size());
		
//		int count = 0;
//		for(Classroom ar : sdD.getStdData()) {
//			if(ar.getClasses().containsKey("3반")) {
//				count++;
//			}
//		}
//		System.out.println(count);
		
		// 학급 내 등수, 전체 등수, 이름별 정렬
		TreeSet<Classroom> stds = new TreeSet<Classroom>();
		// hmtl의 출력방식과 데이터 받는 방식을 그대로 하기 위해 데이터를 다시 저장해서 보냄
		// 정렬된 리스트를 다시 담을 데이터 클래스
		StudentsData sdD2 = new StudentsData();
		// TreeSet으로 정렬한 데이터를 다시 담을 리스트
		List<Classroom> stdList = new ArrayList<>();
		
		// 선택된 정렬 분류에 따라 달라지는 데이터 정렬
		if(stdDis.equals("분류") || stdDis.equals("")) {
			mm.addAttribute("sdD", sdD);
		}else {
			// System.out.println("내가 걸림");
			// TreeSet 사용
			for(Classroom sdd : sdD.getStdData()) {
				sdd.setStdDis(stdDis);
				stds.add(sdd);
			}
			
			// TreeSet 데이터 다시 리스트화
			for(Classroom sd : stds) {
				stdList.add(sd);
			}
			sdD2.setStdData(stdList);
			
			// 재정렬된 StudentsData를 보냄
			// html의 출력 코드를 수정하지 않기 위한 방법
			mm.addAttribute("sdD", sdD2);
		}
		
		mm.addAttribute("stdDisGr", stdDisGr);
		return "schools/scoredOut";
	}
}
