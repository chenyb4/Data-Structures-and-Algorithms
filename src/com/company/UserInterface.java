package com.company;

import com.company.algorithms.Search;
import com.company.algorithms.Sort;
import com.company.datastructures.AVLTree;
import com.company.datastructures.Node;
import com.company.models.Client;
import com.company.models.Package;

import java.awt.image.AreaAveragingScaleFilter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;
import java.util.*;

public class UserInterface {

    //private MainHandler mainHandler;

    //Constructor
    //public UserInterface(MainHandler mainHandler) {
    //    this.mainHandler = mainHandler;
    //}

    /**
     * This is where the user select one of the menu items and does some operation with it
     */
    static ArrayList<Client> clients = new ArrayList<>();

    static ArrayList<Package> packages = new ArrayList<>();

    static AVLTree packageTree=new AVLTree();




    public static void userInterface () {
        menuItems();
        Helper.readClientsFromCSV("src/com/company/csvFiles/Clients.csv",clients);
        Helper.readPackagesFromCSV("src/com/company/csvFiles/Packages.csv",packages,clients);

        Instant now=Instant.now();
        Collections.sort(packages);
        Duration d=Duration.between(now,Instant.now());
        System.out.println("sort time: "+d.toNanos());

        /*for (Package p: packages
        ) {
            packageTree.root=packageTree.insert(packageTree.root,p);
        }
*/

        String userInput = readString();
        do {
            switch (userInput) {
                case "1" -> getPackageStatus();
                case "2" -> findTopTen();
                case "3" -> {}
                case "4" -> {}
                case "5" -> {}
                case "?" -> menuItems();
                case "0" -> System.out.println("Goodbye");
                default -> System.err.println("Invalid input");
            }
            userInput = readString();
        } while (!userInput.equals("0"));
    }


    //All the menu items will be displayed here
    public static void menuItems () {
        System.out.println("Please choose one of the following items: \n" +
                "1) to find a package by package id. \n" +
                "2) to find the top 10 recipients in a period. \n" +
                "3) \n" +
                "4) \n" +
                "5) \n" +
                "?) This menu" +
                "0) Exit");
        //.....
    }

    //make it private later to call in UserInterface
    private static void findTopTen()  {
        try {


            System.out.println("Please enter the start date: (dd-mm-yyyy)");
            Date startDate=new SimpleDateFormat("dd-MM-yyyy").parse(readString());
            System.out.println("Please enter the end date: (dd-mm-yyyy)");
            Date endDate=new SimpleDateFormat("dd-MM-yyyy").parse(readString());

            ArrayList<Package> tempPackages=new ArrayList<>();
            for (Package p: packages
                 ) {
                if(p.getEntryDate().after(startDate)&&p.getEntryDate().before(endDate)){
                    tempPackages.add(p);
                }
            }


        ArrayList<Client> tempClients=new ArrayList<>(clients);

            //find out for each client how many pakcages they receive
            for (Package p:tempPackages
            ) {
                for (int i = 0 ; i < tempClients.size(); i++) {
                    if(p.getClient().getId()==tempClients.get(i).getId()){
                        tempClients.get(i).setNumberOfPackagesReceived(tempClients.get(i).getNumberOfPackagesReceived()+1);
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


    private static void getPackageStatus(){
        for (int i = 0; i < 20; i++) {
            System.out.println(packages.get(i).getId());
        }

        System.out.println("Please enter the id of the package: ");
        int id=readInt();
        ArrayList<Package> tempPackages=new ArrayList<>(packages);
        Package temp=new Package(id);
        Search<Package> searchPackage=new Search<>();


        //binary search in arraylist
        Instant now=Instant.now();
        Package resultPackage= searchPackage.binarySearch(tempPackages,temp);
        Duration duration=Duration.between(now, Instant.now());

        if(resultPackage==null){
            System.out.println("Package not found!");
        }else{
            System.out.println("Status: "+resultPackage.getStatus());
        }
        System.out.println("The time used for searching the package using binary search in the arraylist is: "+duration.toNanos()+" nano sec.");


        System.out.println();

       /* //search in AVL tree
        Instant now1=Instant.now();
        Node resultNode=packageTree.find(temp);
        Duration duration2=Duration.between(now1,Instant.now());

        if(resultNode==null){
            System.out.println("Package not found!");
        }else{
            System.out.println("Status: "+resultNode);
        }

        System.out.println("The time used for searching the package in the AVL tree is: "+duration2.toNanos()+" nano sec.");

*/




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
