package org.example;

import lombok.Builder;
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
    List<Registration> registrationList = new ArrayList<>();

    public Passenger(String name, int passengerNumber, Membership membership, float balance) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.membership = membership;
        this.balance = balance;
    }

    public boolean register(Activity activity){
        if (!membership.getName().equals("PREMIUM")){
            float discountedPrice = membership.getDiscountedPrice(activity.cost);
            if (discountedPrice > balance || activity.getRegistrationList().size() >= activity.getCapacity()){
                System.out.println("Not enough balance OR Activity Limit Reached");
                return false;
            }
            else {
                this.balance = this.balance - discountedPrice;
            }
        }
        Registration registration =  registrationService.makeRegistration(activity,this);
        this.registrationList.add(registration);

        //return if activity confirms registration
        boolean ans =  activity.register(registration);
        return ans;
    }

    void printPassengerInfo(){
        System.out.println("Name: " + this.getName());
        System.out.println("Passenger Number: " + this.getPassengerNumber());
        String membershipName = this.getMembership().getName();
        String balanceText = membershipName.equals("PREMIUM") ? "N/A" : " " + this.getBalance();
        System.out.println("Balance: " + balanceText);
        System.out.println("Activities Enrolled: ");
        for (Registration registration: registrationList){
            System.out.println(registration.getActivity().getName() + " at Desitination: " + registration.getActivity());
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

    public List<Registration> getRegistrationList() {
        return registrationList;
    }

    public void setRegistrationList(List<Registration> registrationList) {
        this.registrationList = registrationList;
    }

    public RegistrationService getRegistrationService() {
        return registrationService;
    }

    public void setRegistrationService(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }
}
