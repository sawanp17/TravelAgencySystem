package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

class PassengerTest {

    @Test
    void registerTestStandardUserSuccess(){
        RegistrationService registrationService = Mockito.mock(RegistrationService.class);
        Registration mockRegistration = Mockito.mock(Registration.class);
        StandardMember membership = Mockito.mock(StandardMember.class);

        Activity activity1 = Mockito.mock(Activity.class);
        Passenger passenger = new Passenger("abc", 123,membership,200);
        when(membership.getName()).thenReturn("STANDARD");
//        when(membership.getMaxBalance()).thenReturn(200F);
        when(membership.getDiscountedPrice(activity1.cost)).thenReturn(100F);
        when(membership.getDiscountedPrice(Mockito.anyFloat())).thenReturn(100F);
        when(activity1.getRegistrationList()).thenReturn(new ArrayList<>());
        when(activity1.getCapacity()).thenReturn(5);

        boolean ans = passenger.register(activity1);
        assertEquals(100,passenger.getBalance());
        assertEquals(1,passenger.getRegistrationList().size());
        List<Activity> actualListOfActivities = new ArrayList<>();
        for (Registration it: passenger.registrationList){
            actualListOfActivities.add(it.getActivity());
        }
        assertEquals(List.of(activity1), actualListOfActivities);
    }

    @Test
    void registerTestStandardUserFailure(){
        RegistrationService registrationService = Mockito.mock(RegistrationService.class);
        Registration mockRegistration = Mockito.mock(Registration.class);
        StandardMember membership = Mockito.mock(StandardMember.class);

        Activity activity1 = Mockito.mock(Activity.class);
        Passenger passenger = new Passenger("abc", 123,membership,10);
        when(membership.getName()).thenReturn("STANDARD");
//        when(membership.getMaxBalance()).thenReturn(200F);
        when(membership.getDiscountedPrice(activity1.cost)).thenReturn(100F);
        when(membership.getDiscountedPrice(Mockito.anyFloat())).thenReturn(100F);
        when(activity1.getRegistrationList()).thenReturn(new ArrayList<>());
        when(activity1.getCapacity()).thenReturn(5);

        boolean ans = passenger.register(activity1);
        assertFalse(ans);
        assertEquals(10,passenger.getBalance());
        assertEquals(0,passenger.getRegistrationList().size());
        List<Activity> actualListOfActivities = new ArrayList<>();
        for (Registration it: passenger.registrationList){
            actualListOfActivities.add(it.getActivity());
        }
        assertNotEquals(List.of(activity1), actualListOfActivities);
    }

    @Test
    void registerTestGoldUserSuccess(){
        RegistrationService registrationService = Mockito.mock(RegistrationService.class);
        Registration mockRegistration = Mockito.mock(Registration.class);
        GoldMember membership = Mockito.mock(GoldMember.class);

        Activity activity1 = Mockito.mock(Activity.class);
        Passenger passenger = new Passenger("abc", 123,membership,200);
        when(membership.getName()).thenReturn("STANDARD");
//        when(membership.getMaxBalance()).thenReturn(200F);
        when(membership.getDiscountedPrice(Mockito.anyFloat())).thenReturn(90F);
        when(activity1.getRegistrationList()).thenReturn(new ArrayList<>());
        when(activity1.getCapacity()).thenReturn(5);

        boolean ans = passenger.register(activity1);
        assertEquals(110,passenger.getBalance());
        assertEquals(1,passenger.getRegistrationList().size());
        List<Activity> actualListOfActivities = new ArrayList<>();
        for (Registration it: passenger.registrationList){
            actualListOfActivities.add(it.getActivity());
        }
        assertEquals(List.of(activity1), actualListOfActivities);
    }

    @Test
    void registerTestGoldUserFailure(){
        RegistrationService registrationService = Mockito.mock(RegistrationService.class);
        Registration mockRegistration = Mockito.mock(Registration.class);
        GoldMember membership = Mockito.mock(GoldMember.class);

        Activity activity1 = Mockito.mock(Activity.class);
        Passenger passenger = new Passenger("abc", 123,membership,20);
        when(membership.getName()).thenReturn("STANDARD");
//        when(membership.getBalance()).thenReturn(200F);
        when(membership.getDiscountedPrice(Mockito.anyFloat())).thenReturn(90F);
        when(activity1.getRegistrationList()).thenReturn(new ArrayList<>());
        when(activity1.getCapacity()).thenReturn(5);

        boolean ans = passenger.register(activity1);
        assertEquals(20,passenger.getBalance());
        assertEquals(0,passenger.getRegistrationList().size());
        List<Activity> actualListOfActivities = new ArrayList<>();
        for (Registration it: passenger.registrationList){
            actualListOfActivities.add(it.getActivity());
        }
        assertNotEquals(List.of(activity1), actualListOfActivities);
    }

}