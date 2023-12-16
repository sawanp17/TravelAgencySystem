package org.example;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter

public class Activity {
    public String name;
    public String desciption;
    public float cost;
    public int capacity;
    private List<ActivityRegistration> activityRegistrationList = new ArrayList<>();

    public Activity(String name, String description, float cost, int capacity) {
        this.name = name;
        this.desciption = description;
        this.cost = cost;
        this.capacity = capacity;
    }

    public void print(){
        System.out.println(this.name);
        System.out.println("Cost: " + this.cost);
        System.out.println("Capacity: " + this.capacity);
        System.out.println("Description" + this.desciption);
    }

    public boolean register(ActivityRegistration activityRegistration){
//        System.out.println("size in function call " + this.getRegistrationList().size());

        //double-checking for avoiding inconsistencies
        if (this.getRegistrationList().size() >= this.getCapacity()){
            return false;
        }
        this.activityRegistrationList.add(activityRegistration);
        return true;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesciption() {
        return desciption;
    }

    public void setDesciption(String desciption) {
        this.desciption = desciption;
    }

    public float getCost() {
        return cost;
    }

    public void setCost(float cost) {
        this.cost = cost;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<ActivityRegistration> getRegistrationList() {
        return activityRegistrationList;
    }

    public void setRegistrationList(List<ActivityRegistration> activityRegistrationList) {
        this.activityRegistrationList = activityRegistrationList;
    }
}
