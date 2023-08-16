package persons_p.personParts;

import clothes_p.clothesParts.ClotheAccesory;

// 손
public class Hands {
	String name = "손";
	ClotheAccesory clac; // 액세서리
	
	public Hands() {
		super();
	}

	public Hands(ClotheAccesory clac) {
		super();
		this.clac = clac;
	}

	@Override
	public String toString() {
		return "Hands [name=" + name + ", clac=" + clac + "]\n";
	}
}
