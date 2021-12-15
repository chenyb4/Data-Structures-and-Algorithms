package com.company;

import com.company.algorithms.Search;
import com.company.datastructures.AVLTree;
import com.company.datastructures.Node;
import com.company.models.Client;
import com.company.models.Package;

import java.text.ParseException;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws ParseException {

        LinkedList<Client> clients = new LinkedList<>();
        LinkedList<Package> packages = new LinkedList<Package>();


        Helper.readClientsFromCSV("src/com/company/csvFiles/Clients.csv",clients);
        Helper.readPackagesFromCSV("src/com/company/csvFiles/Packages.csv",packages,clients);


        //try binary search
        /*Client temp= Search.binarySearchClients(clients,235027);

        Search<Client> search = new Search<Client>();
        System.out.println(search.binarySearch(clients,new Client(235050,null,null,0,0)).getName());

        Client temp2=Search.binarySearchClients(clients,888888888);

        System.out.println(temp.getName());

        System.out.println(temp2.getName());*/


        //get the number of packages sent to each client
       /*for (Package p:packages
        ) {
           System.out.println(p.getEntryDate());

           *//* for (int i = 0 ; i < clients.size(); i++) {
                if(p.getClient().getClientId()==clients.get(i).getClientId()){
                    clients.get(i).setNumberOfPackagesReceived(clients.get(i).getNumberOfPackagesReceived()+1);
                }
            }*//*

            for (int i = 0 ; i < clients.size(); i++) {
                if(p.getClient().getId()==clients.get(i).getId()){
                    clients.get(i).setNumberOfPackagesReceived(clients.get(i).getNumberOfPackagesReceived()+1);
                }
            }

        }
       
       AVLTree tree=new AVLTree();
        for (Package p: packages
             ) {
            tree.root=tree.insert(tree.root,p);
        }

        tree.delete(tree.root,packages.get(5));

        Node nodeToFind= tree.find(packages.get(4));
       // System.out.println(nodeToFind.key.getId()+" is the node found");

        System.out.println("Preorder traversal" +
                " of constructed tree is : ");

        tree.preOrder(tree.root);*/
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
