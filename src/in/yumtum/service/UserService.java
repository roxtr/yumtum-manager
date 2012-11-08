package in.yumtum.service;

import in.yumtum.api.service.impl.UserServiceImpl;
import in.yumtum.api.vo.ResultVO;
import in.yumtum.common.UserPreferences;

public class UserService {
	
	UserServiceImpl userServiceImpl = new UserServiceImpl();
	
	public String checkUser(String userName, String password, UserPreferences userPreferences){
		System.out.println("check user");
		
		ResultVO result = userServiceImpl.validateLogin(userName, password);
		
		userPreferences.setUser("New test check");
		userPreferences.setCity(result.getYtRestUserVO().getCity());
		return "checked";
	}

}
