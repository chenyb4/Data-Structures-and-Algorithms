package com.company.datastructures;

import java.util.HashMap;
import java.util.LinkedList;

public class Graph <T>{
    //todo: this code is for demonstration and it wasn't tested.
    /*private final HashMap<T, LinkedList<T>> adjacencyList = new HashMap<>();

    // This function adds a new vertex to the graph
    public void addVertex(T s) {
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
