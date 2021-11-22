package com.company.models;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Client {

    //fields
    private int clientId;
    private String name;
    private String initials;
    private int addressX;
    private int addressY;

    //getteres and setters
    public int getClientId() {
        return clientId;
    }

    public String getName() {
        return name;
    }

    public String getInitials() {
        return initials;
    }

    public int getAddressX() {
        return addressX;
    }

    public int getAddressY() {
        return addressY;
    }

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInitials(String initials) {
        this.initials = initials;
    }

    public void setAddressX(int addressX) {
        this.addressX = addressX;
    }

    public void setAddressY(int addressY) {
        this.addressY = addressY;
    }

    //constructors
    public Client(int clientId, String name, String initials, int addressX, int addressY) {
        this.clientId = clientId;
        this.name = name;
        this.initials = initials;
        this.addressX = addressX;
        this.addressY = addressY;
    }




}
