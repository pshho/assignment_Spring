package persons_p.personParts;

import clothes_p.clothesParts.ClotheBodyTop;

// 상의
public class BodyTop {
	String name = "상의";
	ClotheBodyTop cbt; // 상의
	
	public BodyTop() {
		super();
	}

	public BodyTop(ClotheBodyTop cbt) {
		super();
		this.cbt = cbt;
	}

	@Override
	public String toString() {
		return "BodyTop [name=" + name + ", cbt=" + cbt + "]\n";
	}
}
