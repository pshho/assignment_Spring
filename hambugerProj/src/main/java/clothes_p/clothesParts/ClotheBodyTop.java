package clothes_p.clothesParts;

// 상의
public class ClotheBodyTop extends Clothes {
	String kinds = "상의류";

	public ClotheBodyTop() {
		super();
	}

	public ClotheBodyTop(String place, String category, String name, int status) {
		super(place, category, name, status);
	}

	@Override
	public String toString() {
		return "ClotheBodyTop [kinds=" + kinds + ", category=" + category + ", name=" + name + ", place=" + place
				+ ", status=" + status + "]";
	}
}
