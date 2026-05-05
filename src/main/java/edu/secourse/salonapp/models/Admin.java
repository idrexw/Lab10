package edu.secourse.salonapp.models;

public class Admin extends User{

    public Admin(String un, String pw, String name, String emAddr, String role) {
        super(un, pw, name, emAddr, role);
        this.setRole(role);
    }
}
