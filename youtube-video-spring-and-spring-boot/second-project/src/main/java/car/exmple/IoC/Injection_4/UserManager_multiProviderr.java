package car.exmple.IoC.Injection_4;

import java.util.List;

public class UserManager_multiProviderr {
    private List<UserDataProvider> userDataProviders;

    // Constructor to accept a list of providers
    public UserManager_multiProviderr(List<UserDataProvider> userDataProviders) {
        this.userDataProviders = userDataProviders;
    }

    // Iterate through all providers and fetch details
    public void getUserInfo() {
        for (UserDataProvider provider : userDataProviders) {
            System.out.println(provider.getUserDetails());
        }
    }
}
