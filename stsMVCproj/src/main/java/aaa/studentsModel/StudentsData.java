package aaa.studentsModel;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

import org.springframework.stereotype.Component;

import aaa.schools.Student;
import aaa.schools.Subjects;
import lombok.Data;

@Component
@Data
public class StudentsData {
	// key1 - 반, value(key2 - 학생 번호, value - 학생)
	private Map<String, TreeMap<String, Student>> studentsData;
	private Map<String, TreeMap<String, Student>> classRank;
	
	public StudentsData() {
		studentsData = new TreeMap<>();

	}

	public TreeMap<String, Student> getStudentsData(String head) {
		return studentsData.get(head);
	}
	
	// 랭킹 계산 Method
	// 학급 내 랭킹
	public void rankCalc(String head) {
		for(Map.Entry<String, Student> stds : studentsData.get(head).entrySet()) {
			int rank = 1;
			for(Map.Entry<String, Student> std : studentsData.get(head).entrySet()) {
				if(stds.getValue().getAvg() < std.getValue().getAvg()) {
					rank++;
				}
			}
			stds.getValue().setClassRank(rank); // 등수 삽입
		}
	}
	
	public void totalRankCalc() {
		for(int i=0; i<15; i++) {
			int rank = 1;
			int trank = 1;
			String ban = ((i/5)+1)+"반"; // 반에 대한 key
			String bun = ((i+1)%5)+"번"; // 학생 번호에 대한 key
			float avg = 0;
			if((i+1)%5 == 0) {
				bun = "5번";
				avg = studentsData.get(ban).get(bun).getAvg(); // 1반부터 가져온 학생의 avg
			}else {
				avg = studentsData.get(ban).get(bun).getAvg();
			}
			// System.out.println(avg);
			// 다시 1반의 1번 학생부터 3반의 5번학생까지 비교할 for문
			for(int j=0; j<15; j++) {
				String ban2 = ((j/5)+1)+"반";
				String bun2 = ((j+1)%5)+"번";
				float avg2 = 0;
				// System.out.println(ban2 + ", " + bun2);
				// System.out.println(avg2);
				if((j+1)%5 == 0) {
					bun2 = "5번";
					avg2 = studentsData.get(ban2).get(bun2).getAvg();
				}else {
					avg2 = studentsData.get(ban2).get(bun2).getAvg();
				}
				if(avg < avg2) {
					trank++;
				}
				
				if(ban.equals(ban2)) {
					if(avg < avg2) {
						rank++;
					}
				}
			}
			studentsData.get(ban).get(bun).setClassRank(rank);
			studentsData.get(ban).get(bun).setTotalRank(trank); // 등수 삽입
		}
	}
	
	public void rankDistinct(String side) {
			
			classRank = new TreeMap<>();

			for (Entry<String, TreeMap<String, Student>> stds : studentsData.entrySet()) {
			    TreeMap<String, Student> std = stds.getValue();
			    TreeMap<String, Student> rankStd = new TreeMap<>();
			
			    for (Entry<String, Student> sd : std.entrySet()) {
			        Student student = sd.getValue();
			        if (side.equals("rk")) {
			        	rankStd.put(student.getClassRank()+"", student);
			        }else if(side.equals("nm")) {
			        	rankStd.put(student.getStdName(), student);
			        }
			        // System.out.println(rankStd);
			    }
			    classRank.put(stds.getKey(), rankStd);
			}
			studentsData.clear();
			studentsData.putAll(classRank);
			
	}
	
	public void totalRankDistinct(String side) {
		TreeMap<String, Student> rankStd = new TreeMap<>();
		
		for(int i=0; i<15; i++) {
			String ban = ((i/5)+1)+"반"; // 반에 대한 key
			String bun = ((i+1)%5)+"번"; // 학생 번호에 대한 key
			
			Student student = null;
			
			if((i+1)%5 == 0) {
				bun = "5번";
				student = studentsData.get(ban).get(bun);
			}else {
				student = studentsData.get(ban).get(bun);
			}
			
			if (side.equals("tRk")) {
	        	rankStd.put(student.getTotalRank()+"", student);
	        }
		}
		
		studentsData.clear();
		studentsData.put("전체", rankStd);
		
	}
}

