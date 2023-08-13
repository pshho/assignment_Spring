package bar.menu;

public class Alcohol {
	String kinds, name; // 종류, 명칭
	int price; // 가격
	
	public String getKinds() {
		return kinds;
	}
	public void setKinds(String kinds) {
		this.kinds = kinds;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "Alcohol [kinds=" + kinds + ", name=" + name + ", price=" + price + "]";
	}
}
