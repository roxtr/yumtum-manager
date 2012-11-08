package in.yumtum.controller;

import java.util.Map;

import in.yumtum.common.UserPreferences;
import in.yumtum.forms.LoginForm;
import in.yumtum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserPreferences userPreferences;
	
	@RequestMapping(method=RequestMethod.GET)
	public String getUsersPage() {
		return "login";
	}
	@RequestMapping (method=RequestMethod.POST)
	public String validateUser(LoginForm loginForm, Map model){
		
		loginForm = (LoginForm) model.get("loginForm");
		if(userService.checkLogin(loginForm.getUserName(), loginForm.getPassword(), userPreferences)){
		return "redirect:home";
		}else{
			return "redirect:login";
		}
	}
	
	
}
