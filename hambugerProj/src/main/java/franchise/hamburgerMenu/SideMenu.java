package franchise.hamburgerMenu;

public class SideMenu {
	String name, kind;
	int price, calorie;
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setKind(String kind) {
		this.kind = kind;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPrice() {
		return price;
	}
	public void setCalorie(int calorie) {
		this.calorie = calorie;
	}
	@Override
	public String toString() {
		return "SideMenu [name=" + name + ", kind=" + kind + ", price=" + price + ", calorie=" + calorie + "]";
	}
}
