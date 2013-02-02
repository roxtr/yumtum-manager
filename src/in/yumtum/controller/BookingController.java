package in.yumtum.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import in.yumtum.common.UserPreferences;
import in.yumtum.forms.BookingForm;
import in.yumtum.forms.RestaurantForm;
import in.yumtum.forms.TimingForm;
import in.yumtum.service.BookingService;
import in.yumtum.service.RestaurantService;
import in.yumtum.service.TimingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/bookings")
public class BookingController {
	

	@Autowired
	private UserPreferences userPreferences;
	
	@Autowired
	private BookingService bookingService;
	
	@Autowired
	private TimingService timingService; 
	
	@Autowired
	private RestaurantService restService; 

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getHome(){
		ModelAndView mav = new ModelAndView("index");
		
		try{
			if(userPreferences.getfName() == null){
					
				return mav;
			
			}else{
				mav = new ModelAndView("bookings/home");
				List<BookingForm> bookingFormList = bookingService.getBookings(userPreferences);
				
				mav.addObject("restBookings", bookingFormList);
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
		BookingForm bookingForm = new BookingForm();
		List<RestaurantForm> restFormList = restService.getRestaurants(userPreferences);
		model.addAttribute("restaurants", restFormList);
		model.addAttribute("restBooking", bookingForm);
		
		return "bookings/form";
		}
	}
	
	@RequestMapping(value="/new", method = RequestMethod.POST)
	public String processSubmit(@ModelAttribute("restBooking") BookingForm bookingForm){
		
		Boolean created = false;
		
		if(userPreferences.getfName() == null){
			
			return "redirect:/index";
		
		}else{
			created = bookingService.createBooking(bookingForm,userPreferences);
			if(!created){
				userPreferences.setDispMsg("Booking was Not created");
				return "bookings/form";
			}else{
				userPreferences.setDispMsg("Booking created successfully");
				return "bookings/home";
				}
			
		}
	}
	
	@RequestMapping(value="/{restId}/timings", method = RequestMethod.GET )
	@ResponseBody
	public String getTimings(@PathVariable("restId")int restId){
		
		List<TimingForm> timingFormList = new ArrayList<TimingForm>();
		String timingList = "";
		
		try{
			if(userPreferences.getfName() == null){
					
				return "[]";
			
			}else{
				timingFormList = timingService.getTimings(restId);
				if(timingFormList != null){
				for(TimingForm timingForm:timingFormList){
					
					String timingId = "\""+timingForm.getTimingId().toString()+"\"";
					String timing = "\""+timingForm.getReserveTime()+"\"";
					String oneTiming = "{"+timingId+":"+timing+"}";
					timingList=timingList+oneTiming+",";
				}}
				
				}
		}catch(Exception e){
			e.printStackTrace();
			
		}
		timingList = "["+timingList.substring(0, timingList.length()-1)+"]";
		return timingList;
	}
	
	@RequestMapping(value="/all/json", method = RequestMethod.GET )
	@ResponseBody
	public String getJsonBookings(){
		
		String bookingJsonList = null;
		try{
			if(userPreferences.getfName() == null){
					
				return "";
			
			}else{
				bookingJsonList = bookingService.getJsonBookings(userPreferences);
				}
		}catch(Exception e){
			e.printStackTrace();
			
		}
		
		return bookingJsonList;
		}
}
