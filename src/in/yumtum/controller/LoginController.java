package in.yumtum.controller;

import java.util.Map;

import in.yumtum.common.UserPreferences;
import in.yumtum.forms.LoginForm;
import in.yumtum.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class LoginController {

	@Autowired
	private UserService userService;
	
	@Autowired
	private UserPreferences userPreferences;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public String getUsersPage() {
		return "login";
	}
	@RequestMapping (value="/login",method=RequestMethod.POST)
	public String validateUser(LoginForm loginForm, Map model){
		
		loginForm = (LoginForm) model.get("loginForm");
		if(userService.checkLogin(loginForm.getUserName(), loginForm.getPassword(), userPreferences)){
		return "redirect:home";
		}else{
			return "redirect:login";
		}
	}
	
	@RequestMapping (value="/login/json",method=RequestMethod.POST)
	@ResponseBody
	public String validateUserJson(LoginForm loginForm, Map model){
		
		loginForm = (LoginForm) model.get("loginForm");
		String result = userService.checkLoginJson(loginForm.getUserName(), loginForm.getPassword(), userPreferences);
			return result;
		}
	
	@RequestMapping (value="/logout")
	public String logoutUser(){
		
		userService.resetPreferences(userPreferences);
		
		return "logout";
		
	}
}
