package in.yumtum.service;

import in.yumtum.api.service.impl.BookingServiceImpl;
import in.yumtum.api.vo.ResultVO;
import in.yumtum.common.UserPreferences;
import in.yumtum.forms.BookingForm;

import java.util.List;

public class BookingService {

	private BookingServiceImpl bookingServiceImpl;
	
	public List<BookingForm> getBookings(UserPreferences userPreferences) {

		ResultVO result = bookingServiceImpl.getBookings(userPreferences.getRestaurantsOwned());
		
		return null;
	}

}
