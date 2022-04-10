package com.company.models;

import com.company.UserInterfaceHandler;

import javax.sound.midi.spi.SoundbankReader;
import java.util.*;

public class UserInterface {

    private UserInterfaceHandler handler;

    public UserInterfaceHandler getHandler() {
        return handler;
    }

    //Constructor
    public UserInterface(UserInterfaceHandler handler) {
        this.handler = handler;
    }

    /**
     * This is where the user select one of the menu items and does some operation with it
     */

    public void startUserInterface () {
        menuItems();
        String userInput = readString();
        do {
            switch (userInput) {
                case "1" -> handler.getPackageStatus();
                case "2" -> handler.findTopTen();
                case "3" -> handler.dijkstraPrototype();
                case "4" -> handler.primPrototype();
                case "5" -> handler.graphPrototype();
                case "?" -> menuItems();
                case "0" -> {
                    System.out.println("Goodbye!");
                    System.exit(0);
                }
                default -> System.err.println("Invalid input");
            }
            userInput = readString();
        } while (!userInput.equals("0"));
    }

    //All the menu items will be displayed here
    public static void menuItems () {
        System.out.println("Please choose one of the following menu items: \n" +
                "1) to find a package by package id. \n" +
                "2) to find the top 10 recipients in a period. \n" +
                "3) to run the prototype of finding the shortest route using Dijkstra algorithm.  \n" +
                "4) to run the prototype of finding the minimum spanning tree of addresses with Prim algorithm\n" +
                "5) ro run the prototype of find the shortest route using graph\n"+
                "?) to see this menu again.\n" +
                "0) to exit. \n");
    }

    //Read user input as a string
    public static String readString () {
        return new Scanner(System.in).nextLine();
    }
}
