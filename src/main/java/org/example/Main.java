package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Activity activity1 = new Activity("a1","a1",20,5);
        Activity activity2 = new Activity("a2","a2",30,4);
        Activity activity3 = new Activity("a3","a3",10,7);
        Activity activity4 = new Activity("a4","a4",50,35);
        Activity activity5 = new Activity("a5","a5",15,4);

        Destination d1 = new Destination("d1", List.of(activity1,activity3));
        Destination d2 = new Destination("d2", List.of(activity2,activity3, activity4));

        Itenerary itenerary = new Itenerary(List.of(d1,d2));

        Passenger p1 = new Passenger("p1",1,new GoldMember(),500);
        Passenger p2 = new Passenger("p2",2,new StandardMember(),200);
        Passenger p3 = new Passenger("p3",3,new PremiumMember(),10);

        Package pack1 = new Package("pa1",20,itenerary,List.of(p1,p2,p3));

//        pack1.printPackage();
//        pack1.printPassengerList();

    }
}