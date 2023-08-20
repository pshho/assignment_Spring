package aaa.schools;

import java.util.Map;

import lombok.Data;

@Data
public class Subjects {
	private Map<String, String> scores; // 과목 이름, 점수
}
