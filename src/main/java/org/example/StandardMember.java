package org.example;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class StandardMember extends Membership{

    @Override
    public float getDiscountRate() {
        return 0;
    }

    @Override
    public String getName() {
        return "STANDARD";
    }

//    @Override
//    public float getMaxBalance() {
//        //set max balance for standard member
//        return 100;
//    }
}
