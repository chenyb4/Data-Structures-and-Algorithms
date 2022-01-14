package com.company.models;

import com.company.StatusType;

import java.util.Date;

public class Package implements Comparable<Package>{

    private int id, length, breadth,height;
    private Date entryDate;
    private double weight;
    private StatusType status;
    private Client client;

    //constructor
    public Package(int packageId, int length, int breadth, int height, Client client, Date entryDate, double weight) {
        this.id = packageId;
        this.length = length;
        this.breadth = breadth;
        this.height = height;
        this.client = client;
        this.entryDate = entryDate;
        this.weight = weight;
        this.status=StatusType.InDistributionCenter;
    }

    public Package(int id){
        this.id=id;
    }

    //Getters and Setters
    public int getId() {
        return id;
    }

    public int getLength() {
        return length;
    }

    public int getBreadth() {
        return breadth;
    }

    public int getHeight() {
        return height;
    }

    public Client getClient() {
        return client;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public double getWeight() {
        return weight;
    }

    public StatusType getStatus() {
        return status;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public void setBreadth(int breadth) {
        this.breadth = breadth;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setStatus(StatusType status) {
        this.status = status;
    }

    @Override
    public int compareTo(Package p) {
        return Integer.compare(id,p.id);
    }

    @Override
    public String toString() {
        return this.status+"";
    }
}
