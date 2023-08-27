package aaa.control;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import aaa.model.Camping;
import aaa.service.CampingChk;
import jakarta.annotation.Resource;
import jakarta.validation.Valid;

@Controller
@RequestMapping("form")
public class FormController {
	@Resource
	CampingChk campingChk;
	
	@RequestMapping("campingSite")
	String goCamping(Camping camp) {
		return "form/campingSite";
	}
	
	@PostMapping("campingReg")
	String campingReg(@Valid Camping camp, BindingResult br) {
		System.out.println(camp);
		
		if(br.hasErrors()) {
			// System.out.println("진입");
			return "form/campingSite";
		}
		
		if(campingChk.businessChk(camp, br)) {
			return "form/campingSite";
		}
		
		return "form/campingReg";
	}
}
