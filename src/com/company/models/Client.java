package com.company.models;

import java.util.LinkedList;
import java.util.LinkedList;

public class Client implements Comparable<Client>{

    //fields
    public int id;
    private String name;
    private String initials;
    private int addressX;
    private int addressY;
    private int numberOfPackagesReceived;

    //constructor
    public Client(int clientId, String name, String initials, int addressX, int addressY) {
        this.id = clientId;
        this.name = name;
        this.initials = initials;
        this.addressX = addressX;
        this.addressY = addressY;
        this.numberOfPackagesReceived=0;
    }

    //static methods
    public static Client findClientByID(LinkedList<Client> clientList, int id){
        for (Client c:clientList
        ) {
            if(c.getId()==id){
                return c;
            }
        }
        return null;
    }

    //Getters and Setters
    public int getId() {
        return id;
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

    public int getNumberOfPackagesReceived() {
        return numberOfPackagesReceived;
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

    public void setNumberOfPackagesReceived(int numberOfPackagesReceived) {
        this.numberOfPackagesReceived = numberOfPackagesReceived;
    }

    @Override
    public int compareTo(Client o) {
        return Integer.compare(id,o.id);
    }


}
