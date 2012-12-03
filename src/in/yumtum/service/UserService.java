package in.yumtum.service;

import in.yumtum.api.service.impl.UserServiceImpl;
import in.yumtum.api.vo.ResultVO;
import in.yumtum.api.vo.UserVO;
import in.yumtum.common.UserPreferences;
import in.yumtum.forms.UserForm;

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
			userPreferences.setAdmin(userVO.getAdmin());
			userPreferences.setRestaurantCreate(userVO.getRestaurantCreate());
			userPreferences.setRestaurantsAccess(userVO.getRestaurantsAccess());
			
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

	public Boolean addUser(UserForm userForm) {
		Boolean created = false;
		
		ResultVO result = userServiceImpl.createUser(setApiRestVO(userForm));
		
		if(!result.isError())
			created = true;
		
		return created;
	
	}

	
	private UserVO setApiRestVO(UserForm userForm){
		
		UserVO user = new UserVO();
		
		user.setAddress(userForm.getAddress());
		user.setAdmin(userForm.getAdmin());
		user.setCity(userForm.getCity());
		user.setEmail(userForm.getEmail());
		user.setfName(userForm.getfName());
		user.setlName(userForm.getlName());
		user.setLocality(userForm.getLocality());
		user.setName(userForm.getName());
		user.setPassword(userForm.getPassword());
		user.setPhone(userForm.getPhone());
		user.setRestaurantCreate(userForm.getRestaurantCreate());
		
		return user;
	}
}
