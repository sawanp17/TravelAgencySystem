package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
public class Passenger {
    RegistrationService registrationService = new RegistrationService();

    public String name;
    private int passengerNumber;
    private Membership membership;
    private float balance;
    List<ActivityRegistration> activityRegistrationList = new ArrayList<>();
    List<Package> packageRegistered = new ArrayList<>();

    public Passenger(String name, int passengerNumber, Membership membership, float balance) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.membership = membership;
        this.balance = balance;
    }

    public boolean register(Activity activity, Destination destination){
        if (! DestinationActivityMap.getListOfActivities(destination).contains(activity)){
            System.out.println(">>> Activity not found at this location");
            return false;
        }
        if (!membership.getName().equals("PREMIUM")){
            float discountedPrice = membership.getDiscountedPrice(activity.cost);
            if (discountedPrice > balance || activity.getRegistrationList().size() >= activity.getCapacity()){
                System.out.println(">>> Not enough balance OR Activity Limit Reached");
                return false;
            }
            else {
                this.balance = this.balance - discountedPrice;
            }
        }
        ActivityRegistration activityRegistration =  registrationService.makeActivityRegistration(activity,destination,this, getMembership().getDiscountedPrice(activity.getCost()));
        this.activityRegistrationList.add(activityRegistration);

        //return if activity confirms registration
        boolean ans =  activity.register(activityRegistration);
        if (!ans){
            this.activityRegistrationList.remove(activityRegistration);
        }
        return ans;
    }

    boolean registerPackage(Package p){
        if (p.getPassengerList().size() >= p.getPassengerCapacity()){
            return false;
        }
        this.packageRegistered.add(p);
        boolean confirmation =  p.register(this);
        if (!confirmation){
            this.packageRegistered.remove(p);
        }
        return confirmation;

    }

    void printPassengerInfo(){
        System.out.println("Name: " + this.getName());
        System.out.println("Passenger Number: " + this.getPassengerNumber());
        String membershipName = this.getMembership().getName();
        String balanceText = membershipName.equals("PREMIUM") ? "N/A" : " " + this.getBalance();
        System.out.println("Balance: " + balanceText);
        System.out.println("Activities Enrolled: ");
        for (ActivityRegistration activityRegistration : activityRegistrationList){
            System.out.println(activityRegistration.getActivity().getName() + " at Desitination: " + activityRegistration.getDestination().getName() + " at Price " + activityRegistration.getPricePaid());
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public void setPassengerNumber(int passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    public Membership getMembership() {
        return membership;
    }

    public void setMembership(Membership membership) {
        this.membership = membership;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float balance) {
        this.balance = balance;
    }

    public List<ActivityRegistration> getRegistrationList() {
        return activityRegistrationList;
    }

    public void setRegistrationList(List<ActivityRegistration> activityRegistrationList) {
        this.activityRegistrationList = activityRegistrationList;
    }

    public RegistrationService getRegistrationService() {
        return registrationService;
    }

    public void setRegistrationService(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }
}
