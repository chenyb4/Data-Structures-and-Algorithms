package com.company;

import com.company.datastructures.linkedlist.LinkedList;
import com.company.models.UserInterface;

import javax.swing.plaf.IconUIResource;

public class Main {

    public static void main(String[] args) {

        /*LinkedList<Integer> list = new LinkedList<>();

        if(!list.contains(0)){
            list.add(0);
            list.add(2);
        }

        System.out.println(
                "adding the 0 for the first time"+list
        );
        if(!list.contains(5)){
            list.add(3);
        }
        System.out.println("adding the 0 for the second time:"+list);*/

       // System.out.println(list);

        /*System.out.println("before creating the user interface");

        UserInterfaceHandler temp=new UserInterfaceHandler();

        System.out.println("after creting object for userinterface handler");

        UserInterface hah= new UserInterface(temp);

        System.out.println("after instantiation of the user interface");

        for (int i = 0; i < hah.getHandler().packages.size(); i++){
            System.out.println(hah.getHandler().packages.get(i));
        }*/


        //hah.startUserInterface();

    /*    System.out.println("after calling the start user interface method");



        System.out.println("number of clients:"+hah.getHandler().clients.size());


        System.out.println("package size: "+ hah.getHandler().packages.size());*/



      /*  list.add(4);
        list.add(5);
        list.add(6);

        System.out.println(list);
        System.out.println(list.size());

        list.set(1,0);
        System.out.println(list);*/



        /*UserInterface userInterface = new UserInterface(new UserInterfaceHandler());
        userInterface.startUserInterface();

        System.out.println("number of clients:"+userInterface.getHandler().clients.size());*/
        /*
        Graph graph = new Graph();
        Vertex vertex = null;
        for (Client c: userInterface.getHandler().clients
        ) {
            graph.addVertex(c);
            if (vertex == null){
                vertex = new Vertex<>(c);
            }
        }
        /*graph.getAdjVertices().putIfAbsent(vertex,new ArrayList<>());
        System.out.println("after adding all clients are added:");
        System.out.println(graph);
        System.out.println("_____________________________");*/

        /*graph.addEdge(userInterface.getHandler().clients.get(0),userInterface.getHandler().clients.get(10));
        System.out.println("after adding an edge:");
        System.out.println(graph);

        System.out.println("_____________________________");*/
        //DepthFirstSearch<Client> dfs = new DepthFirstSearch<>();
        //dfs.traverse(graph,vertex);
        //dfs.traverseRecursively(graph,vertex);
        /*graph.removeEdge(userInterface.getHandler().clients.get(0),userInterface.getHandler().clients.get(10));

        System.out.println("_____________________________");

       *//* graph.removeEdge(userInterface.getHandler().clients.get(0),userInterface.getHandler().clients.get(10));
        System.out.println("after removing an edge:");
        System.out.println(graph);
        System.out.println("_____________________________");*//*



        /*System.out.println(graph);
        graph.removeVertex(userInterface.getHandler().clients.get(0));
        System.out.println(graph);
        System.out.println("after removing a vertex:");
        System.out.println(graph);
        System.out.println("_____________________________");*/
        System.out.println("_____________________________");

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
