package clothes_p.clothesParts;

// 모자
public class ClotheHead extends Clothes {
	String kinds = "모자류";
	
	public ClotheHead() {
		super();
	}

	public ClotheHead(String place, String category, String name, int status) {
		super(place, category, name, status);
	}

	@Override
	public String toString() {
		return "ClotheHead [kinds=" + kinds + ", category=" + category + ", name=" + name + ", place=" + place
				+ ", status=" + status + "]";
	}
}
