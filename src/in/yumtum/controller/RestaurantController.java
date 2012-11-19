package in.yumtum.controller;

import java.util.List;
import java.util.Map;

import in.yumtum.common.UserPreferences;
import in.yumtum.forms.RestaurantForm;
import in.yumtum.service.RestaurantService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/restaurants")
public class RestaurantController {
	
	@Autowired
	private UserPreferences userPreferences;
	
	@Autowired
	private RestaurantService restService; 
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getHome(){
		
		ModelAndView mav = new ModelAndView("index");
		
		try{
			if(userPreferences.getfName() == null){
					
				return mav;
			
			}else{
				mav = new ModelAndView("restaurants/restaurantsHome");
				
				System.out.println("New Check::"+userPreferences.getRestaurantsOwned());
				
				if(userPreferences.getRestaurantsOwned() == null){
					return mav;
				} else {
				/*	List<RestaurantForm> restList = restService.getRestaurants(userPreferences);
					
					System.out.println("New Check::"+restList);
					System.out.println("New Check::"+restList.size());
					mav.addObject("restaurants", restList);
				*/
					RestaurantForm restForm = restService.getRestaurants(userPreferences);
					mav.addObject("restaurants", restForm);
					
				}
			}}
			catch(Exception e){
					e.printStackTrace();
			}
		
		return mav;
	}
	
	@RequestMapping(value="/new", method = RequestMethod.GET)
	public String setupForm(Model model){
		RestaurantForm restForm = new RestaurantForm();
		model.addAttribute("restaurant", restForm);
		return "restaurants/form";
	}

	@RequestMapping(value="/new", method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute("restaurant") RestaurantForm restForm){
		
		Boolean created = false;
		created = restService.createRestaurant(restForm);
		
		if(!created){
			userPreferences.setDispMsg("Restaurant was Not created");
			return "restaurants/form";
		}else{
			userPreferences.setDispMsg("Restaurant created successfully");
			return "redirect:/restaurants";
		}
	}
	
	@RequestMapping(value="/{restId}/update", method = RequestMethod.GET)
	public String setupForm(@PathVariable("restId")int restId,Model model){
		
		RestaurantForm restForm = restService.getRestaurantById(restId);
		model.addAttribute("restaurant", restForm);
		return "restaurants/form";
	}
	
}
