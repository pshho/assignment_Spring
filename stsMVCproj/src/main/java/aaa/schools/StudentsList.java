package aaa.schools;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class StudentsList {
	@Autowired
	List<Student> studentsList;
	
	public List<Student> getStudentsList() {
		totalRankCalc();
		return studentsList;
	}
	
	public void totalRankCalc() {
		for(Student stds : studentsList) {
			int rank = 1;
			int trank = 1;
			float avg = stds.getAvg();	// 비교할 학생의 평균
			String ban = stds.getClasses();	// 같은 반인지 확인
			for(Student std : studentsList) {
				float avg2 = std.getAvg();	// 비교할 학생의 평균
				String ban2 = std.getClasses(); // 같은 반인지 확인
				if(avg < avg2) {
					trank++;
				}
				
				if(ban.equals(ban2)) {
					if(avg < avg2) {
						rank++;
					}
				}
			}
			stds.setClassRank(rank);
			stds.setTotalRank(trank); // 등수 삽입
		}
	}
}
