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
import java.util.*;

public class UserInterfaceHandler {

    LinkedList<Client> clients = new LinkedList<>();
    LinkedList<Package> packages = new LinkedList<>();
    AVLTree<Package> packageTree=new AVLTree<>();

    public UserInterfaceHandler() {
        //Read from the CSV file of clients
        Helper.readClientsFromCSV("src/com/company/csvFiles/Clients.csv",clients);
        //Read from the CSV file of Packages
        Helper.readPackagesFromCSV("src/com/company/csvFiles/Packages.csv",packages,clients);
        assert clients.size() > 0 && packages.size() > 0 : "Clients or Packages were not loaded to the list"; //Post-cond
        //Get random value
        Random rand=new Random();
        assert packages.size() > 0 : "Packages list is empty!"; //Pre-cond
        for (int i = 0; i < 500000; i++) {
            packages.add(new Package(packages.get(packages.size()-1).getId()+1,50,30,100,clients.get(rand.nextInt(0,clients.size()-1)),new Date(),50));
        }
        //assert packages.size() > 10000000 : "Random packages were not loaded correctly to the package list"; //Post-cond
        Instant now = Instant.now();
        for (Package p: packages) {
            packageTree.root=packageTree.insert(packageTree.root,p);
        }
        Duration duration = Duration.between(now,Instant.now());
        System.out.println("Time took to insert in AVLTree: "  +duration.toNanos() + " nano sec");
        System.out.println(packages.get(packages.size()-1).getId());
    }

    //make it private later to call in UserInterface
    public void findTopTen()  {
        try {
            //todo: fix this
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            System.out.println("Please enter the start date: (dd-MM-yyyy) ");
            Date startDate = sdf.parse(readString());
            //assert  : "Start date should be between 1 and 31"; //Post-cond
            System.out.println("Please enter the end date: (dd-MM-yyyy) ");
            Date endDate = sdf.parse(readString());
            //assert endDate > 0 && endDate < 32 : "End date should be before 1 to 31"; //Post-cond
            LinkedList<Package> tempPackages=new LinkedList<>();
            //Date srtDate = sdf.parse(endDate+"-12-2021");
            //Date enDate = sdf.parse(endDate+"-12-2021");
            for (Package p: packages) {
                if(p.getEntryDate().after(startDate) && p.getEntryDate().before(endDate)){
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
            System.err.println(e.getMessage());
        }
    }

    public void getPackageStatus(){
        System.out.println("Please enter the id of the package: ");
        int id=readInt();
        Package temp = new Package(id);
        LinkedList<Package> tempPackages=new LinkedList<>(packages);
        binarySearch(tempPackages,temp);
        ArrayList<Package> tempPackages1 = new ArrayList<>();
        Instant now = Instant.now();
        for (Package p: packages) {
            tempPackages1.add(p);
        }
        System.out.println("Time took to insert packages into ArrayList: "+Duration.between(now,Instant.now()).toNanos() +" nano sec");
        binarySearch(tempPackages1,temp);
        //search in AVL tree
        searchAVLTree(temp);
    }

    public void searchAVLTree (Package p) {
        Instant now = Instant.now();
        Node<Package> resultNode=packageTree.find(p);
        Duration duration = Duration.between(now,Instant.now());
        if (resultNode == null) {
            System.out.println("Package not found!");
        } else {
            System.out.println("Status: "+resultNode);
        }
        System.out.println("The time used for searching the package in the AVL tree is: " + duration.toNanos() + " nano sec.");
    }


    public void binarySearch (List<Package> list,Package p) {
        Search<Package> searchPackage=new Search<>();
        //To measure the time to execute the binary search
        Instant now = Instant.now();
        //binary search in LinkedList
        Package resultPackage= searchPackage.binarySearch(list,p);
        Duration duration = Duration.between(now, Instant.now());
        if (resultPackage == null) {
            System.out.println("Package not found!");
        } else {
            System.out.println(resultPackage.getId());
            System.out.println("Status: "+resultPackage.getStatus());
        }
        System.out.println("The time used for searching the package using binary search in the LinkedList is: " + duration.toNanos() + " nano sec.");
        System.out.println();
    }

    //Read user input as a string
    public static String readString () {
        return new Scanner(System.in).nextLine();
    }

    //Read user input as integer
    public static int readInt () {
        int input = -1;
        Scanner sc = new Scanner(System.in);
        while (!sc.hasNextInt()) sc.next();
        input = sc.nextInt();
        return input;
    }
}
