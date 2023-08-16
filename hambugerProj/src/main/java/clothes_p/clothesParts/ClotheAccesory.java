package clothes_p.clothesParts;

// 액세서리
public class ClotheAccesory extends Clothes {
	String kinds = "액세서리류";

	public ClotheAccesory() {
		super();
	}

	public ClotheAccesory(String place, String category, String name, int status) {
		super(place, category, name, status);
	}

	@Override
	public String toString() {
		return "ClotheAccesory [kinds=" + kinds + ", category=" + category + ", name=" + name + ", place=" + place
				+ ", status=" + status + "]";
	}

}
