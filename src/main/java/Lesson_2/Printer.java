package Lesson_2;

import models.Parent;
import models.User;

public class Printer {

    public static void printUserData(User user) {
        System.out.println("User name: " + user.getUsername());
        System.out.println("User password: " + user.getPassword());
        System.out.println("User role: " + user.getRole());
        System.out.println("User creation date: " + user.getCreationDate());
    }

    public static void printData(Parent parent) {
        System.out.println("Name: " + parent.getName());
    }

}
