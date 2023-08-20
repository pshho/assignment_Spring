package aaa.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	String home() {
		System.out.println("홈");
		return "home";
	}
}
