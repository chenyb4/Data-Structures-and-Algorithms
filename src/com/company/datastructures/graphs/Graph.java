package com.company.datastructures.graphs;

import java.util.*;

public class Graph <T> {

    private Map<Vertex, List<Vertex>> adjVertices=new HashMap<>();

    public void addVertex(T label) {
        adjVertices.putIfAbsent(new Vertex(label), new ArrayList<>());
    }

    public void removeVertex(T label) {
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
        adjVertices.get(v1).add(v2);
        adjVertices.get(v2).add(v1);
    }

    public void removeEdge(T label1, T label2) {
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
