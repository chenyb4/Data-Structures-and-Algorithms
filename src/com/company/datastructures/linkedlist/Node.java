package com.company.datastructures.linkedlist;

public class Node<T> {

    // Attributes
    T data;
    Node<T> next;

    // Constructors
    public Node(T data) {
        this.data = data;
    }

    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

}
