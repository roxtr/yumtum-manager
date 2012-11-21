package in.yumtum.service;

import java.util.ArrayList;
import java.util.List;

import in.yumtum.api.cayenne.persistent.YtRestaurants;
import in.yumtum.api.service.impl.RestaurantServiceImpl;
import in.yumtum.api.vo.RestaurantVO;
import in.yumtum.api.vo.ResultVO;
import in.yumtum.common.UserPreferences;
import in.yumtum.forms.RestaurantForm;

public class RestaurantService {
	
	RestaurantServiceImpl restService = new RestaurantServiceImpl();
	
	public List<RestaurantForm> getRestaurants(UserPreferences userPreferences){
		
		/*ResultVO result = restService.getAllRestaurants(userPreferences.getRestaurantsOwned(), new Integer(userPreferences.getUserId()));
		
		List<RestaurantForm> restList = new ArrayList<RestaurantForm>();
		
		if(result.isError()){
			userPreferences.setDispMsg(result.getErrorMsg());
		}else{
			
			if(result.getRestVOList() != null){
			 if(result.getRestVOList().size() > 1){
				for(RestaurantVO localObj : result.getRestVOList()){
					restList.add(setLocalVO(localObj));
				}	
			 }else{
				 restList.add(setLocalVO(result.getRestVOList().get(0)));
			 }
			}
			
		}*/
		
		//ResultVO result = restService.getRestaurantDetails(new Integer(userPreferences.getRestaurantsOwned()));
		
		
		
		//ResultVO result = restService.getAllRestaurants(userPreferences.getRestaurantsOwned(), userPreferences.getUserId());
		
		ResultVO result = restService.getAllRestaurantsByUser(userPreferences.getUserId());
		
		List<RestaurantVO> restVOList = result.getRestVOList();
		List<RestaurantForm> restFormList = new ArrayList<RestaurantForm>();
		
		if(restVOList != null){
			
			for(RestaurantVO restVO:restVOList){
				restFormList.add(setLocalVO(restVO));
			}
		}
		
		return restFormList;	
		
	}
	
	public RestaurantForm getRestaurantById(int restId){
		
		ResultVO result = restService.getRestaurantDetails(new Integer(restId));
		
		RestaurantForm restForm = setLocalVO(result.getRestVO());
		
		return restForm;
		
	}
	
	public Boolean createRestaurant(RestaurantForm restForm){
		Boolean created = false;
		
		RestaurantVO restVO = this.setApiRestVO(restForm);
		restVO.setActive(1);
		restVO.setCusines("1,2");
		ResultVO result = restService.createRestaurant(restVO);
		
		if(!result.isError())
			created = true;
		
		return created;
	}
	
	
private RestaurantForm setLocalVO(RestaurantVO ytRest){
		
		RestaurantForm restVO= new RestaurantForm();
		
		restVO.setAcceptCC(ytRest.getAcceptCC());
		restVO.setActive(ytRest.getActive());
		restVO.setAddress(ytRest.getAddress());
		restVO.setAvgCostForTwo(ytRest.getAvgCostForTwo());
		restVO.setCity(ytRest.getCity());
		restVO.setCusines(ytRest.getCusines());
		restVO.setHasAC(ytRest.getHasAC());
		restVO.setHasWifi(ytRest.getHasWifi());
		restVO.setLatitude(ytRest.getLatitude());
		restVO.setLongitude(ytRest.getLongitude());
		restVO.setLocality(ytRest.getLocality());
		restVO.setName(ytRest.getName());
		restVO.setNfsPhone(ytRest.getNfsPhone());
		restVO.setPhones(ytRest.getPhones());
		restVO.setRest_createdBy(ytRest.getRest_createdBy());
		restVO.setIsVeg(ytRest.getIsVeg());
		restVO.setRestId(ytRest.getRestId());
		
		return restVO;
	}


private RestaurantVO setApiRestVO(RestaurantForm restForm){
		
		RestaurantVO restVO= new RestaurantVO();
		
		restVO.setAcceptCC(restForm.getAcceptCC());
		restVO.setActive(restForm.getActive());
		restVO.setAddress(restForm.getAddress());
		restVO.setAvgCostForTwo(restForm.getAvgCostForTwo());
		restVO.setCity(restForm.getCity());
		restVO.setCusines(restForm.getCusines());
		restVO.setHasAC(restForm.getHasAC());
		restVO.setHasWifi(restForm.getHasWifi());
		restVO.setLatitude(restForm.getLatitude());
		restVO.setLongitude(restForm.getLongitude());
		restVO.setLocality(restForm.getLocality());
		restVO.setName(restForm.getName());
		restVO.setNfsPhone(restForm.getNfsPhone());
		restVO.setPhones(restForm.getPhones());
		restVO.setRest_createdBy(restForm.getRest_createdBy());
		restVO.setVeg(restForm.getIsVeg());
		restVO.setRestId(restForm.getRestId());
		return restVO;
	}

public Boolean updateRestaurant(RestaurantForm restForm) {

	Boolean updated = false;
	RestaurantVO restVO = this.setApiRestVO(restForm);
	restVO.setActive(1);
	restVO.setCusines("1,2");
	ResultVO result = restService.updateRestaurant(restVO);
	
	if(!result.isError())
		updated = true;
	
	return updated;
	
}

public List<Integer> stringToIntList(String restIds){
	
	List<Integer> intList = new ArrayList<Integer>();
	
	String[] strArr = restIds.split(",");
	
	
	return intList;
}

}
