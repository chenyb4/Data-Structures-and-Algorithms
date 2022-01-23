package com.company.datastructures.graphs;

import java.util.*;

public class Graph <T> {

    private Map<Vertex, List<Vertex>> adjVertices=new HashMap<>();

    /**
     * Add a new vertex to the graph
     * @param label of the object
     */

    public void addVertex(T label) {
        assert label != null : "Label cannot be null when adding a vertex"; //Pred-cond
        adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    /**
     * Remove a vertex from the graph
     * @param label to be removed
     */

    public void removeVertex(T label) {
        assert label != null : "Label cannot be null when removing a vertex"; //Pred-cond
        Vertex v = null;
        for (Vertex vertex: adjVertices.keySet()) {
            if(vertex.label.equals(label)){
                v=vertex;
                break;
            }
        }
        for (Vertex vertex: adjVertices.keySet()
             ) {
            adjVertices.get(vertex).remove(v);
        }
        //adjVertices.values().stream().forEach(e -> e.remove(v));
        adjVertices.remove(v);
        assert !adjVertices.containsKey(v) : "Vertex was not removed";
    }

    /**
     * Add edge to the graph between two labels
     * @param label1 of the first edge
     * @param label2 of the second edge
     */

    public void addEdge(T label1, T label2) {
        assert label1 != null || label2 != null : "Edges cannot be null when adding edges"; //Pre-cond
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
        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);
    }

    /**
     * Remove an edge from two object labels
     * @param label1 of the first object
     * @param label2 of the second object
     */

    public void removeEdge(T label1, T label2) {
        assert label1 != null || label2 != null : "Edges cannot be null when adding edges"; //Pre-cond
        Vertex v1=null;
        Vertex v2=null;
        for (Vertex v: adjVertices.keySet()) {
            if(v.label.equals(label1)){
                v1=v;
            }
            if(v.label.equals(label2)){
                v2=v;
            }
        }
        List<Vertex> edgesOfV1 = adjVertices.get(v1);
        List<Vertex> edgesOfV2 = adjVertices.get(v2);
        if (edgesOfV1 != null) edgesOfV1.remove(v2);
        if (edgesOfV2 != null) edgesOfV2.remove(v1);
    }

    /*@Override
    public String toString() {
        return "Graph{}";
    }*/

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        for (Vertex v : adjVertices.keySet()) {
            builder.append(v.toString() + ": ");
            for (Vertex w : adjVertices.get(v)) {
                builder.append(w.toString() + " ");
            }
            builder.append("\n");
        }
        return (builder.toString());
    }

    public Map<Vertex, List<Vertex>> getAdjVertices() {
        return adjVertices;
    }
}
