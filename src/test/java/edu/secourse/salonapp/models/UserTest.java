package edu.secourse.salonapp.models;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    Stylist testStylist = new Stylist("username", "password", "name", "email", "S");
    Customer testCustomer = new Customer("username", "password", "name", "email", "C");
    Admin testAdmin = new Admin("username", "password", "name", "email", "A");
}