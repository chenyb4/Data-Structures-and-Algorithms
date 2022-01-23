package com.company.datastructures.trees;

public class Node <T extends Comparable<T>>{

    public T key;
    int height;
    public Node left;
    public Node right;

    public Node(T key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return key.toString();
    }

}
