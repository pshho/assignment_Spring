package franchise.hamburgerMenu;

public class HamburgerMenu {
	String name, foodIngre, size;
	int price, calorie;
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setFoodIngre(String foodIngre) {
		this.foodIngre = foodIngre;
	}
	public void setSize(String size) {
		this.size = size;
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
		return "HamburgerMenu [name=" + name + ", foodIngre=" + foodIngre + ", size=" + size + ", price=" + price
				+ ", calorie=" + calorie + "]";
	}
}
