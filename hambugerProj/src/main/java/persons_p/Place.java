package persons_p;

// 장소
public class Place {
	String place, address;

	
	public Place() {
		super();
	}

	public Place(String place, String address) {
		super();
		this.place = place;
		this.address = address;
	}

	public String getPlace() {
		return place;
	}

	@Override
	public String toString() {
		return "Place [place=" + place + ", address=" + address + "]";
	}
}
