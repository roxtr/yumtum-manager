package in.yumtum.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class EntryController {
	
	@RequestMapping
	public String getHomePage() {
		return "index";
	}
	
	
}
