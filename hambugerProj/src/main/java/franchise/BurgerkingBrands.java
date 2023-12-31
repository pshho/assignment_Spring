package franchise;

import java.text.DecimalFormat;
import java.util.Arrays;

import franchise.classifications.SellSet;
import franchise.hamburgerMenu.BeverageMenu;
import franchise.hamburgerMenu.HamburgerMenu;
import franchise.hamburgerMenu.SideMenu;
import franchise.inter.InterBrand;

public class BurgerkingBrands implements InterBrand {
	String name = "BurgerKing";
	SellSet[] seDis;
	HamburgerMenu[] hb;
	SideMenu[] su;
	BeverageMenu[] bm;
	String[] orders;
	int[] count;
	int sum;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setSeDis(SellSet[] seDis) {
		this.seDis = seDis;
	}
	public void setHb(HamburgerMenu[] hb) {
		this.hb = hb;
	}
	public void setSu(SideMenu[] su) {
		this.su = su;
	}
	public void setBm(BeverageMenu[] bm) {
		this.bm = bm;
	}
	public void setOrders(String[] orders) {
		this.orders = orders;
	}
	public void setCount(int[] count) {
		this.count = count;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
	public String getSum() {
		String pattern = "#,###";
		DecimalFormat decN = new DecimalFormat(pattern);
		return decN.format(sum);
	}
	@Override
	public String toString() {
		return "BurgerkingBrands [name=" + name + ", seDis=" + Arrays.toString(seDis) + ", hb=" + Arrays.toString(hb)
				+ ", su=" + Arrays.toString(su) + ", bm=" + Arrays.toString(bm) + ", orders=" + Arrays.toString(orders)
				+ ", count=" + Arrays.toString(count) + ", sum=" + sum + "]";
	}
	@Override
	public void make() {
		for(String or : orders) {
			System.out.println(or+"을 맛있게 조리하고 있어요~\n잠시만 기다려주세요");
		}
	}
	@Override
	public void sell() {
		calc();
		String ord = String.join(" ", orders);
		System.out.println("OO고객님 주문하신 "+ord+" 나왔습니다\n총 "+getSum()+"원입니다\n맛있게 드시고 또 찾아주세요");
	}
	@Override
	public void calc() {
		for(int i=0; i<orders.length; i++) {
			for(int j=0; j<bm.length; j++) {
				if(orders[i].equals(bm[j].getName())) {
					sum += bm[j].getPrice() * count[i];
				}
			}
		}
		for(int i=0; i<orders.length; i++) {
			for(int j=0; j<su.length; j++) {
				if(orders[i].equals(su[j].getName())) {
					sum += su[j].getPrice() * count[i];
				}
			}
		}
		for(int i=0; i<orders.length; i++) {
			for(int j=0; j<hb.length; j++) {
				if(orders[i].equals(hb[j].getName())) {
					sum += hb[j].getPrice() * count[i];
				}
			}
		}
		for(int i=0; i<orders.length; i++) {
			for(int j=0; j<seDis.length; j++) {
				if(orders[i].equals(seDis[j].getName())) {
					sum += seDis[j].getSetPrice() * count[i];
				}
			}
		}
	}
}
