package org.example;

public abstract class Membership {
    public abstract float getDiscountRate();
//    public abstract float getMaxBalance();
    public abstract String getName();
    public float getDiscountedPrice(float price){
        return price * (1 - (this.getDiscountRate()/100));
    }
}
