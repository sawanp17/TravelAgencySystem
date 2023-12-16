package org.example;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class ActivityRegistration {
    private Activity activity;
    private Destination destination;
    private Passenger passenger;
    private float pricePaid;

    public ActivityRegistration(Activity activity, Destination destination, Passenger passenger, float pricePaid){
        this.activity = activity;
        this.passenger = passenger;
        this.destination = destination;
        this.pricePaid = pricePaid;
    }
}
