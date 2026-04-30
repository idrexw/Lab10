package edu.secourse.salonapp.services;

import edu.secourse.salonapp.models.User;

import java.util.List;

public class UserService {
    private List<User> users;
    public static void assignRole(User u, String s){
        switch (s.toUpperCase()) {
            case "S" -> u.setRole("Stylist");
            case "A" -> u.setRole("Admin");
            case "C" -> u.setRole("Customer");
            default -> System.err.println("Role Not Assigned Properly to user " + u.getAccountId() + ".");
        }
    }
}
