package aaa.studentsModel;

import java.util.TreeMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import aaa.schools.ComparatorStudent;
import aaa.schools.Student;
import aaa.schools.StudentsList;
import lombok.Data;

@Component
@Data
public class ClassesStudent {
	TreeMap<String, Student> rankStd;
	
	@Autowired
	StudentsList stdList;
	
	public TreeMap<String, Student> getRankStd(String head, String side) {
		return rankDistinct(head, side);
	}

	public TreeMap<String, Student> rankDistinct(String head, String side) {
		// ComparatorStudent 사용에 의해 이름순 정렬을 위한 TreeMap
		TreeMap<String, Student> rankStds = new TreeMap<>();
		// 중복 제거를 막기 위한 comparator 재정의 클래스 생성
		rankStd = new TreeMap<>(new ComparatorStudent());

		for (Student stds : stdList.getStudentsList()) {
		
			if(head.equals(stds.getClasses())) {
				if(side == null) { // 기본값 정렬
					rankStd.put(stds.getStudentNum()+"", stds);
				}else if(side.equals("rk")) { // 반별 등수 정렬
					rankStd.put(stds.getClassRank()+"", stds);
				}else if(side.equals("nm")) { // 이름순 정렬
					rankStds.put(stds.getStdName(), stds);
				}
			}
			
			if(side != null && side.equals("tRk")) { // 전체 등수 정렬
				String formatNum = String.format("%03d", stds.getTotalRank());
				// System.out.println(stds);
				rankStd.put(formatNum, stds);
			}
		}
		
		if(side != null && side.equals("nm")) { // 이름순 정렬 따로 할당
			rankStd = rankStds;
		}
		
		return rankStd;
	}
}
