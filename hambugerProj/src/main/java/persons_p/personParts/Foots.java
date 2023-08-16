package persons_p.personParts;

import clothes_p.clothesParts.ClotheFoots;

// 발
public class Foots {
	String name = "발";
	ClotheFoots cfs; // 신발
	
	public Foots() {
		super();
	}

	public Foots(ClotheFoots cfs) {
		super();
		this.cfs = cfs;
	}

	@Override
	public String toString() {
		return "Foots [name=" + name + ", cfs=" + cfs + "]\n";
	}
}
