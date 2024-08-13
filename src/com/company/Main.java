package com.company;

import com.company.datastructures.linkedlist.LinkedList;
import com.company.models.UserInterface;

import javax.swing.plaf.IconUIResource;

public class Main {

    public static void main(String[] args) {

        UserInterface userInterface=new UserInterface(new UserInterfaceHandler());

        userInterface.startUserInterface();
        //change



    }

}
