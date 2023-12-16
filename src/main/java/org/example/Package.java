package org.example;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Builder
public class Package {
    String name;
    int passengerCapacity;
    Itenerary itenerary;
    List<Passenger> passengerList = new ArrayList<>();

    boolean register(Passenger passenger){
        if (this.getPassengerList().size() >= this.getPassengerCapacity()){
            return false;
        }
        this.passengerList.add(passenger);
        return true;
    }

    void printPackage(){
        System.out.println(
                "Package "+ this.name + "\n"
        );
        itenerary.print();

    }

    void printPassengerList(){
        System.out.println("Package: " + this.getName());
        System.out.println("Passenger Capacity: " + this.getPassengerCapacity());
        System.out.println("Currently Enrolled: " + this.getPassengerList().size());

        for (Passenger passenger: passengerList){
            System.out.println(passenger.getName() + "(" + passenger.getPassengerNumber() + ")");
        }
    }
}
