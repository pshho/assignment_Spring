package clothes_p.clothesParts;

// 안경
public class ClotheGlasses extends Clothes {
	String kinds = "안경";

	public ClotheGlasses() {
		super();
	}

	public ClotheGlasses(String place, String category, String name, int status) {
		super(place, category, name, status);
	}

	@Override
	public String toString() {
		return "ClotheGlasses [kinds=" + kinds + ", category=" + category + ", name=" + name + ", place=" + place
				+ ", status=" + status + "]";
	}
}
