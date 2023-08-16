package persons_p.main;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ClotheMainXml {
	public static void main(String[] args) {
		AbstractApplicationContext context =
				new ClassPathXmlApplicationContext("anno_xml/clotheComponent.xml");
		
		System.out.println(context.getBean("person"));
		
		context.close();
	}
}
