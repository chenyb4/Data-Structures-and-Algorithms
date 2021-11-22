package com.company;

import com.company.models.Client;
import com.company.models.Package;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<Client> clients = new ArrayList<>();
        ArrayList<Package> packages = new ArrayList<Package>();

        Helper.readClientsFromCSV("src/com/company/csvFiles/Clients.csv",clients);
        Helper.readPackagesFromCSV("src/com/company/csvFiles/Packages.csv",packages);


        for (Client c: clients
             ) {
            System.out.println(c.getName());
        }

        for (Package p: packages
             ) {
            System.out.println(p.getEntryDate());
        }




    }



}
