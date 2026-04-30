package edu.secourse.salonapp.models;

public class Customer extends User {

    public Customer(String un, String pw, String name, String emAddr) {
        super(un, pw, name, emAddr);
        this.setRole("customer");
    }
}