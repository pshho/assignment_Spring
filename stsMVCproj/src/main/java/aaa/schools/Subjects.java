package aaa.schools;

import java.util.Map;
import java.util.TreeMap;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Subjects {
	private Map<String, String> scores; // 과목 이름, 점수 - 지난 번 과제 과목
	private TreeMap<String, Integer> subScores; // 과목 이름, 점수 - @ModelAttribute를 이용한 과제 과목
	
	public Subjects(TreeMap<String, Integer> subScores) {
		super();
		this.subScores = subScores;
	}
}
