package org.example;

public class RegistrationService {
    public ActivityRegistration makeActivityRegistration(Activity activity, Destination destination, Passenger passenger, float pricePaid){
        return new ActivityRegistration(activity, destination, passenger,pricePaid);
    }
    public PackageRegistration makePackageRegistration(Package p, Passenger passenger){
        return new PackageRegistration(p,passenger);
    }
}
