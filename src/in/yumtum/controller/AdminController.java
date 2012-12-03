package in.yumtum.controller;

import in.yumtum.common.UserPreferences;
import in.yumtum.forms.RestaurantForm;
import in.yumtum.forms.UserForm;
import in.yumtum.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private UserPreferences userPreferences;

	@Autowired
	private UserService userService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getHome(){
		
		ModelAndView mav = new ModelAndView("index");
		
		if(!userPreferences.getAdmin()){
			
			return mav;
		}else{
		
			mav = new ModelAndView("admin/home");
			
		}
	return mav;
	}

	@RequestMapping(value="/addUser", method = RequestMethod.GET)
	public String setupForm(Model model){
	
	if(!userPreferences.getAdmin()){
		
		return "redirect:/index";
	
	}else{
	UserForm userForm = new UserForm();
	model.addAttribute("user", userForm);
	return "admin/form";
	}
	
}
	@RequestMapping(value="/addUser", method = RequestMethod.POST)
	public String addUser(@ModelAttribute("user") UserForm userForm ){
	
		Boolean created = false;
		if(userPreferences.getfName() == null){
			
			return "redirect:/index";
		
		}else{
			
			created = userService.addUser(userForm);
		if(!created){
			userPreferences.setDispMsg("user was Not created");
			return "admin/form";
		}else{
			userPreferences.setDispMsg("user created successfully");
			return "redirect:/admin";
			}
		}
	
}
}
