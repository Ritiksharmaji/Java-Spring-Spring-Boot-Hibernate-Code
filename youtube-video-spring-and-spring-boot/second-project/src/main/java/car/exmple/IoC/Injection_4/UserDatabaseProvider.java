package car.exmple.IoC.Injection_4;

public class UserDatabaseProvider  implements UserDataProvider{

	@Override
	public String getUserDetails() {
		// TODO Auto-generated method stub
		return "user details from the database from the loose coupling";
	}
	

}
