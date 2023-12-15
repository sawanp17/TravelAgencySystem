package org.example;

public class RegistrationService {
    public Registration makeRegistration(Activity activity, Passenger passenger){
        return new Registration(activity,passenger);
    }
}
