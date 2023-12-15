package org.example;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PremiumMember extends Membership{

    @Override
    public float getDiscountRate() {
        return 100;
    }

    @Override
    public String getName() {
        return "PREMIUM";
    }

//    @Override
//    public float getMaxBalance() {
//        return 0;
//    }
}
