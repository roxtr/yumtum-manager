package in.yumtum.controller;

import in.yumtum.common.UserPreferences;
import in.yumtum.forms.RestaurantForm;
import in.yumtum.forms.TimingForm;
import in.yumtum.service.TimingService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/restaurants/{restId}/timings")
public class TimingController {

	@Autowired
	private UserPreferences userPreferences;
	
	@Autowired
	private TimingService timingService; 
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getHome(@PathVariable("restId")int restId){
		
		//ModelAndView mav = new ModelAndView("restaurants/timings/home");
		ModelAndView mav = new ModelAndView("index");
		
		try{
			if(userPreferences.getfName() == null){
					
				return mav;
			
			}else{
				mav = new ModelAndView("restaurants/timings/home");
				List<TimingForm> timingFormList = timingService.getTimings(restId);
				
				mav.addObject("restTimings", timingFormList);
				}
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
		return mav;
		
	}
	
	@RequestMapping(value="/new", method = RequestMethod.GET)
	public String setupForm(Model model){
		
		if(userPreferences.getfName() == null){
			
			return "redirect:/index";
		
		}else{
		TimingForm timingForm = new TimingForm();
		model.addAttribute("restTiming", timingForm);
		return "restaurants/timings/form";
		}
	}
	
	@RequestMapping(value="/new", method = RequestMethod.POST)
	public String processSubmit(@PathVariable("restId")int restId, @ModelAttribute("restTiming") TimingForm timingForm){
		
		Boolean created = false;
		if(userPreferences.getfName() == null){
			
			return "redirect:/index";
		
		}else{
			timingForm.setRestaurant_id(restId);
			timingForm.setCreatedBy(userPreferences.getUserId());
			created = timingService.addRestTiming(timingForm);
		if(!created){
			userPreferences.setDispMsg("Timing was Not created");
			return "restaurants/timings/form";
		}else{
			userPreferences.setDispMsg("Timing created successfully");
			return "redirect:/restaurants/{restId}/timings";
			}
		}
	}
	
	@RequestMapping(value="/{timingId}/update", method = RequestMethod.GET)
	public String setupForm(@PathVariable("timingId")int timingId,Model model){
		if(userPreferences.getfName() == null){
			
			return "redirect:/index";
		
		}else{
		TimingForm timingForm = timingService.getRestTimingById(timingId);
		model.addAttribute("restTiming", timingForm);
		return "restaurants/timings/form";
		}
	}
	@RequestMapping(value="/{timingId}/update", method = RequestMethod.POST)
	public String processUpdateSubmit(@PathVariable("timingId")int timingId, @ModelAttribute("restTiming") TimingForm timingForm){
		
		Boolean updated = false;
		
		if(userPreferences.getfName() == null){
			
			return "redirect:/index";
		
		}else{
			updated = timingService.updateRestTiming(timingForm);
		if(!updated){
			userPreferences.setDispMsg("timing was Not updated");
			return "restaurants/timings/form";
		}else{
			userPreferences.setDispMsg("timing updated successfully");
			return "redirect:/restaurants/{restId}/timings";
			}
		}
	}
	
	
}
