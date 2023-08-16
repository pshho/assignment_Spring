package clothes_p.clothesParts;

// 신발
public class ClotheFoots extends Clothes {
	String kinds = "신발류";

	public ClotheFoots() {
		super();
	}

	public ClotheFoots(String place, String category, String name, int status) {
		super(place, category, name, status);
	}

	@Override
	public String toString() {
		return "ClotheFoots [kinds=" + kinds + ", category=" + category + ", name=" + name + ", place=" + place
				+ ", status=" + status + "]";
	}
}
