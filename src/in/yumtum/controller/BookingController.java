package in.yumtum.controller;

import java.util.List;

import in.yumtum.common.UserPreferences;
import in.yumtum.forms.BookingForm;
import in.yumtum.forms.TimingForm;
import in.yumtum.service.BookingService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/bookings")
public class BookingController {
	

	@Autowired
	private UserPreferences userPreferences;
	
	@Autowired
	private BookingService bookingService;
	

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
	
}
