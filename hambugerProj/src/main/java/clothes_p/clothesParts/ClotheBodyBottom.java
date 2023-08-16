package clothes_p.clothesParts;

// 하의
public class ClotheBodyBottom extends Clothes {
	String kinds = "하의류";

	public ClotheBodyBottom() {
		super();
	}

	public ClotheBodyBottom(String place, String category, String name, int status) {
		super(place, category, name, status);
	}

	@Override
	public String toString() {
		return "ClotheBodyBottom [kinds=" + kinds + ", category=" + category + ", name=" + name + ", place=" + place
				+ ", status=" + status + "]";
	}
}
