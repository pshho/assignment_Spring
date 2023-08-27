package aaa.control;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/")
	String goHome() {
		System.out.println("home");
		return "home";
	}
}
