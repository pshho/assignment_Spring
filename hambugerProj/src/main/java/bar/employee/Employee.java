package bar.employee;

import java.util.List;
import java.util.Map;

import bar.menu.Alcohol;
import bar.menu.DrinkDish;
import bar.store.Table;
import jakarta.annotation.Resource;

public class Employee {
	String name; // 직원 이름
	@Resource
	List<Table> table; // xml에서 bean 생성시 생성된 table을 가져올 멤버 변수
	@Resource
	List<Alcohol> alc; // 알콜 메뉴 클래스를 받아와 가격을 찾기 위한 리스트
	@Resource
	List<DrinkDish> dish; // 안주 메뉴 클래스를 받아와 가격을 찾기 위한 리스트
	List<Map<String, List<Map<String, Integer>>>> orders; // 받은 주문 내역

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Map<String, List<Map<String, Integer>>>> getOrders() {
		return orders;
	}
	
	// orders 데이터가 resource 됐을 때 테이블의 전체 주문 가격과 주문 내역을 입력하는 order set method
	@Resource
	public void setOrders(List<Map<String, List<Map<String, Integer>>>> orders) {
		this.orders = orders;
		
		// 받아온 주문 내역을 테이블의 주문 내역 리스트에 추가(기존 주문 유지)
		// 테이블의 합산 가격을 기존 합산 가격에 추가
		if(orders != null) {
			for(Map<String, List<Map<String, Integer>>> ord : orders) {
				for(int i=0; i<orders.size(); i++) {
					if(ord.keySet().contains(table.get(i).getTableName())) {
						table.get(i).getOrders().add(ord);
					}
					// table.get(i).setTableSum(table.get(i).getTableSum() + calc(orders));
				}
			}
			calc(orders);
		}
	}
	@Override
	public String toString() {
		return "Employee [name=" + name + "]";
	}
	
	// 메뉴 계산 method(한 테이블의 전체 주문 내역에 대한 합산 가격)
	public void calc(List<Map<String, List<Map<String, Integer>>>> orders) {
		
		if(orders != null) {
			// 주문 리스트에서 기존의 메뉴(술, 안주) 리스트의 이름과 일치한 것만 가격을 추출하여
			// 주문 수량에 맞춰 계산
			for(Map<String, List<Map<String, Integer>>> abc : orders) {
				for(int i=0; i<orders.size(); i++) {
					int sum = 0;
					if(abc.keySet().contains(table.get(i).getTableName())) {
						// 각 테이블의 주문 내역 Map 불러와서 각 주문별 가격 계산
						for(Map<String, Integer> or : abc.get(table.get(i).getTableName())) {
							// 술 메뉴 가격 찾기
							for(Alcohol ac : alc) {
								if(or.keySet().contains(ac.getName())) {
									sum += ac.getPrice() * Integer.parseInt(or.get(ac.getName())+"");
								}
							}
							
							// 안주 메뉴 가격 찾기
							for(DrinkDish ds : dish) {
								if(or.keySet().contains(ds.getName())) {
									sum += ds.getPrice() * Integer.parseInt(or.get(ds.getName())+"");
								}
							}
						}
					}
					// 한 번의 주문에 대한 합산 가격
					table.get(i).setTableSum(table.get(i).getTableSum() + sum);
				}
			}			
		}
	}
}
