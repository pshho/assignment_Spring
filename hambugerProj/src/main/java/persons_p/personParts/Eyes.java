package persons_p.personParts;

import clothes_p.clothesParts.ClotheGlasses;

// 눈
public class Eyes {
	String name = "눈";
	ClotheGlasses cg; // 안경
	
	public Eyes() {
		super();
	}

	public Eyes(ClotheGlasses cg) {
		super();
		this.cg = cg;
	}

	@Override
	public String toString() {
		return "Eyes [name=" + name + ", cg=" + cg + "]\n";
	}
}
