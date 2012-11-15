package in.yumtum.service;

import in.yumtum.api.service.impl.UserServiceImpl;
import in.yumtum.api.vo.ResultVO;
import in.yumtum.api.vo.UserVO;
import in.yumtum.common.UserPreferences;

public class UserService {
	
	UserServiceImpl userServiceImpl = new UserServiceImpl();
	
	public Boolean checkLogin(String userName, String password, UserPreferences userPreferences){
		System.out.println("check user");
		
		try{
		    
			ResultVO result = userServiceImpl.validateLogin(userName, password);
		
			if(result.isError()){
				this.resetPreferences(userPreferences);
				userPreferences.setDispMsg("Login Failed");
				return false;
				
			}
			else{
			UserVO userVO = result.getUserVO();
			
			userPreferences.setName(userVO.getName());
			userPreferences.setfName(userVO.getfName());
			userPreferences.setlName(userVO.getlName());
			userPreferences.setAddress(userVO.getAddress());
			userPreferences.setLocality(userVO.getLocality());
			userPreferences.setCity(userVO.getCity());
			userPreferences.setEmail(userVO.getEmail());
			userPreferences.setPhone(userVO.getPhone());
			userPreferences.setRestaurantsOwned(userVO.getRestaurantsOwned());
			userPreferences.setUserId(userVO.getUserId());
			userPreferences.setCity(result.getYtRestUserVO().getCity());
			
			return true;
			
			}
			
		}catch(Exception e){
			this.resetPreferences(userPreferences);
			userPreferences.setDispMsg("Login Failed");
			
			return false;
			
		}
		
	}

	public void resetPreferences(UserPreferences userPreferences) {
		
		userPreferences.setName(null);
		userPreferences.setfName(null);
		userPreferences.setlName(null);
		userPreferences.setAddress(null);
		userPreferences.setLocality(null);
		userPreferences.setCity(null);
		userPreferences.setEmail(null);
		userPreferences.setPhone(null);
		userPreferences.setRestaurantsOwned(null);
		userPreferences.setUserId(0);
		userPreferences.setCity(null);
		userPreferences.setDispMsg("Logged Out");
	}

}
