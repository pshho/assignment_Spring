package aaa.control;

import java.util.Arrays;
import java.util.Random;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("schools/scoreIn")
public class ScoreController {
	// 과목 리스트
	String[] subjects = "국어,영어,수학,사회,과학,한국사,체육".split(",");
	// 과목 개수 선택
	String[] subj = "전체,국영수,국영수사과,국영수사과한체".split(",");
	// 반 리스트
	String[] classrooms = "1반,2반,3반".split(",");
	Random rd = new Random();
	
	@GetMapping
	String score(Model mm) {
		System.out.println("scoreGet");
		// 과목 개수 선택자 attribute
		mm.addAttribute("subjs", subj);
		return "schools/scoreIn";
	}
	
	@PostMapping
	String scores(Model mm, 
			@ModelAttribute("nums") int nums,
			@ModelAttribute("subject") String subject) {
		System.out.println("scorePost");
		
		// System.out.println(nums);
		
		// 인원수와 과목 수에 따라 다른 랜덤 점수 배열
		if(nums != 0 && (subject != null && !subject.equals("전체") )) {
			int[][] arrRd = new int[nums][subject.length()];
			
			for(int i=0; i<arrRd.length; i++) {
				for(int j=0; j<arrRd[i].length; j++) {
					arrRd[i][j] = rd.nextInt(20, 101);
				}
			}
			mm.addAttribute("arrRd", arrRd);
//			for(int i=0; i<arrRd.length; i++) {
//				for(int j=0; j<arrRd[1].length; j++) {
//					System.out.print(arrRd[i][j]+" ");
//				}
//				System.out.println();
//			}
//			System.out.println(arrRd.length);
			
			// 랜덤으로 반배정
			int[] arrClass = new int[nums];
			for(int i=0; i<arrClass.length; i++) {
				arrClass[i] = rd.nextInt(0, 3);
			}
			// System.out.println(Arrays.toString(arrClass));
			mm.addAttribute("arrClass", arrClass);
		}
		
		
		// 과목수 선택에 따라 다르게 보낼 과목들
		if(!subject.equals("전체")) {	
			mm.addAttribute("subs", Arrays.copyOf(subjects, subject.length()));
		}
		// 과목 개수 선택자 attribute
		mm.addAttribute("subjs", subj);
		// 반 리스트
		mm.addAttribute("clsRoom", classrooms);
		return "schools/scoreIn";
	}
}
