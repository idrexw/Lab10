package edu.secourse.salonapp.services;

import edu.secourse.salonapp.models.Appointment;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AppointmentUserServiceTest {

    private AppointmentService appointmentService;

    @BeforeEach
    void setUp() {
        // Reset the service before each test to ensure a clean slate
        appointmentService = new AppointmentService();
    }

    @Test
    void createAppointment() {
        Appointment appt = new Appointment(10, 20, LocalDateTime.now());
        Appointment createdAppt = appointmentService.createAppointment(appt);

        assertNotNull(createdAppt, "Created appointment should not be null");
        assertEquals(10, createdAppt.getCustomerId(), "Customer ID should match");

        // Verify it was actually added to the underlying list
        List<Appointment> userAppts = appointmentService.getAppointmentsByUser(10);
        assertEquals(1, userAppts.size(), "There should be 1 appointment for this user");
    }

    @Test
    void getAppointmentsByUser() {
        LocalDateTime time = LocalDateTime.now();

        // Customer 101, Stylist 201
        appointmentService.createAppointment(new Appointment(101, 201, time));
        // Customer 102, Stylist 101 (User 101 is acting as a stylist here)
        appointmentService.createAppointment(new Appointment(102, 101, time));
        // Customer 103, Stylist 202 (User 101 is not involved)
        appointmentService.createAppointment(new Appointment(103, 202, time));

        // User 101 should be tied to exactly 2 appointments
        List<Appointment> results = appointmentService.getAppointmentsByUser(101);
        assertEquals(2, results.size(), "Should retrieve appointments where user is either customer or stylist");

        // User 999 has no appointments
        List<Appointment> emptyResults = appointmentService.getAppointmentsByUser(999);
        assertTrue(emptyResults.isEmpty(), "Should return an empty list for a user with no appointments");
    }

    @Test
    void cancelAppointment() {
        Appointment appt = new Appointment(1, 2, LocalDateTime.now());
        appointmentService.createAppointment(appt);
        int targetId = appt.getAppointmentId();

        // Test successful cancellation
        boolean isCanceled = appointmentService.cancelAppointment(targetId);
        assertTrue(isCanceled, "Cancellation should return true for an existing appointment");
        assertEquals("canceled", appt.getStatus(), "The appointment status should be updated to 'canceled'");

        // Test failing cancellation (wrong ID)
        boolean isCanceledFake = appointmentService.cancelAppointment(-99);
        assertFalse(isCanceledFake, "Cancellation should return false for a non-existent appointment");
    }

    @Test
    void updateAppointment() {
        LocalDateTime originalTime = LocalDateTime.of(2025, 1, 1, 12, 0);
        Appointment appt = new Appointment(1, 2, originalTime);
        appointmentService.createAppointment(appt);
        int targetId = appt.getAppointmentId();

        LocalDateTime newTime = LocalDateTime.of(2025, 2, 15, 14, 30);

        // Test successful update
        boolean isUpdated = appointmentService.updateAppointment(targetId, newTime);
        assertTrue(isUpdated, "Update should return true for an existing appointment");
        assertEquals(newTime, appt.getStartDateTime(), "The start date time should be correctly updated");

        // Test failing update (wrong ID)
        boolean isUpdatedFake = appointmentService.updateAppointment(-99, LocalDateTime.now());
        assertFalse(isUpdatedFake, "Update should return false for a non-existent appointment");
    }
}