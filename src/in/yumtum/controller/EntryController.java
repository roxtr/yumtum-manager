package in.yumtum.controller;

import in.yumtum.common.UserPreferences;
import in.yumtum.forms.LoginForm;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class EntryController {

	@Autowired
	private UserPreferences userPreferences;
	
	@RequestMapping(method = RequestMethod.GET)
	public String showForm(Map model) {
		
	String ret = "index";
	try{
		if(userPreferences.getfName() != null)
		 ret = "home";
	}
	catch(Exception e){
			
	}
	
	LoginForm loginForm = new LoginForm();
	model.put("loginForm", loginForm);

	return ret;
	}
	
	
}
