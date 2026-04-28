package edu.secourse.salonapp.models;
import java.time.LocalDateTime;

public class Appointment {
    private static int counter = 1;
    private int appointmentId;
    private int customerId;
    private int stylistId;
    private LocalDateTime startDateTime;
    private String status;

    public Appointment(int customerId, int stylistId, LocalDateTime startDateTime) {
        this.appointmentId = counter++;
        this.customerId = customerId;
        this.stylistId = stylistId;
        this.startDateTime = startDateTime;
        this.status = "active";

    }
    public int getAppointmentId() {
        return appointmentId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getStylistId() {
        return stylistId;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStartDateTime(LocalDateTime startDateTime) {
        this.startDateTime = startDateTime;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}