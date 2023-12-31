package test;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import franchise.BurgerkingBrands;

public class HTEST {
	public static void main(String[] args) {
		AbstractApplicationContext context =
				new ClassPathXmlApplicationContext("di_xml/burger.xml");
		
		String[] arr = "bg1,bg2".split(",");
		
		for(String ar : arr) {
			BurgerkingBrands bkg = (BurgerkingBrands)context.getBean(ar);
			System.out.println(bkg);
			bkg.make();
			bkg.sell();
		}
	}
}
