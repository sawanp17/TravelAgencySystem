package org.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class MembershipTest {

    @Test
    void getDiscountedPriceGold() {
        GoldMember goldMember = new GoldMember();
        assertEquals(90F, goldMember.getDiscountedPrice(100));
    }
    @Test
    void getDiscountedPriceStandard() {
        StandardMember standardMember = new StandardMember();
        assertEquals(100F, standardMember.getDiscountedPrice(100));
    }
    @Test
    void getDiscountedPricePremium() {
        PremiumMember premiumMember = new PremiumMember();
        assertEquals(0, premiumMember.getDiscountedPrice(100));
    }
}