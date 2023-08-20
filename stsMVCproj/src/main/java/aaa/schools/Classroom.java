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
			String name = students.getStdName();
			String name2 = o.getStudents().getStdName();
			// 두 이름 중 가장 길이가 낮은 것 하나 선택
			int len = (name.length() < name2.length()) ? name.length() : name2.length();
			
			// 정해진 길이에 만큼 돌면서 각각 이름 앞글자씩부터 비교
			for(int i=0; i<len; i++) {
				if(i==len-1) { // 제일 마지막 글자에서는 continue할 수 없으므로 그냥 비교
					if(name.charAt(i) < name2.charAt(i)) {
						return -1;
					}else if(name.charAt(i) > name2.charAt(i)) {
						return 1;
					}else {
						return 1;
					}
				}
				
				if(name.charAt(i) < name2.charAt(i)) {
					return -1;
				}else if(name.charAt(i) > name2.charAt(i)) {
					return 1;
				}else { // 만약 이름 글자가 같으면 다음 글자 비교
					continue;
				}
			}
			
			// System.out.println(na + ", " + na2);
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
				}else {
					return 1;
				}
			}else { // 같은 학급이 아니면 1반 ~ 3반 순서대로 정렬
				// System.out.println("해당?");
				if(cl < cl2) {
					return -1;
				}else if(cl > cl2) {
					return 1;
				}else {
					return 1;
				}
			}
		}
		
		return 0;
	}
}
