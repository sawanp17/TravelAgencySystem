package org.example;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GoldMember extends Membership{

    @Override
    public float getDiscountRate() {
        return 10;
    }

    @Override
    public String getName() {
        return "GOLD";
    }

//    @Override
//    public float getMaxBalance() {
//        return 100;
//    }
}
