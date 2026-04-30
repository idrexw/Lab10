package edu.secourse.salonapp.controllers;


import edu.secourse.salonapp.models.User;
import edu.secourse.salonapp.services.UserService;
import java.util.Scanner;

public class UserController {
    private UserService userService;
    private Scanner scanner;

        public UserController(UserService userService){
            this.userService = userService;
            this.scanner = new Scanner(System.in);

        }

        public void createUserInfo(){
            System.out.print("Username: ");
            String un = scanner.nextLine();
            System.out.print("Password: ");
            String pw = scanner.nextLine();
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Role (C/S/A): ");
            String role = scanner.nextLine();

            User newUser = new User(un, pw, name, email, role);
            userService.createUser(newUser);

        }

        public void updateUserInfo(){
            System.out.println("enter Account Id to update: ");
            int id = Integer.parseInt(scanner.nextLine());
            System.out.println("New name: ");
            String name = scanner.nextLine();
            System.out.println("New email: ");
            String email = scanner.nextLine();
            userService.updateUser(id, name, email);
        }

        public void removeUserInfo(){
            System.out.println("Enter Account Id to remove: ");
            int id = Integer.parseInt(scanner.nextLine());
            userService.removeUser(id);
        }

}
