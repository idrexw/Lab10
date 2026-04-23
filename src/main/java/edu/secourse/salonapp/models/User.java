package edu.secourse.salonapp.models;

import java.util.Random;

public class User {
    private int accountId;
    private String username;
    private String password;
    private String name;
    private String emailAddress;
    private String role;

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User(String un, String pw, String name, String emAddr, String role) {
        Random rand = new Random();
        this.accountId = rand.nextInt(10000000,99999999);
        this.username = un;
        this.password = pw;
        this.name = name;
        this.emailAddress = emAddr;
        this.role = role;
    }
}
