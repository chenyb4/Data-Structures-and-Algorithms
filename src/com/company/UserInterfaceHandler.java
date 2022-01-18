package com.company;

import com.company.algorithms.Search;
import com.company.algorithms.Sort;
import com.company.datastructures.trees.AVLTree;
import com.company.datastructures.trees.Node;
import com.company.models.Client;
import com.company.models.Package;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.LinkedList;
import java.util.Date;
import java.util.Random;
import java.util.Scanner;

public class UserInterfaceHandler {

    LinkedList<Client> clients = new LinkedList<>();
    LinkedList<Package> packages = new LinkedList<>();
    AVLTree<Package> packageTree=new AVLTree<Package>();

    public UserInterfaceHandler() {
        Helper.readClientsFromCSV("src/com/company/csvFiles/Clients.csv",clients);
        Helper.readPackagesFromCSV("src/com/company/csvFiles/Packages.csv",packages,clients);
        Random rand=new Random();
        for (int i = 0; i < 10000000; i++) {
            packages.add(new Package(packages.getLast().getId()+1,50,30,100,clients.get(rand.nextInt(0,clients.size()-1)),new Date(),50));
        }

         for (Package p: packages) {
            packageTree.root=packageTree.insert(packageTree.root,p);
        }
        System.out.println(packages.getLast().getId());
    }

    //make it private later to call in UserInterface
    public void findTopTen()  {
        try {
            System.out.println("Please enter the start date: (dd-mm-yyyy)");
            Date startDate=new SimpleDateFormat("dd-MM-yyyy").parse(readString());
            System.out.println("Please enter the end date: (dd-mm-yyyy)");
            Date endDate=new SimpleDateFormat("dd-MM-yyyy").parse(readString());
            LinkedList<Package> tempPackages=new LinkedList<>();
            for (Package p: packages) {
                if(p.getEntryDate().after(startDate)&&p.getEntryDate().before(endDate)){
                    tempPackages.add(p);
                }
            }
            LinkedList<Client> tempClients = new LinkedList<>(clients);
            //find out for each client how many packages they receive
            for (Package p: tempPackages) {
                for (Client tempClient : tempClients) {
                    if (p.getClient().getId() == tempClient.getId()) {
                        tempClient.setNumberOfPackagesReceived(tempClient.getNumberOfPackagesReceived() + 1);
                    }
                }
            }
            //sort top 10
            Sort.selectionSort(tempClients,10);
            System.out.println("The top 10 recipients are: ");
            for (int i = 0; i < 10; i++) {
                System.out.println(tempClients.get(i).getName()+" has "+tempClients.get(i).getNumberOfPackagesReceived()+" packages.");
            }
        } catch (ParseException e) {
            System.err.println("Wrong format.");
        }
    }

    public void getPackageStatus(){
        System.out.println("Please enter the id of the package: ");
        int id=readInt();
        LinkedList<Package> tempPackages=new LinkedList<>(packages);
        Package temp = new Package(id);
        Search<Package> searchPackage=new Search<>();
        //To measure the time to execute the binary search
        Instant now=Instant.now();
        //binary search in LinkedList
        Package resultPackage= searchPackage.binarySearch(tempPackages,temp);
        Duration duration=Duration.between(now, Instant.now());
        if (resultPackage == null) {
            System.out.println("Package not found!");
        } else {
            System.out.println("Status: "+resultPackage.getStatus());
        }
        System.out.println("The time used for searching the package using binary search in the LinkedList is: " + duration.toNanos() + " nano sec.");
        System.out.println();
        //search in AVL tree
        //todo: check this
        Instant now1 = Instant.now();
        Node<Package> resultNode=packageTree.find(temp);
        Instant now2 = Instant.now();
        Duration duration2 = Duration.between(now1,now2);

        if (resultNode == null) {
            System.out.println("Package not found!");
        } else {
            System.out.println("Status: "+resultNode);
        }
        System.out.println("The time used for searching the package in the AVL tree is: " + duration2.toNanos() + " nano sec.");
    }

    //Read user input as a string
    public static String readString () {
        return new Scanner(System.in).nextLine();
    }

    //Read user input as integer
    public static int readInt () {
        return new Scanner(System.in).nextInt();
    }
}
