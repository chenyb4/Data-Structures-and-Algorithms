package com.company.algorithms;

import com.company.datastructures.graphs.Graph;
import com.company.datastructures.graphs.Vertex;

import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;

public class DepthFirstSearch <T>{

    public void traverse(Graph<T> graph, Vertex<T> startVertex) {
        Deque<Vertex<T>> stack = new LinkedList<>();
        stack.push(startVertex);
        while (!stack.isEmpty()){
            Vertex<T> current = stack.pop();
            if (!current.isVisited()){
                current.setVisited(true);
                System.out.println(current);
                Collections.reverse(graph.getAdjVertices().get(startVertex));
                graph.getAdjVertices().get(startVertex).forEach(stack::push);
            }
        }
    }

    public void traverseRecursively (Graph<T> graph,Vertex<T> vertex) {
        vertex.setVisited(true);
        System.out.println(vertex);
        graph.getAdjVertices().get(vertex).forEach(vertex1 -> {
            if (!vertex.isVisited()){
                traverseRecursively(graph,vertex1);
            }
        });
    }
}
