package edu.secourse.salonapp;

import edu.secourse.salonapp.models.User;

public class Main {
    public static void main(String[] args) {
        User test = new User("1", "1", "1", "2");
        System.out.println(test.getAccountId());
    }
}

