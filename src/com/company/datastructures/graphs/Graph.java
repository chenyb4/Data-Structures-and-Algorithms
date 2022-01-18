package com.company.datastructures.graphs;

import java.util.*;

public class Graph <T> {

    private Map<Vertex, List<Vertex>> adjVertices=new HashMap<Vertex, List<Vertex>>();

    public void addVertex(T label) {
        adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    public void removeVertex(T label) {
        Vertex v = new Vertex(label);
        adjVertices.values().stream().forEach(e -> e.remove(v));
        adjVertices.remove(new Vertex(label));
    }

    public void addEdge(T label1, T label2) {
        Vertex v1=null;
        Vertex v2=null;

        for (Vertex v: adjVertices.keySet()
             ) {
            if(v.label.equals(label1)){
                v1=v;
            }

            if(v.label.equals(label2)){
                v2=v;
            }
        }

        /*Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);*/
       /* List<Vertex> ver=adjVertices.get(v1);

        temp.add(v2);*/


        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);


    }

    public void removeEdge(String label1, String label2) {
        Vertex v1 = new Vertex(label1);
        Vertex v2 = new Vertex(label2);
        List<Vertex> eV1 = adjVertices.get(v1);
        List<Vertex> eV2 = adjVertices.get(v2);
        if (eV1 != null)
            eV1.remove(v2);
        if (eV2 != null)
            eV2.remove(v1);
    }




    // standard constructor, getters, setters



    /*//todo: this code is for demonstration and it wasn't tested.
    private final HashMap<Vertex, List<Vertex>> adjacencyList = new HashMap<>();

    // This function adds a new vertex to the graph
    public void addVertex(Vertex s) {
        adjacencyList.put(s, new LinkedList<T>());
    }

    // This function adds the edge between source to destination
    public void addEdge(T source, T destination, boolean biDirectional) {
        if (!adjacencyList.containsKey(source)) addVertex(source);
        if (!adjacencyList.containsKey(destination)) addVertex(destination);
        adjacencyList.get(source).add(destination);
        if (biDirectional) {
            adjacencyList.get(destination).add(source);
        }
    }

    // This function gives the count of vertices
    public void getVertexCount() {
        System.out.println("The graph has " + adjacencyList.keySet().size() + " vertex");
    }

    // This function gives the count of edges
    public void getEdgesCount(boolean biDirection) {
        int count = 0;
        for (T v : adjacencyList.keySet()) {
            count += adjacencyList.get(v).size();
        }
        if (biDirection) count = count / 2;
        System.out.println("The graph has " + count + " edges.");
    }

    // This function gives whether
    // a vertex is present or not.
    public void hasVertex(T s) {
        if (adjacencyList.containsKey(s)) {
            System.out.println("The graph contains " + s + " as a vertex.");
        } else {
            System.out.println("The graph does not contain " + s + " as a vertex.");
        }
    }

    // This function gives whether an edge is present or not.
    public void hasEdge(T s, T d) {
        if (adjacencyList.get(s).contains(d)) {
            System.out.println("The graph has an edge between " + s + " and " + d + ".");
        } else {
            System.out.println("The graph has no edge between " + s + " and " + d + ".");
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (T v : adjacencyList.keySet()) {
            builder.append(v.toString() + ": ");
            for (T w : adjacencyList.get(v)) {
                builder.append(w.toString() + " ");
            }
            builder.append("\n");
        }
        return (builder.toString());
    }*/
}
