package edu.secourse.salonapp.services;

import edu.secourse.salonapp.models.Admin;
import edu.secourse.salonapp.models.Customer;
import edu.secourse.salonapp.models.Stylist;
import edu.secourse.salonapp.models.User;

import java.util.ArrayList;
import java.util.List;

public class UserService {
    private final List<User> users;

    public UserService(List<User> users) {
        this.users = users;
    }

    public void createUser(String username, String password, String name, String email, String role){
        User newUser;
        switch (role.toUpperCase()){
            case "S" -> { newUser = new Stylist(username, password, name, email, role); }
            case "A" -> { newUser = new Admin(username, password, name, email, role); }
            case "C" -> { newUser = new Customer(username, password, name, email, role); }
            default -> {
                System.err.println("Role Not Assigned Properly to user " + role.toUpperCase() + ".");
                newUser = new User(username, password, name, email);
            }
        }
        this.users.add(newUser);
    }

    public void removeUser(int accountId) {
        User user = getUser(accountId);
        this.users.remove(user);
    }

    public User getUser(int accountId) {
        for (User user : users) {
            if (user.getAccountId() == accountId) {
                return user;
            }
        }
        return null;
    }
}
