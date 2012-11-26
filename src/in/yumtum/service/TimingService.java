package in.yumtum.service;

import in.yumtum.api.service.impl.TimingServiceImpl;
import in.yumtum.api.vo.RestaurantVO;
import in.yumtum.api.vo.ResultVO;
import in.yumtum.api.vo.TimingVO;
import in.yumtum.forms.RestaurantForm;
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
	
	public Boolean addRestTiming(TimingForm timingForm) {
		Boolean created = false;
		ResultVO result = timingService.addRestaurantTiming(setApiTimeVO(timingForm));
		
		if(!result.isError())
			created = true;
		
		return created;
	}
	

	private TimingForm setLocalVO(TimingVO timingVO){
		
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

private TimingVO setApiTimeVO(TimingForm timingForm){
		
		TimingVO timingVO= new TimingVO();
		
		timingVO.setAvailableSeats(timingForm.getAvailableSeats());
		timingVO.setCreatedBy(timingForm.getCreatedBy());
		timingVO.setReserveTime(timingForm.getReserveTime());
		timingVO.setRestaurant_id(timingForm.getRestaurant_id());
		timingVO.setTimeOfDay(timingForm.getTimeOfDay());
		timingVO.setTotalSeats(timingForm.getTotalSeats());
		timingVO.setTimingId(timingForm.getTimingId());
		
		return timingVO;
	}

public TimingForm getRestTimingById(int timingId) {
	
	ResultVO result = timingService.getRestaurantTimingsById(timingId);
    
	TimingForm timingForm = setLocalVO(result.getTimingVO());
	
	return timingForm;
}

public Boolean updateRestTiming(TimingForm timingForm) {
	
	Boolean updated = false;
	TimingVO timingVO = this.setApiTimeVO(timingForm);
	ResultVO result = timingService.updateRestaurantTiming(timingVO);
	
	if(!result.isError())
		updated = true;
	
	return updated;
}
}
