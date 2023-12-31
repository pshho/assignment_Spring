package bar.store;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Table {
	String tableName; // 가게의 몇 번 테이블
	int tableSum; // 그 테이블의 전체 가격
	List<Map<String, List<Map<String, Integer>>>> orders = new ArrayList<>(); // 주문한 술과 안주

	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public int getTableSum() {
		return tableSum;
	}
	public void setTableSum(int tableSum) {
		this.tableSum = tableSum;
	}
	public List<Map<String, List<Map<String, Integer>>>> getOrders() {
		return orders;
	}
	@Override
	public String toString() {
		return "Table [tableName=" + tableName + ", 합산 가격=" + tableSum + ", orders=" + orders + "]\n";
	}
}
