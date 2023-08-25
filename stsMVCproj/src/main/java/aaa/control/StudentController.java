package aaa.control;

import java.util.TreeMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import aaa.schools.StdList;
import aaa.schools.Student;
import aaa.schools.StudentsList;
import aaa.schools.Subjects;
import aaa.studentsMenu.HeaderMenu;
import aaa.studentsMenu.SideMenu;
import aaa.studentsModel.ClassesStudent;
import jakarta.annotation.Resource;

@Controller
@RequestMapping("students/templates")
public class StudentController {
	@Resource
	StudentsList stdList; // 전체 학생 리스트
	
	@Resource
	ClassesStudent claStd; // 반별 정렬된 학생 리스트(등수, 이름, 전체 등수)
	
	@Resource
	HeaderMenu header; // header 메뉴
	
	@Resource
	SideMenu sider; // side 메뉴
	
//	@Resource
//	StudentsData stdD;
	
	@Resource(name = "sub1")
	Subjects subjs; // 메뉴에 보여줄 과목들
	
	// header model
	@ModelAttribute("stdHeader")
	Object stdHeader() {
//		ArrayList<HeaderMenu> arrayHeader = new ArrayList<>();
//		arrayHeader.add(new HeaderMenu("1반", "1반")); // DB에서 가져온 반별 학생 점수라고 가정
//		arrayHeader.add(new HeaderMenu("2반", "2반"));
//		arrayHeader.add(new HeaderMenu("3반", "3반"));
//		arrayHeader.add(new HeaderMenu("modify", "점수수정")); // DB 수정을 위한 Form이라 가정
		
		return header.getHeadUrl();
	}
	
	// side model
	@ModelAttribute("stdSide")
	Object stdSide() {
		// 정렬
//		ArrayList<HeaderMenu> arraySide = new ArrayList<>();
//		arraySide.add(new HeaderMenu("nm", "이름별"));
//		arraySide.add(new HeaderMenu("rk", "반별 등수"));
//		arraySide.add(new HeaderMenu("tRk", "전체 등수"));
		
		return sider.getSideUrl();
	}
	
//	@ModelAttribute("stdMainBackUp")
//	Object stdMainBackUp(
//			Model md,
//			HttpSession session,
//			@RequestParam(value = "head", defaultValue = "") String head,
//			@RequestParam(value = "side", defaultValue = "") String side,
//			@RequestParam(value = "header", defaultValue = "1반") String header
//			) {
//		System.out.println(stdD);
//		md.addAttribute("head", head);
//		md.addAttribute("header", header);
//		TreeMap<String, Student> stdsData = null; // 학생 데이터
//		String[] subjects = "국어,사회,과학,수학,영어".split(","); // 과목 데이터 테이블 위 과목 제목
//		
//		if(!head.equals("") && !head.equals("modify") && !side.equals("tRk")) {
//			session.setAttribute("head", head);
//			stdsData = stdD.getStudentsData(head);
//			
//			if(!side.equals("") && !side.equals("tRk")) {
//				session.setAttribute("side", side);
//				stdD.rankDistinct(side);
//				stdsData = stdD.getStudentsData(head);
//			}
//		}
//		
//		if(side.equals("tRk")) {
//			stdD.totalRankDistinct(side);
//			stdsData = stdD.getStudentsData().get("전체");
//		}
//		
//		if(head.equals("modify")) {
//			session.setAttribute("head", head);
//			stdsData = stdD.getStudentsData(header);
//		}
//		
//		md.addAttribute("subjects", subjects);
//		return null;
//	}
	
	// 과목 model
	@ModelAttribute("subjs")
	Object subjs() {
		return subjs.getSubScores();
	}
	
	// main model
	@ModelAttribute("stdMain")
	Object stdMain(
			Model md,
			@PathVariable String head, @PathVariable(required = false) String side,
			@RequestParam(value = "header", defaultValue = "1반") String header
		) {
		md.addAttribute("header", header);
		
		TreeMap<String, Student> std = null;
		// System.out.println(head + ", " + side + ", " + header);
		
		if(head.equals("modify")) {
			std = claStd.getRankStd(header, "rk");
			// System.out.println(std);
		}else {
			std = claStd.getRankStd(head, side);
		}
		
		return std;
	}
	
//	@ModelAttribute("stdFooter")
//	Object stdFooter() {
//		return "나는야 푸터";
//	}
	
	@RequestMapping("{head}")
	String templates2() {
		// System.out.println(stdD);
		// md.addAttribute("list", list);
		// md.addAttribute("claStd", claStd.getRankStd(head, side));
		// System.out.println(claStd);
		// System.out.println(header);
		// System.out.println(sider);
		return "students/templates";
	}

	@RequestMapping("{head}/{side}")
	String templates() {
		// System.out.println(stdD);
		// md.addAttribute("list", list);
		// md.addAttribute("claStd", claStd.getRankStd(head, side));
		// System.out.println(claStd);
		// System.out.println(header);
		// System.out.println(sider);
		return "students/templates";
	}
	
	// 데이터 받아와서 수정할 Method
	@PostMapping("{head}")
	String templatesReg(StdList studentsList) {
		// System.out.println(studentsList);
		return "students/templates";
	}
	
}
