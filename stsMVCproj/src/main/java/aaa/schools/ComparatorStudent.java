package aaa.schools;

import java.util.Comparator;

public class ComparatorStudent implements Comparator<String> {
	// 데이터 정렬을 위한 Comparator
	public ComparatorStudent() {
		super();
	}

	@Override
	public int compare(String o1, String o2) {
		int com = Integer.compare(Integer.parseInt(o1), Integer.parseInt(o2));
		
		if(com == 0) {
			com = 1;
		}
		
		return com;
	}
}
