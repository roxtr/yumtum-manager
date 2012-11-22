package in.yumtum.service;

import in.yumtum.api.service.impl.TimingServiceImpl;
import in.yumtum.api.vo.ResultVO;
import in.yumtum.api.vo.TimingVO;
import in.yumtum.forms.TimingForm;

import java.util.ArrayList;
import java.util.List;

public class TimingService {
	
	TimingServiceImpl timingService = new TimingServiceImpl();

	public List<TimingForm> getTimings(int restId) {
		
		ResultVO result = timingService.getRestaurantTimings(restId);

		List<TimingVO> timingVOList = result.getTimeVOList();
		List<TimingForm> timingFormList = new ArrayList<TimingForm>();
		
	if(timingVOList != null){
			
			for(TimingVO timingVO:timingVOList){
				timingFormList.add(setLocalVO(timingVO));
			}
		}
		
		return timingFormList;
	}

	private TimingForm setLocalVO(in.yumtum.api.vo.TimingVO timingVO){
		
		TimingForm timingForm= new TimingForm();
		
		timingForm.setAvailableSeats(timingVO.getAvailableSeats());
		timingForm.setCreatedBy(timingVO.getCreatedBy());
		timingForm.setReserveTime(timingVO.getReserveTime());
		timingForm.setRestaurant_id(timingVO.getRestaurant_id());
		timingForm.setTimeOfDay(timingVO.getTimeOfDay());
		timingForm.setTimingId(timingVO.getTimingId());
		timingForm.setTotalSeats(timingVO.getTotalSeats());
		
		return timingForm;
	}
	
}
