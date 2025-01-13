package simple.losscopling;

public class UserManager {
	
//	// tightly coupling here 
//	private UserDatabaseProvider userDatabase = new UserDatabaseProvider();
	
	private UserDataProvider userDataProvider;
	
	public UserManager(UserDataProvider userDataProvider) {
		this.userDataProvider = userDataProvider;
	}
	
	public String getUserInfo() {
		
		return userDataProvider.getUserDetails();
	}

}
