package clothes_p.clothesParts;

public class Clothes {
	// 의류의 부위별로 가지는 요소들
	String category, name, place; // 장소에 따라 다른 의류
	int status; // 더러움, 깨끗함 등의 물건 상태
	
	public Clothes() {
		
	}
	public Clothes(String place, String category, String name, int status) {
		super();
		this.place = place;
		this.category = category;
		this.name = name;
		this.status = status;
	}
	
	public String getPlace() {
		return place;
	}
}
