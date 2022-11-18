package com.example.demo.appUser;

public enum AppUserRole {
    /*
    Difference between Enums and Classes
    The only difference is that enum constants are public , static and final (unchangeable - cannot be overridden).
    An enum cannot be used to create objects, and it cannot extend other classes (but it can implement interfaces).
    Use enums when you have values that you know aren't going to change, like month days, days, colors, deck of cards, etc.
     */
    USER,
    ADMIN
}
