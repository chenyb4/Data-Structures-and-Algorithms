package com.company.models;

import java.util.Date;

public class Package {

    private int packageId, length, breadth,height,clientId;
    private Date entryDate;
    private double weight;



    //getters and files
    public int getPackageId() {
        return packageId;
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

    public int getClientId() {
        return clientId;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public double getWeight() {
        return weight;
    }

    public void setPackageId(int packageId) {
        this.packageId = packageId;
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

    public void setClientId(int clientId) {
        this.clientId = clientId;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }


    //construcors

    public Package(int packageId, int length, int breadth, int height, int clientId, Date entryDate, double weight) {
        this.packageId = packageId;
        this.length = length;
        this.breadth = breadth;
        this.height = height;
        this.clientId = clientId;
        this.entryDate = entryDate;
        this.weight = weight;
    }
}
