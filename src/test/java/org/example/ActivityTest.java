package org.example;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.same;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

class ActivityTest {

    @Test
    void registerTestSuccess() {
        Registration registration = Mockito.mock(Registration.class);
        Activity activity = new Activity("abc","abc",100,5);
        assertTrue(activity.register(registration));
        assertEquals(List.of(registration),activity.getRegistrationList());
    }

    @Test
    void registerTestFailure() {
        Registration registration1 = Mockito.mock(Registration.class);
        Registration registration2 = Mockito.mock(Registration.class);
        Registration registration3 = Mockito.mock(Registration.class);

        Activity  activity = new Activity("abc","abc",200,2);
        assertTrue(activity.register(registration1));
        assertTrue(activity.register(registration2));
        assertFalse(activity.register(registration3));
    }
}