package edu.secourse.salonapp.services;
import edu.secourse.salonapp.models.Appointment;

import java.time.LocalDateTime;
import java.util.*;

public class AppointmentService {
    private List<Appointment> appointments = new ArrayList<>();

    public Appointment createAppointment(Appointment appt) {
        appointments.add(appt);
        return appt;
    }

    public List<Appointment> getAppointmentsByUser(int userId) {
        List<Appointment> result = new ArrayList<>();
        for (Appointment a : appointments) {
            if (a.getCustomerId() == userId || a.getStylistId() == userId) {
                result.add(a);
            }
        }
        return result;
    }

    public boolean cancelAppointment(int id) {
        for (Appointment a : appointments) {
            if (a.getAppointmentId() == id) {
                a.setStatus("canceled");
                return true;
            }
        }
        return false;
    }

    public boolean updateAppointment(int id, LocalDateTime newTime) {
        for (Appointment a : appointments) {
            if (a.getAppointmentId() == id) {
                a.setStartDateTime(newTime);
                return true;
            }
        }
        return false;
    }
}