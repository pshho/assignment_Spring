package aaa.service;

import java.util.HashMap;
import java.util.TreeMap;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import aaa.schools.Student;
import aaa.schools.Subjects;
import aaa.studentsMenu.HeaderMenu;
import aaa.studentsMenu.SideMenu;

@Configuration
public class Config {
	@Bean
	Subjects sub1() {
		return new Subjects(new TreeMap<>() {{ 
			put("국어", 77); put("수학", 87); put("영어", 64);
			put("사회", 53);	put("과학", 98);
		}});
	}
	@Bean
	Subjects sub2() {
		return new Subjects(new TreeMap<>() {{ 
			put("국어", 37);	put("수학", 22);	put("영어", 78);
			put("사회", 66);	put("과학", 59);
		}});
	}
	@Bean
	Subjects sub3() {
		return new Subjects(new TreeMap<>() {{ 
			put("국어", 88);	put("수학", 92);	put("영어", 71);
			put("사회", 21);	put("과학", 33);
		}});
	}
	@Bean
	Subjects sub4() {
		return new Subjects(new TreeMap<>() {{ 
			put("국어", 99);	put("수학", 100);	put("영어", 82);
			put("사회", 83);	put("과학", 45);
		}});
	}
	@Bean
	Subjects sub5() {
		return new Subjects(new TreeMap<>() {{ 
			put("국어", 48);	put("수학", 67);	put("영어", 54);
			put("사회", 74);	put("과학", 38);
		}});
	}
	@Bean
	Subjects sub6() {
		return new Subjects(new TreeMap<>() {{ 
			put("국어", 97);	put("수학", 92);	put("영어", 73);
			put("사회", 69);	put("과학", 78);
		}});
	}
	@Bean
	Subjects sub7() {
		return new Subjects(new TreeMap<>() {{ 
			put("국어", 91);	put("수학", 26);	put("영어", 49);
			put("사회", 68);	put("과학", 70);
		}});
	}
	@Bean
	Subjects sub8() {
		return new Subjects(new TreeMap<>() {{ 
			put("국어", 100);	put("수학", 83);	put("영어", 91);
			put("사회", 9);	put("과학", 45);
		}});
	}
	@Bean
	Subjects sub9() {
		return new Subjects(new TreeMap<>() {{ 
			put("국어", 92);	put("수학", 74);	put("영어", 69);
			put("사회", 51);	put("과학", 77);
		}});
	}
	@Bean
	Subjects sub10() {
		return new Subjects(new TreeMap<>() {{ 
			put("국어", 38);	put("수학", 29);	put("영어", 49);
			put("사회", 78);	put("과학", 91);
		}});
	}
	@Bean
	Subjects sub11() {
		return new Subjects(new TreeMap<>() {{ 
			put("국어", 99);	put("수학", 100);	put("영어", 76);
			put("사회", 82);	put("과학", 79);
		}});
	}
	@Bean
	Subjects sub12() {
		return new Subjects(new TreeMap<>() {{ 
			put("국어", 22);	put("수학", 39);	put("영어", 67);
			put("사회", 98);	put("과학", 46);
		}});
	}
	@Bean
	Subjects sub13() {
		return new Subjects(new TreeMap<>() {{ 
			put("국어", 62);	put("수학", 73);	put("영어", 41);
			put("사회", 55);	put("과학", 98);
		}});
	}
	@Bean
	Subjects sub14() {
		return new Subjects(new TreeMap<>() {{ 
			put("국어", 40);	put("수학", 96);	put("영어", 82);
			put("사회", 83);	put("과학", 58);
		}});
	}
	@Bean
	Subjects sub15() {
		return new Subjects(new TreeMap<>() {{ 
			put("국어", 34);	put("수학", 44);	put("영어", 89);
			put("사회", 81);	put("과학", 75);
		}});
	}
	@Bean
	Student std1(Subjects sub1) {
		return new Student("민준", "1반", 1, sub1);
	}
	@Bean
	Student std2(Subjects sub2) {
		return new Student("서준", "1반", 2, sub2);
	}
	@Bean
	Student std3(Subjects sub3) {
		return new Student("도윤", "1반", 3, sub3);
	}
	@Bean
	Student std4(Subjects sub4) {
		return new Student("예준", "1반", 4, sub4);
	}
	@Bean
	Student std5(Subjects sub5) {
		return new Student("시우", "1반", 5, sub5);
	}
	@Bean
	Student std6(Subjects sub6) {
		return new Student("서연", "2반", 1, sub6);
	}
	@Bean
	Student std7(Subjects sub7) {
		return new Student("서윤", "2반", 2, sub7);
	}
	@Bean
	Student std8(Subjects sub8) {
		return new Student("지우", "2반", 3, sub8);
	}
	@Bean
	Student std9(Subjects sub9) {
		return new Student("서현", "2반", 4, sub9);
	}
	@Bean
	Student std10(Subjects sub10) {
		return new Student("하은", "2반", 5, sub10);
	}
	@Bean
	Student std11(Subjects sub11) {
		return new Student("하준", "3반", 1, sub11);
	}
	@Bean
	Student std12(Subjects sub12) {
		return new Student("주원", "3반", 2, sub12);
	}
	@Bean
	Student std13(Subjects sub13) {
		return new Student("지호", "3반", 3, sub13);
	}
	@Bean
	Student std14(Subjects sub14) {
		return new Student("지후", "3반", 4, sub14);
	}
	@Bean
	Student std15(Subjects sub15) {
		return new Student("준우", "3반", 5, sub15);
	}
	@Bean
	HeaderMenu header() {
		return new HeaderMenu(new TreeMap<>() {{ 
			put("1반", "1반"); put("2반", "2반");
			put("3반", "3반"); put("modify", "점수수정");
		}});
	}
	@Bean
	SideMenu sider() {
		return new SideMenu(new HashMap<>() {{ 
			put("nm", "이름별"); put("rk", "반별 등수");
			put("tRk", "전체 등수");
		}});
	}
}
