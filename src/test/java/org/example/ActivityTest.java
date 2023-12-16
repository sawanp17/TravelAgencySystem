package org.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

class ActivityTest {

    @Test
    void registerTestSuccess() {
        ActivityRegistration activityRegistration = Mockito.mock(ActivityRegistration.class);
        Activity activity = new Activity("abc","abc",100,5);
        assertTrue(activity.register(activityRegistration));
        assertEquals(List.of(activityRegistration),activity.getRegistrationList());
    }

    @Test
    void registerTestFailure() {
        ActivityRegistration activityRegistration1 = Mockito.mock(ActivityRegistration.class);
        ActivityRegistration activityRegistration2 = Mockito.mock(ActivityRegistration.class);
        ActivityRegistration activityRegistration3 = Mockito.mock(ActivityRegistration.class);

        Activity  activity = new Activity("abc","abc",200,2);
        assertTrue(activity.register(activityRegistration1));
        assertTrue(activity.register(activityRegistration2));
        assertFalse(activity.register(activityRegistration3));
    }
}