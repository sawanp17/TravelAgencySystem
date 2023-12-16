package org.example;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@Builder
public class Destination {
    String name;
//    List<Activity> activityList = new ArrayList<>();

    void print(){
        System.out.println("\n");
        System.out.println(this.name);
        System.out.println("Acitivities Available: ");
        List<Activity> activityList = DestinationActivityMap.getListOfActivities(this);
        for (Activity activity: activityList){
            activity.print();
        }
    }

    List<Activity> getActivitiesWithRemainingSpace(){
        List<Activity> ans = new ArrayList<>();
        List<Activity> activityList = DestinationActivityMap.getListOfActivities(this);
        for (Activity activityIt: activityList){
            if (activityIt.getCapacity() > activityIt.getRegistrationList().size() ){
                ans.add(activityIt);
            }
        }
        return ans;
    }
}
