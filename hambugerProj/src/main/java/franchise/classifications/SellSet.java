package franchise.classifications;

import franchise.hamburgerMenu.BeverageMenu;
import franchise.hamburgerMenu.HamburgerMenu;
import franchise.hamburgerMenu.SideMenu;

public class SellSet {
	String name;
	HamburgerMenu hb;
	SideMenu su;
	BeverageMenu bm;
	int setPrice;
	
	public SellSet(String name, HamburgerMenu hb, SideMenu su, BeverageMenu bm, int setPrice) {
		this.name = name;
		this.hb = hb;
		this.su = su;
		this.bm = bm;
		this.setPrice = setPrice;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setHb(HamburgerMenu hb) {
		this.hb = hb;
	}
	public void setSu(SideMenu su) {
		this.su = su;
	}
	public void setBm(BeverageMenu bm) {
		this.bm = bm;
	}
	public void setSetPrice(int setPrice) {
		this.setPrice = setPrice;
	}
	public int getSetPrice() {
		return setPrice;
	}
	@Override
	public String toString() {
		return "SellSet [name=" + name + ", hb=" + hb + ", su=" + su + ", bm=" + bm + ", setPrice=" + setPrice + "]";
	}
}
