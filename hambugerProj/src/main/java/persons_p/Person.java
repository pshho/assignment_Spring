package persons_p;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
import persons_p.personParts.BodyBottom;
import persons_p.personParts.BodyTop;
import persons_p.personParts.Eyes;
import persons_p.personParts.Foots;
import persons_p.personParts.Hands;
import persons_p.personParts.Head;

// 사람은 각각 머리, 몸, 손, 발 구성요소를 하나씩 가지기 때문에 component로 구성
@Component
public class Person {
	@Autowired
	Head head; // 머리
	@Autowired
	Eyes eyes; // 눈
	@Autowired
	BodyTop bodyTop; // 상의
	@Resource
	BodyBottom bodyBottom; // 하의
	@Autowired
	Hands hands; // 손
	@Resource
	Foots foots; // 발

	@Override
	public String toString() {
		return "Person [" + head + ", " + eyes + ", " + bodyTop + ", " + bodyBottom
				+ ", " + hands + ", " + foots + "]";
	}
}
