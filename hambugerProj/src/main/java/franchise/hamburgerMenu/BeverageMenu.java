package franchise.hamburgerMenu;

public class BeverageMenu {
	String name, kind, driDis;
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
	public void setDriDis(String driDis) {
		this.driDis = driDis;
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
		return "BeverageMenu [name=" + name + ", kind=" + kind + ", driDis=" + driDis + ", price=" + price
				+ ", calorie=" + calorie + "]";
	}
}
