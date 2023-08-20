package aaa.schools;

import java.util.Map;

import lombok.Data;

@Data
public class Student {
	private String stdName, grade; // 이름, 등급
	private Subjects subjects; // 과목들
	private int classRank, sum, totalRank; // 학급 내 랭킹, 합계, 전체 학급 랭킹
	private float avg; // 평균
	
	// 등급
	public String getGrade() {
		if(avg != 0) {
			char[] grades = "99876543211".toCharArray();
			grade = grades[(int)avg/10]+"등급";
		}
		return grade;
	}
	
	// 합계
	public int getSum() {
		sum = 0;
		
		if(subjects != null) {
			for(Map.Entry<String, String> sub : subjects.getScores().entrySet()) {
				sum += Integer.parseInt(sub.getValue());
			}
		}
		
		return sum;
	}
	
	// 평균
	public float getAvg() {
		if(subjects != null) {
			int sum = getSum();
			avg = (float)sum / subjects.getScores().size();
		}
		return avg;
	}
}
