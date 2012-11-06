package in.yumtum.controller;

import in.yumtum.forms.LoginForm;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class EntryController {
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Map model) {
	LoginForm loginForm = new LoginForm();
	model.put("loginForm", loginForm);
	return "index";
	}
	
	
}
