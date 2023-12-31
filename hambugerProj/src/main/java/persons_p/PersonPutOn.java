package persons_p;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import clothes_p.clothesParts.ClotheAccesory;
import clothes_p.clothesParts.ClotheBodyBottom;
import clothes_p.clothesParts.ClotheBodyTop;
import clothes_p.clothesParts.ClotheFoots;
import clothes_p.clothesParts.ClotheGlasses;
import clothes_p.clothesParts.ClotheHead;
import persons_p.personParts.BodyBottom;
import persons_p.personParts.BodyTop;
import persons_p.personParts.Eyes;
import persons_p.personParts.Foots;
import persons_p.personParts.Hands;
import persons_p.personParts.Head;

@Configuration
@ComponentScan("clothes_p")
public class PersonPutOn {
	
	// 가려는 개별 장소
	@Bean
	Place place() {
		return new Place("쇼핑가", "홍대");
	}

	// 신발 중 가려는 장소에 맞춰 바꿔 입음
	@Bean
	Foots shoes(ClotheFoots... selectShooes) {
		for(ClotheFoots shoe : selectShooes) {
			if(place().getPlace().equals(shoe.getPlace())) {
				return new Foots(shoe);
			}
		}
		return new Foots();
	}
	
	// 상의 중 가려는 장소에 맞춰 바꿔 입음
	@Bean
	BodyTop clothesT(ClotheBodyTop... selectCt) {
		for(ClotheBodyTop clthT : selectCt) {
			if(place().getPlace().equals(clthT.getPlace())) {
				return new BodyTop(clthT);
			}
		}
		return new BodyTop();
	}
	
	// 하의 중 가려는 장소에 맞춰 바꿔 입음
	@Bean
	BodyBottom clothesB(ClotheBodyBottom... selectCb) {
		for(ClotheBodyBottom clthB : selectCb) {
			if(place().getPlace().equals(clthB.getPlace())) {
				return new BodyBottom(clthB);
			}
		}
		return new BodyBottom();
	}
	
	// 액세서리 중 가려는 장소에 맞춰 바꿔 입음
	@Bean
	Hands accesory(ClotheAccesory... selectAcc) {
		for(ClotheAccesory acc : selectAcc) {
			if(place().getPlace().equals(acc.getPlace())) {
				return new Hands(acc);
			}
		}
		return new Hands();
	}
	
	// 모자 중 가려는 장소에 맞춰 바꿔 입음
	@Bean
	Head hat(ClotheHead... selectHat) {
		for(ClotheHead hat : selectHat) {
			if(place().getPlace().equals(hat.getPlace())) {
				return new Head(hat);
			}
		}
		return new Head();
	}
	
	// 안경 중 가려는 장소에 맞춰 바꿔 입음
	@Bean
	Eyes glas(ClotheGlasses... selectGlass) {
		for(ClotheGlasses glass : selectGlass) {
			if(place().getPlace().equals(glass.getPlace())) {
				return new Eyes(glass);
			}
		}
		return new Eyes();
	}
}
