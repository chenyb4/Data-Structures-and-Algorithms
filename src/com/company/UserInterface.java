package com.company;

import java.util.Scanner;

public class UserInterface {

    //private MainHandler mainHandler;

    //Constructor
    //public UserInterface(MainHandler mainHandler) {
    //    this.mainHandler = mainHandler;
    //}

    /**
     * This is where the user select one of the menu items and does some operation with it
     */

    public static void userInterface () {
        menuItems();
        String userInput = readString();
        do {
            switch (userInput) {
                case "1" -> {}
                case "2" -> {}
                case "3" -> {}
                case "4" -> {}
                case "5" -> {}
                case "?" -> menuItems();
                case "0" -> System.out.println("Goodbye");
                default -> System.err.println("Invalid input");
            }
            userInput = readString();
        } while (!userInput.equals("0"));
    }

    //All the menu items will be displayed here
    public static void menuItems () {
        System.out.println("Please choose one of the following items: \n" +
                "1) \n" +
                "2) \n" +
                "3) \n" +
                "4) \n" +
                "5) \n" +
                "?) This menu" +
                "0) Exit");
        //.....
    }

    //Read user input as a string
    public static String readString () {
        return new Scanner(System.in).nextLine();
    }

    //Read user input as integer
    public static int readInt () {
        return new Scanner(System.in).nextInt();
    }
}
