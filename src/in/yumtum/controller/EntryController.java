package in.yumtum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class EntryController {
	
	@RequestMapping
	public String getHomePage() {
		System.out.println("in Entry Contrller");
		return "index";
	}
	
	
}
