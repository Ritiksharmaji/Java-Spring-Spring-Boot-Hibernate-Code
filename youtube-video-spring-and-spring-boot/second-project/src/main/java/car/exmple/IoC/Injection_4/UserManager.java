package car.exmple.IoC.Injection_4;

public class UserManager {
	

	private UserDataProvider userDataProvider;
	
	public UserManager(UserDataProvider userDataProvider) {
		this.userDataProvider = userDataProvider;
	}
	
	public String getUserInfo() {
		
		return userDataProvider.getUserDetails();
	}

}
