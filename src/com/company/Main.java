package com.company;


import com.company.datastructures.graphs.Graph;
import com.company.models.Client;

public class Main {

    public static void main(String[] args) {

        UserInterface userInterface = new UserInterface(new UserInterfaceHandler());

        /*System.out.println("numbe rof clients:"+userInterface.getHandler().clients.size());

        Graph graph = new Graph();

        for (Client c: userInterface.getHandler().clients
        ) {
            graph.addVertex(c);
        }

        graph.addEdge(userInterface.getHandler().clients.get(0),userInterface.getHandler().clients.get(10));

        System.out.println(graph.toString());*/


        userInterface.startUserInterface();

        //UserInterface.findTopTen();
        //try binary search
        /*Client temp= Search.binarySearchClients(clients,235027);

        Search<Client> search = new Search<Client>();
        System.out.println(search.binarySearch(clients,new Client(235050,null,null,0,0)).getName());

        Client temp2=Search.binarySearchClients(clients,888888888);

        System.out.println(temp.getName());

        System.out.println(temp2.getName());*/


        //get the number of packages sent to each client

      /* AVLTree tree=new AVLTree();
        for (Package p: packages
             ) {
            tree.root=tree.insert(tree.root,p);
        }*/

      //  tree.delete(tree.root,packages.get(5));




        //Node nodeToFind= tree.find(packages.get(4));
       // System.out.println(nodeToFind.key.getId()+" is the node found");

        /*System.out.println("Preorder traversal" +
                " of constructed tree is : ");

        tree.preOrder(tree.root);*/


        /*System.out.println("Inorder traversal of the constructed tree is:");
        tree.inOrder(tree.root);
*/
        /*
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





          /*  graph.addVertex("Bob");
            graph.addVertex("Alice");
            graph.addVertex("Mark");
            graph.addVertex("Rob");
            graph.addVertex("Maria");
            graph.addEdge("Bob", "Alice");
            graph.addEdge("Bob", "Rob");
            graph.addEdge("Alice", "Mark");
            graph.addEdge("Rob", "Mark");
            graph.addEdge("Alice", "Maria");
            graph.addEdge("Rob", "Maria");*/


    }

}
