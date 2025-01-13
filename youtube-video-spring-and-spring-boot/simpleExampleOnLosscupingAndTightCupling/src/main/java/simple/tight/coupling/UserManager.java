package simple.tight.coupling;

public class UserManager {
	
	// tightly coupling here 
	private UserDatabase userDatabase = new UserDatabase();
	
	public String getUserInfo() {
		
		return userDatabase.getUserDetails();
	}

}
