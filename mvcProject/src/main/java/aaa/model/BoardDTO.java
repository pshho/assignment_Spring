package aaa.model;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Component
public class BoardDTO {
	int pid, cnt, seq, lev, rid;
	String title, writer, pw, upfile, content;
	Date reg_date;
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd (E) HH:mm");
	MultipartFile mf;
	
	public Date getReg_date() {
		return reg_date;
	}
	
	public String getReg_date2() {
		return sdf.format(reg_date);
	}

	public String getUpfile() {
		if(upfile == null || upfile.trim().equals("") || upfile.trim().equals("null")) {
			upfile = "";
		}
		
		return upfile;
	}
	
	public boolean getIsImg() {
		boolean imgCheck = Pattern.matches(".*\\.(jpg|bmp|png|gif)$", 
				upfile.toLowerCase()); 
		return imgCheck;
	}
}
