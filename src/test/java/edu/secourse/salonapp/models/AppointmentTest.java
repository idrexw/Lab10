package edu.secourse.salonapp.models;

import org.junit.jupiter.api.Test;
import java.time.LocalDateTime;
import static org.junit.jupiter.api.Assertions.*;

class AppointmentTest {

    @Test
    void testAppointmentCreationAndGetters() {
        LocalDateTime time = LocalDateTime.of(2026, 5, 5, 10, 0);
        Appointment appt = new Appointment(101, 202, time);

        // Verify initial state
        assertEquals(101, appt.getCustomerId(), "Customer ID should match");
        assertEquals(202, appt.getStylistId(), "Stylist ID should match");
        assertEquals(time, appt.getStartDateTime(), "Time should match");
        assertEquals("active", appt.getStatus(), "Default status should be 'active'");
        assertTrue(appt.getAppointmentId() > 0, "Appointment ID should be generated");
    }

    @Test
    void testSetStartDateTime() {
        Appointment appt = new Appointment(1, 2, LocalDateTime.now());
        LocalDateTime newTime = LocalDateTime.now().plusDays(1);
        appt.setStartDateTime(newTime);

        assertEquals(newTime, appt.getStartDateTime(), "Start date time should update");
    }

    @Test
    void testSetStatus() {
        Appointment appt = new Appointment(1, 2, LocalDateTime.now());
        appt.setStatus("canceled");

        assertEquals("canceled", appt.getStatus(), "Status should update to 'canceled'");
    }

    @Test
    void testUniqueIds() {
        // Because of the static counter, these should inherently be different
        Appointment appt1 = new Appointment(1, 2, LocalDateTime.now());
        Appointment appt2 = new Appointment(3, 4, LocalDateTime.now());

        assertNotEquals(appt1.getAppointmentId(), appt2.getAppointmentId(), "Every appointment needs a unique ID");
    }
}