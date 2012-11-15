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
	
	public RestaurantForm getRestaurants(UserPreferences userPreferences){
		
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
		
		ResultVO result = restService.getRestaurantDetails(new Integer(userPreferences.getRestaurantsOwned()));
		
		RestaurantForm restForm = setLocalVO(result.getRestVO());
		
		return restForm;	
		
	}
	
	public RestaurantForm getRestaurantById(int restId){
		
		ResultVO result = restService.getRestaurantDetails(new Integer(restId));
		
		RestaurantForm restForm = setLocalVO(result.getRestVO());
		
		return restForm;
		
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
		
		return restVO;
	}

}
