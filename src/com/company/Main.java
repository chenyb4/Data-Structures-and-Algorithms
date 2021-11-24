package com.company;

import com.company.models.Client;
import com.company.models.Package;

import java.util.ArrayList;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        ArrayList<Client> clients = new ArrayList<>();
        ArrayList<Package> packages = new ArrayList<Package>();


        Helper.readClientsFromCSV("src/com/company/csvFiles/Clients.csv",clients);
        Helper.readPackagesFromCSV("src/com/company/csvFiles/Packages.csv",packages,clients);


        //get the number of packages sent to each client
        for (Package p:packages
             ) {
            for (int i = 0 ; i < clients.size(); i++) {
                if(p.getClient().getClientId()==clients.get(i).getClientId()){
                    clients.get(i).setNumberOfPackagesReceived(clients.get(i).getNumberOfPackagesReceived()+1);
                }
            }
        }

        //sort on number of packages sent to each client





        for (Client c: clients
             ) {
            System.out.println(c.getName()+" : "+c.getNumberOfPackagesReceived());
        }


        /*

        for (Package p: packages
             ) {
            System.out.println(p.getPackageId());
        }

        Helper.sort(packages);
        System.out.println("After sorting packages:");


        for (Package p: packages
        ) {
            System.out.println(p.getPackageId());
        }*/



    }



}
