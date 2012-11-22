package in.yumtum.controller;

import in.yumtum.common.UserPreferences;
import in.yumtum.forms.TimingForm;
import in.yumtum.service.TimingService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/restaurants/${restId}/timings")
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
	
}
