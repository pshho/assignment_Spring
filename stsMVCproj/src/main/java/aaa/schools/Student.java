package aaa.schools;

import java.util.Map;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Student {
	private String stdName, grade, classes; // 이름, 등급, 학급
	private Subjects subjects; // 과목들
	private int studentNum; // 학번
	private int classRank, sum, totalRank; // 학급 내 랭킹, 합계, 전체 학급 랭킹
	private float avg; // 평균
	
	public Student(String stdName, String classes, int studentNum, Subjects subjects) {
		this.stdName = stdName;
		this.classes = classes;
		this.studentNum = studentNum;
		this.subjects = subjects;
	}
	
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
			for(Map.Entry<String, Integer> sub : subjects.getSubScores().entrySet()) {
				sum += sub.getValue();
			}
		}
		
		return sum;
	}
	
	// 평균
	public float getAvg() {
		if(subjects != null) {
			int sum = getSum();
			avg = (float)sum / subjects.getSubScores().size();
		}
		return avg;
	}
}
