package persons_p.personParts;

import clothes_p.clothesParts.ClotheBodyBottom;

// 하의
public class BodyBottom {
	String name = "하의";
	ClotheBodyBottom cbb; // 하의
	
	public BodyBottom() {
		super();
	}

	public BodyBottom(ClotheBodyBottom cbb) {
		super();
		this.cbb = cbb;
	}

	@Override
	public String toString() {
		return "BodyBottom [name=" + name + ", cbb=" + cbb + "]\n";
	}
}
