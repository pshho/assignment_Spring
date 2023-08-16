package persons_p.personParts;

import clothes_p.clothesParts.ClotheHead;

// 머리
public class Head {
	String name = "머리";
	ClotheHead ch; // 모자
	
	public Head() {
		super();
	}

	public Head(ClotheHead ch) {
		super();
		this.ch = ch;
	}

	@Override
	public String toString() {
		return "Head [name=" + name + ", ch=" + ch + "]\n";
	}
}
