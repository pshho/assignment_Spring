package aaa.model;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Alias("rDto")
@Data
public class ReplyDTO {
	int repid, seq, lev, gid, gpid;
	String content, reWriter;
	Date reRegDate;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd (E) HH:mm");
	
	public String getReRegDate2() {
		return sdf.format(reRegDate);
	}
}
