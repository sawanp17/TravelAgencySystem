package org.example;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class Registration {
    Activity activity;
    Passenger passenger;

    public Registration(Activity activity, Passenger passenger){
        this.activity = activity;
        this.passenger = passenger;
    }
}
