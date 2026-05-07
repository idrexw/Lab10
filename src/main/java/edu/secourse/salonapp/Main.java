package edu.secourse.salonapp;

import edu.secourse.salonapp.controllers.AppointmentController;
import edu.secourse.salonapp.controllers.UserController;
import edu.secourse.salonapp.services.AppointmentService;
import edu.secourse.salonapp.services.UserService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // 1. Initialize the Services
        UserService userService = new UserService();
        AppointmentService appointmentService = new AppointmentService();

        // 2. Initialize the Controllers and pass the services to them
        UserController userController = new UserController(userService);
        AppointmentController appointmentController = new AppointmentController(appointmentService);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        System.out.println("Welcome to the Salon App!");

        // 3. Create a menu loop
        while (running) {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Create User");
            System.out.println("2. Update User");
            System.out.println("3. Remove User");
            System.out.println("4. Create Appointment");
            System.out.println("5. Cancel Appointment");
            System.out.println("6. View User Appointments");
            System.out.println("7. Exit");
            System.out.print("Choose an option: ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    userController.createUserInfo();
                    System.out.println("User created!");
                    break;
                case "2":
                    userController.updateUserInfo();
                    break;
                case "3":
                    userController.removeUserInfo();
                    System.out.println("User removed (if they existed).");
                    break;
                case "4":
                    appointmentController.createAppointmentInfo();
                    System.out.println("Appointment created!");
                    break;
                case "5":
                    appointmentController.cancelAppointmentInfo();
                    break;
                case "6":
                    appointmentController.viewUserAppointments();
                    break;
                case "7":
                    running = false;
                    System.out.println("Exiting application...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close();
    }
}