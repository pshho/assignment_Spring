package clothes_p;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import clothes_p.clothesParts.ClotheAccesory;
import clothes_p.clothesParts.ClotheBodyBottom;
import clothes_p.clothesParts.ClotheBodyTop;
import clothes_p.clothesParts.ClotheFoots;
import clothes_p.clothesParts.ClotheHead;
import clothes_p.clothesParts.ClotheGlasses;

// 의류들을 담는 가방
@Configuration
public class Bag {
	
	// 액세서리
	@Bean
	ClotheAccesory ring() {
		return new ClotheAccesory("결혼식장", "패션", "티파니노트 반지", 1);
	}
	
	@Bean
	ClotheAccesory climbGloves() {
		return new ClotheAccesory("지리산", "트레이닝", "등산장갑", 1);
	}
	
	@Bean
	ClotheAccesory skiGloves() {
		return new ClotheAccesory("스키장", "트레이닝", "스키장갑", 1);
	}
	
	// 하의
	@Bean
	ClotheBodyBottom formalUniformB() {
		return new ClotheBodyBottom("결혼식장", "예복", "정장 하의", 1);
	}
	
	@Bean
	ClotheBodyBottom casualUniformB() {
		return new ClotheBodyBottom("쇼핑가", "평상복", "슬랙스", 1);
	}
	
	@Bean
	ClotheBodyBottom swimUniformB() {
		return new ClotheBodyBottom("수영장", "트레이닝", "수영복 하의", 1);
	}
	
	@Bean
	ClotheBodyBottom climbUniformB() {
		return new ClotheBodyBottom("지리산", "트레이닝", "등산복 하의", 1);
	}
	
	@Bean
	ClotheBodyBottom skiUniformB() {
		return new ClotheBodyBottom("스키장", "트레이닝", "스키복 하의", 1);
	}
	
	// 상의
	@Bean
	ClotheBodyTop formalUniformT() {
		return new ClotheBodyTop("결혼식장", "예복", "정장 상의", 1);
	}
	
	@Bean
	ClotheBodyTop climbUniformT() {
		return new ClotheBodyTop("지리산", "트레이닝", "등산복 상의", 1);
	}
	
	@Bean
	ClotheBodyTop skiUniformT() {
		return new ClotheBodyTop("스키장", "트레이닝", "스키복 상의", 1);
	}
	
	@Bean
	ClotheBodyTop casualUniformT() {
		return new ClotheBodyTop("쇼핑가", "평상복", "셔츠", 1);
	}
	
	// 신발
	@Bean
	ClotheFoots nepaShoes() {
		return new ClotheFoots("지리산", "트레이닝", "등산화", 1);
	}
	
	@Bean
	ClotheFoots adidasShoes() {
		return new ClotheFoots("스키장", "트레이닝", "스키화", 1);
	}
	
	@Bean
	ClotheFoots bootsShoes() {
		return new ClotheFoots("결혼식장", "예화", "구두", 1);
	}
	
	@Bean
	ClotheFoots casualShoes() {
		return new ClotheFoots("쇼핑가", "캐쥬얼화", "크로커다일", 1);
	}
	
	// 모자
	@Bean
	ClotheHead swimHat() {
		return new ClotheHead("수영장", "트레이닝", "수영모", 1);
	}
	
	@Bean
	ClotheHead skiHat() {
		return new ClotheHead("스키장", "트레이닝", "스키모", 1);
	}
	
	@Bean
	ClotheHead climbHat() {
		return new ClotheHead("지리산", "트레이닝", "등산모", 1);
	}
	
	// 안경
	@Bean
	ClotheGlasses gucciCg() {
		return new ClotheGlasses("결혼식장", "패션", "구찌", 1);
	}
	
	@Bean
	ClotheGlasses swimCg() {
		return new ClotheGlasses("수영장", "트레이닝", "수영고글", 1);
	}
	
	@Bean
	ClotheGlasses skiCg() {
		return new ClotheGlasses("스키장", "트레이닝", "스키고글", 1);
	}
}
