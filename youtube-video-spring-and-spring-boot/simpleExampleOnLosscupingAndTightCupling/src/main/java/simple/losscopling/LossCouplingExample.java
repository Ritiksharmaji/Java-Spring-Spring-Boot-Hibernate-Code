package simple.losscopling;

public class LossCouplingExample {
	
	public static void main(String[] args) {
		

		UserDataProvider databaseProvider = new UserDatabaseProvider();
		UserManager userManagerWithDB = new UserManager(databaseProvider);
		System.out.println(userManagerWithDB.getUserInfo());
		
		/// adding new provider because if lossy coupling
		
		UserDataProvider webServiceProvider = new WebServiceDataProvider();
		UserManager userManagerWithWS = new UserManager(webServiceProvider);
		System.out.println(userManagerWithWS.getUserInfo());
		
		/// adding new provider because if lossy coupling
		
		UserDataProvider newDatabaseProvider = new NewDatabaseProvider();
		UserManager userManagerWithnewService = new UserManager(newDatabaseProvider);
		System.out.println(userManagerWithnewService.getUserInfo());
	
	
	}

}
