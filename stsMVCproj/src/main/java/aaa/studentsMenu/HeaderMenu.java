package aaa.studentsMenu;

import java.util.TreeMap;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HeaderMenu {
	TreeMap<String, String> headUrl;
}
