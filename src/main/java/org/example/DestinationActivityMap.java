package org.example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DestinationActivityMap {
    static Map<Destination, List<Activity>> destinationActivityMap = new HashMap<>();

    public static List<Activity> getListOfActivities(Destination destination){
        return destinationActivityMap.get(destination);
    }

    public static void addActivity(Activity activity, Destination destination){
        List<Activity> currentActivities = getListOfActivities(destination);
        if (currentActivities == null){
            currentActivities = new ArrayList<>();
        }
        currentActivities.add(activity);
        destinationActivityMap.put(destination,currentActivities);
    }

    public static void removeActivity(Activity activity, Destination destination) {
        List<Activity> currentActivities = getListOfActivities(destination);
        if (currentActivities == null){
            return;
        }
        currentActivities.remove(activity);
        destinationActivityMap.put(destination,currentActivities);
    }
}
