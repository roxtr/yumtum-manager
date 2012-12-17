package in.yumtum.service;

import in.yumtum.api.service.impl.BookingServiceImpl;
import in.yumtum.api.vo.BookingVO;
import in.yumtum.api.vo.ResultVO;
import in.yumtum.api.vo.TimingVO;
import in.yumtum.common.UserPreferences;
import in.yumtum.forms.BookingForm;

import java.util.ArrayList;
import java.util.List;

public class BookingService {

	private BookingServiceImpl bookingServiceImpl;
	
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
		bookForm.setReserveDate(bookingVO.getReserveDate());
		bookForm.setRestId(bookingVO.getRestId());
		bookForm.setTiming_id(bookingVO.getTiming_id());
		
		return bookForm;
	}

}
