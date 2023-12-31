package bar.store;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import bar.employee.Employee;

public class GangBar {
	String name; // 가게 이름
	int totalSell; // 가게 수입
	
	@Autowired(required = false)
	List<Table> tables; // 가게 테이블
	@Autowired(required = false)
	List<Employee> emps; // 직원
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTotalSell() {
		return totalSell;
	}
	public void setTotalSell(int totalSell) {
		this.totalSell = totalSell;
	}
	public List<Table> getTables() {
		return tables;
	}
	@Override
	public String toString() {
		return "GangBar [가게 이름=" + name + ", 현재 가게 수입=" + totalSell + ", \ntables=" + tables + ", 직원=" + emps + "]";
	}
}
