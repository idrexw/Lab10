package edu.secourse.salonapp.controllers;

import edu.secourse.salonapp.models.Appointment;
import edu.secourse.salonapp.services.AppointmentService;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class AppointmentController {

    private final AppointmentService appointmentService;
    private final Scanner scanner;

    public AppointmentController(AppointmentService appointmentService){
        this.appointmentService = appointmentService;
        this.scanner = new Scanner(System.in);
    }

    public void createAppointmentInfo(){
        System.out.println("Customer Id: ");
        int customerId = Integer.parseInt(scanner.nextLine());
        System.out.println("Stylist Id: ");
        int stylistId = Integer.parseInt(scanner.nextLine());
        System.out.println("Time (MM-dd-yyyy HH:mm): ");
        String date = scanner.nextLine();
        LocalDateTime time = LocalDateTime.parse(date, DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm"));

        Appointment appt = new Appointment(customerId, stylistId, time);
        appointmentService.createAppointment(appt);
    }

    public void cancelAppointmentInfo(){
        System.out.println("Enter Appointment Id to remove: ");
        int id = Integer.parseInt(scanner.nextLine());
        appointmentService.cancelAppointment(id);
    }

    public void viewUserAppointments(){
        System.out.println("Enter User Id: ");
        int id = Integer.parseInt(scanner.nextLine());
        for(Appointment a : appointmentService.getAppointmentsByUser(id)){
            System.out.println("Id: " + a.getAppointmentId() + " | Status: " + a.getStatus());
        }
    }

}
