package com.company.dijkstra;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class DijkstraAlgorithm {
    public static Graph calculateShortestPathFromTheSource(Graph graph, Node source) {

        source.setDistance(0);

        //one set for visited, another for unvisited
        Set<Node> visitedNodes = new HashSet<>();
        Set<Node> unvisitedNodes = new HashSet<>();


        unvisitedNodes.add(source);

        //as long as there are still unvisited notes, the loop continues
        while (unvisitedNodes.size() != 0) {
            Node currentNode = getNearestNode(unvisitedNodes);
            unvisitedNodes.remove(currentNode);

            for (Map.Entry<Node, Integer> adjacencyPair : currentNode.getAdjacentNodes().entrySet()) {
                Node adjacentNode = adjacencyPair.getKey();
                Integer edgeWeigh = adjacencyPair.getValue();

                //add the adjacent node
                if (!visitedNodes.contains(adjacentNode)) {
                    calculateShortestDistance(adjacentNode, edgeWeigh, currentNode);
                    unvisitedNodes.add(adjacentNode);
                }
            }
            visitedNodes.add(currentNode);
        }
        return graph;
    }

    private static void calculateShortestDistance(Node candidateNode, Integer weight, Node sourceNode) {
        Integer sourceDistance = sourceNode.getDistance();
        if ((sourceDistance + weight) < candidateNode.getDistance()) {
            //found it and now add the distance
            candidateNode.setDistance(sourceDistance + weight);
            LinkedList<Node> shortestPath = new LinkedList<>(sourceNode.getShortestPath());
            shortestPath.add(sourceNode);
            candidateNode.setShortestPath(shortestPath);
        }
    }

    private static Node getNearestNode(Set<Node> unvisitedNodes) {
        Node nearestNode = null;
        int shortestDistance = Integer.MAX_VALUE;

        for (Node node : unvisitedNodes) {
            //loop until finding the smallest distance then return the node with the shortest distance
            int nodeDistance = node.getDistance();

            if (nodeDistance < shortestDistance) {
                //the node is found
                shortestDistance = nodeDistance;
                nearestNode = node;
            }
        }
        return nearestNode;
    }
}

