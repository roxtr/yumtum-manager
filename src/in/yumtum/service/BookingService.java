package in.yumtum.service;

import in.yumtum.api.service.impl.BookingServiceImpl;
import in.yumtum.api.vo.BookingVO;
import in.yumtum.api.vo.ResultVO;
import in.yumtum.api.vo.TimingVO;
import in.yumtum.common.UserPreferences;
import in.yumtum.forms.BookingForm;
import in.yumtum.common.SendMail;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.google.gson.Gson;

public class BookingService {

	private BookingServiceImpl bookingServiceImpl = new BookingServiceImpl();
	
	public List<BookingForm> getBookings(UserPreferences userPreferences) {

		ResultVO result = bookingServiceImpl.getBookings(userPreferences.getRestaurantsOwned());
		
		List<BookingVO> bookingVOList = result.getBookVOList();
		List<BookingForm> bookingFormList = new ArrayList<BookingForm>();

		if(bookingVOList != null){
				
				for(BookingVO bookingVO:bookingVOList){
					bookingFormList.add(setLocalVO(bookingVO));
				}
			}
		
		return bookingFormList;
	}

	private BookingForm setLocalVO(BookingVO bookingVO) {
		
		BookingForm bookForm= new BookingForm();
		
		bookForm.setBookingId(bookingVO.getBookingId());
		bookForm.setBookingSourceId(bookingVO.getBookingSourceId());
		bookForm.setBookingTime(bookingVO.getBookingTime());
		bookForm.setNoOfPeople(bookingVO.getNoOfPeople());
		bookForm.setReserveDate(bookingVO.getReserveDate().toString());
		bookForm.setRestId(bookingVO.getRestId());
		bookForm.setTiming_id(bookingVO.getTiming_id());
		
		return bookForm;
	}

	public Boolean createBooking(BookingForm bookingForm,UserPreferences userPreferences) {
		Boolean created = false;
		
		bookingForm.setBookingTime(new Date());
		
		ResultVO result = bookingServiceImpl.createBooking(setApiBookVO(bookingForm));
		
		if(!result.isError()){
			created = true;
			
			String message = "<div>Hi "+userPreferences.getfName()+", <p>A booking has been done on yumtum.</p><p>\n <b>More you share, sooner you get the beta access.</b> :-) </p><p>\n \n \n \n - Team Yumtum</p>";

			
			SendMail sendMail = new SendMail("hello@yumtum.in", userPreferences.getEmail(), "Booking on yumtum",message );
			sendMail.send();
			
		}
		return created;
	}


	private BookingVO setApiBookVO(BookingForm bookingForm) {
		
		BookingVO bookVO= new BookingVO();
		
		bookVO.setBookingId(bookingForm.getBookingId());
		bookVO.setBookingSourceId(bookingForm.getBookingSourceId());
		bookVO.setBookingTime(bookingForm.getBookingTime());
		bookVO.setNoOfPeople(bookingForm.getNoOfPeople());
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy");
		try {
			bookVO.setReserveDate(sdf.parse(bookingForm.getReserveDate()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		bookVO.setRestId(bookingForm.getRestId());
		bookVO.setTiming_id(bookingForm.getTiming_id());
		
		return bookVO;
	}
	
	public String getJsonBookings(UserPreferences userPreferences) {

		ResultVO result = bookingServiceImpl.getBookings(userPreferences.getRestaurantsOwned());
		
		List<BookingVO> bookingVOList = result.getBookVOList();
		List<BookingForm> bookingFormList = new ArrayList<BookingForm>();

		if(bookingVOList != null){
				
				for(BookingVO bookingVO:bookingVOList){
					bookingFormList.add(setLocalVO(bookingVO));
				}
			}
		
		return new Gson().toJson(bookingFormList);
	}

	
}
