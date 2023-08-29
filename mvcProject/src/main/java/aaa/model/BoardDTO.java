package aaa.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Alias("bDto")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardDTO {
	int pid, cnt, seq, lev, rid;
	String title, writer, pw, upfile, content;
	Date regDate;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd (E) HH:mm");
	MultipartFile mf;
	
	public String getRegDate2() {
		return sdf.format(regDate);
	}

	public String getUpfile() {
		if(upfile == null || upfile.trim().equals("") || upfile.trim().equals("null")) {
			upfile = "";
		}
		
		return upfile;
	}
	
	public boolean getIsImg() {
		boolean imgCheck = Pattern.matches(".*[.](jpg|bmp|png|gif)$",
				upfile.toLowerCase()); 
		return imgCheck;
	}
}
