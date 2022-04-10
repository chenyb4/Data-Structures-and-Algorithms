package com.company;

import com.company.algorithms.Search;
import com.company.algorithms.Sort;
import com.company.datastructures.linkedlist.LinkedList;
import com.company.datastructures.trees.AVLTree;
import com.company.datastructures.trees.Node;
import com.company.models.Client;
import com.company.models.Package;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.Instant;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.company.dijkstra.DijkstraAlgorithm;

import com.company.dijkstra.Graph;
import com.company.prim.MinimumSpanningTree;


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
       /* Random rand=new Random();
        //assert packages.size() > 0 : "Packages list is empty!"; //Pre-cond
        for (int i = 0; i < 500000; i++) {
            packages.add(new Package(packages.get(packages.size()-1).getId()+1,50,30,100,clients.get(rand.nextInt(0,clients.size()-1)),new Date(),50));
        }
        assert packages.size() > 500000 : "Random packages were not loaded correctly to the package list"; //Post-cond
        */

        Instant now = Instant.now();
        for (int i = 0; i <packages.size(); i++) {
            packageTree.root=packageTree.insert(packageTree.root,packages.get(i));
        }



        Duration duration = Duration.between(now,Instant.now());
        System.out.println("Time took to insert in AVLTree: "  +duration.toNanos() + " nano sec");
        System.out.println("Leaf of the package tree: "+packages.get(packages.size()-1).getId());
      //  System.out.println("Time took to insert in AVLTree: "  +duration.toNanos() + " nano sec");
       // System.out.println(packages.get(packages.size()-1).getId());
    }

    //make it private later to call in UserInterface
    public void findTopTen()  {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
            System.out.println("Please enter the start date: (dd-MM-yyyy) ");
            //If date is in wrong format than an error will be thrown
            Date startDate = sdf.parse(readString());
            System.out.println("Please enter the end date: (dd-MM-yyyy) ");
            Date endDate = sdf.parse(readString());
            //The same here
            LinkedList<Package> tempPackages=new LinkedList<>();

            for (int i = 0; i <packages.size(); i++) {
                if(packages.get(i).getEntryDate().after(startDate) && packages.get(i).getEntryDate().before(endDate)){
                    tempPackages.add(packages.get(i));
                }
            }


            //assert tempPackages.size() > 0 : "Temp packages were not loaded correctly to the list in findTopTen method"; //Pre-cond
            assert clients.size() > 0 : "Client list is empty";
            LinkedList<Client> tempClients = new LinkedList<>();
            //copying one list to another
            for (int i = 0; i < tempClients.size(); i++) {
                tempClients.add(clients.get(i));
            }
            assert tempClients.size() > 0 : "TempClient list is empty in findTopTen method";
            //find out for each client how many packages they receive

            for (int i = 0; i <tempPackages.size(); i++) {
                for (int j = 0; j < tempClients.size(); j++) {
                    if (tempPackages.get(i).getClient().getId() == tempClients.get(j).getId()) {
                        tempClients.get(j).setNumberOfPackagesReceived(tempClients.get(j).getNumberOfPackagesReceived() + 1);
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
            //Regex for checking date format
            System.err.println("Wrong format.");
            System.err.println(e.getMessage());
        }
    }

    public void getPackageStatus(){
        System.out.println("Please enter the id of the package: ");
        int id=readInt();
        if (!isPositiveNumber(id)){
            System.err.println("ID should be positive number");
            return;
        }
        Package temp = new Package(id);
        LinkedList<Package> tempPackages=new LinkedList<>();
        for (int i = 0; i <tempPackages.size(); i++) {
            tempPackages.add(packages.get(i));
        }
        assert tempPackages.size() > 0 : "Temp packages is empty in getPackageStatus method";
        binarySearch(tempPackages,temp);
        ArrayList<Package> tempPackages1 = new ArrayList<>();
        Instant now = Instant.now();
        for (int i = 0; i < packages.size(); i++) {
            tempPackages1.add(packages.get(i));
        }

       // System.out.println("Time took to insert packages into ArrayList: "+Duration.between(now,Instant.now()).toNanos() +" nano sec");
        binarySearch(tempPackages1,temp);
        //search in AVL tree
        searchAVLTree(temp);
    }

    /**
     * Search a key in the package tree
     * @param p to be found
     */

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

    /**
     * Search an element in the list using binary search
     * @param list to be searched on
     * @param p to be searched in the list
     */

    public void binarySearch (com.company.datastructures.linkedlist.LinkedList<Package> list, Package p) {
        Search<Package> searchPackage=new Search<>();
        //To measure the time to execute the binary search
        Instant now = Instant.now();
        //binary search in LinkedList
        Package resultPackage= searchPackage.binarySearch(list,p);
        Duration duration = Duration.between(now, Instant.now());
        if (resultPackage == null) {
            System.out.println("Package not found!");
        } else {
            System.out.println("Status: "+resultPackage.getStatus());
        }
        System.out.println("The time used for searching the package using binary search in the LinkedList is: " + duration.toNanos() + " nano sec.");
        System.out.println();
    }



    public void binarySearch (List<Package> list, Package p) {
        Search<Package> searchPackage=new Search<>();
        //To measure the time to execute the binary search
        Instant now = Instant.now();
        //binary search in LinkedList
        Package resultPackage= searchPackage.binarySearch(list,p);
        Duration duration = Duration.between(now, Instant.now());
        if (resultPackage == null) {
            System.out.println("Package not found!");
        } else {
            System.out.println("Status: "+resultPackage.getStatus());
        }
        System.out.println("The time used for searching the package using binary search in the LinkedList is: " + duration.toNanos() + " nano sec.");
        System.out.println();
    }

    /**
     * @param number to be checked
     * @return true if the number is positive, other false
     */

    public static boolean isPositiveNumber(int number) {
        //Regex for checking positive number
        final String regEx = "^[1-9]\\d*$";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(number + "");
        return matcher.matches();
    }

    //Read user input as a string
    public static String readString () {
        return new Scanner(System.in).nextLine();
    }

    //Read user input as integer
    public static int readInt () {
        int input = -1;
        Scanner sc = new Scanner(System.in);
        //Regex for allowing only Integer in the console
        while (!sc.hasNextInt()) sc.next();
        input = sc.nextInt();
        return input;
    }

    public void dijkstraPrototype(){
      //the nodes
        com.company.dijkstra.Node nodeDriver=new com.company.dijkstra.Node("Driver");
        com.company.dijkstra.Node nodeB=new com.company.dijkstra.Node("B");
        com.company.dijkstra.Node nodeC=new com.company.dijkstra.Node("C");
        com.company.dijkstra.Node nodeD=new com.company.dijkstra.Node("D");
        com.company.dijkstra.Node nodeE=new com.company.dijkstra.Node("E");
        com.company.dijkstra.Node nodeG=new com.company.dijkstra.Node("G");
        com.company.dijkstra.Node nodeNextClient=new com.company.dijkstra.Node("NextClient");

        //add the weight
        nodeDriver.addDestination(nodeB,1);
        nodeDriver.addDestination(nodeC,4);
        nodeB.addDestination(nodeC,2);
        nodeB.addDestination(nodeD,3);
        nodeB.addDestination(nodeE,10);
        nodeD.addDestination(nodeC,6);
        nodeD.addDestination(nodeE,5);
        nodeD.addDestination(nodeG,1);
        nodeC.addDestination(nodeG,3);
        nodeE.addDestination(nodeG,2);
        nodeE.addDestination(nodeDriver,7);
        nodeG.addDestination(nodeDriver,5);

        Graph graph=new Graph();

        //add nodes to the graph
        graph.addNode(nodeDriver);;
        graph.addNode(nodeB);
        graph.addNode(nodeC);
        graph.addNode(nodeD);
        graph.addNode(nodeE);
        graph.addNode(nodeG);
        graph.addNode(nodeNextClient);



        graph=DijkstraAlgorithm.calculateShortestPathFromTheSource(graph,nodeDriver);

        System.out.println(graph);

    }


    public void primPrototype(){
        MinimumSpanningTree tree = new MinimumSpanningTree();
        int graph[][] = new int[][] { { 1, 4, 5, 11, 0 },
                { 4, 0, 4, 14, 9 },
                { 0, 5, 0, 1, 9 },
                { 5, 7, 2, 0, 13 },
                { 0, 8, 9, 3, 2 } };

        // Print the solution
        tree.primMinimumSpanningTree(graph);
    }

}
