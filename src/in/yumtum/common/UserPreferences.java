package in.yumtum.common;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("session")
public class UserPreferences implements Serializable {
	
	
	private static final long serialVersionUID = 5307927482444401384L;
	
	private String address;
	private String city;
	private String email;
	private String fName;
	private String lName;
	private String locality;
	private String name;
	private String phone;
	private String restaurantsOwned;
	private int userId;
	private String dispMsg;
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getfName() {
		return fName;
	}
	public void setfName(String fName) {
		this.fName = fName;
	}
	public String getlName() {
		return lName;
	}
	public void setlName(String lName) {
		this.lName = lName;
	}
	public String getLocality() {
		return locality;
	}
	public void setLocality(String locality) {
		this.locality = locality;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getRestaurantsOwned() {
		return restaurantsOwned;
	}
	public void setRestaurantsOwned(String restaurantsOwned) {
		this.restaurantsOwned = restaurantsOwned;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getDispMsg() {
		return dispMsg;
	}
	public void setDispMsg(String dispMsg) {
		this.dispMsg = dispMsg;
	}

	
	

}
