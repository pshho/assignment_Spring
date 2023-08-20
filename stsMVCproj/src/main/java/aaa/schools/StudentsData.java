package aaa.schools;

import java.util.List;

import lombok.Data;

@Data
public class StudentsData {
	// 학급 클래스 리스트
	// 학급 - 학생
	private List<Classroom> stdData;
 	
	// 랭킹 계산 Method
	// 학급 내 랭킹과 전체 학급에서의 랭킹을 동시에 구함
	public void rankCalc(StudentsData stdsData) {
		for(Classroom stds : stdsData.getStdData()) {
			int rank = 1;
			int tRank = 1;
			for(Classroom std : stdsData.getStdData()) {
				// 전체 학급에서의 랭킹
				if(stds.getStudents().getAvg() < std.getStudents().getAvg()) {
					tRank++;
				}
				// 같은 학급일 때 랭킹
				if(stds.getClasses().equals(std.getClasses())) {
					if(stds.getStudents().getAvg() < std.getStudents().getAvg()) {
						rank++;
					}
				}
			}
			// 랭킹 저장
			stds.getStudents().setClassRank(rank);
			stds.getStudents().setTotalRank(tRank);
		}
	}
}
