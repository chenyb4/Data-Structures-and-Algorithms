package com.company;

import com.company.algorithms.Search;
import com.company.models.Client;
import com.company.models.Package;

import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {

        LinkedList<Client> clients = new LinkedList<>();
        LinkedList<Package> packages = new LinkedList<Package>();


        Helper.readClientsFromCSV("src/com/company/csvFiles/Clients.csv",clients);
        Helper.readPackagesFromCSV("src/com/company/csvFiles/Packages.csv",packages,clients);

        //try binary search
        Client temp= Search.binarySearchClients(clients,235027);


        Client temp2=Search.binarySearchClients(clients,888888888);

        System.out.println(temp.getName());

        System.out.println(temp2.getName());

        //get the number of packages sent to each client
     /*   for (Package p:packages
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

*/
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
