package aaa.schools;

import lombok.Data;

@Data
public class Classroom implements Comparable<Classroom> {
	private String classes, stdDis; // 학급, 정렬 선택자
	private Student students; // 학생
	
	// 분류에 따라 다른 정렬 compareTo
	@Override
	public int compareTo(Classroom o) {
		String ptn = "[A-Za-z가-힣]+";
		int na = Integer.parseInt(students.getStdName().replaceAll(ptn, "")); // 이름에서 숫자만 추출
		int na2 = Integer.parseInt(o.getStudents().getStdName().replaceAll(ptn, "")); // 이름에서 숫자만 추출
		int cl = Integer.parseInt(classes.replaceAll(ptn, "")); // 학급명에서 숫자만 추출
		int cl2 = Integer.parseInt(o.getClasses().replaceAll(ptn, "")); // 학급명에서 숫자만 추출
		
		if(stdDis.equals("전체 학급 등수")) { // 전체 학급의 모든 학생 랭킹
			if(students.getTotalRank() < o.getStudents().getTotalRank()) {
				return -1;
			}else if(students.getTotalRank() > o.getStudents().getTotalRank()) {
				return 1;
			}else {
				return 1;
			}			
		}else if(stdDis.equals("학급별")) { // 1반부터 ~ 3반 순서대로
			if(cl < cl2) {
				return -1;
			}else if(cl > cl2) {
				return 1;
			}else if(cl == cl2) {
				return 1;
			}
		}else if(stdDis.equals("이름별")) { // 학생1 ~ 학생30
			if(na < na2) {
				return -1;
			}else if(na > na2) {
				return 1;
			}else {
				return 1;
			}
		}else if(stdDis.equals("학급 내 등수")) { // 같은 학급 내 랭킹
			if(classes.equals(o.getClasses())) { // 같은 학급일 때 랭킹 비교
//				System.out.println(classes);
//				System.out.println(o.getClasses());
//				System.out.println("같은 학급");
				if(students.getClassRank() < o.getStudents().getClassRank()) {
					// System.out.println("내가 더 작음");
					return -1;
				}else if(students.getClassRank() > o.getStudents().getClassRank()) {
					// System.out.println("내가 더 큼");
					return 1;
				}else if(students.getClassRank() == o.getStudents().getClassRank()) {
					return 1;
				}
			}else { // 같은 학급이 아니면 1반 ~ 3반 순서대로 정렬
				// System.out.println("해당?");
				if(cl < cl2) {
					return -1;
				}else if(cl > cl2) {
					return 1;
				}else if(cl == cl2) {
					return 1;
				}
			}
		}
		
		return 0;
	}
}
