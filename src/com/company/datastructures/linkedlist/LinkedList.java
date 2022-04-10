package com.company.datastructures.linkedlist;

import com.company.datastructures.linkedlist.exception.LinkedListException;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

public class LinkedList<T> {

    // Attributes
    private Node<T> head;
    private Node<T> tail;
    private int size;

    // Constructor
    public LinkedList() {
        this.size = 0;
    }

    /**
     * Add data to the first index
     * @param data to be added
     */

    // Methods
    public void addFirst(T data) {
        Node<T> node = new Node<>(data);
        node.next = head;
        head = node;

        if (tail == null) tail = head;

        size += 1;
    }

    /**
     * Add data to the last index
     * @param data to be added
     */

    public void addLast(T data) {
        if (tail == null) {
            addFirst(data);
            return;
        }

        Node<T> node = new Node<>(data);
        tail.next = node;
        tail = node;
        size++;
    }

    /**
     * Add data to the list
     * @param data to be added
     */

    public void add(T data) {
        Node<T> node = new Node<>(data);
        node.data = data;
        node.next = null;

        if(head==null) head = node;
        else {
            Node<T> n = head;
            while(n.next!=null) {
                n = n.next;
            }
            n.next =  node;
        }
        size++;
    }

    /**
     * Add data to the list on specific index
     * @param data to be added
     * @param index position
     */

    public void add(T data, int index) {

        if (index == 0) {
            addFirst(data);
            return;
        }

        if (index == size) {
            addLast(data);
            return;
        }

        Node<T> temp = head;

        for (int i = 1; i < index; i++) {
            temp = temp.next;
        }

        temp.next = new Node<>(data, temp.next);

        size++;
    }


    /**
     *
     * @param index the index of the element that we want to update the data
     * @param data the new object we want to set for the node in the given index
     */
    public void set(int index, T data){
        if(size>index)
        {
            Node<T> temp=head;
            for (int i = 0; i < index; i++) {
                temp=temp.next;
            }

            temp.data=data;

        }else
        {
            throw new LinkedListException("index out of bound.");
        }
    }



   /* public Node<T> findNext(Node<T> node){
        return node.next;
    }
    */



    /**
     * Remove last item on the list
     * @return data
     */

    public T removeLast() {
        if (size <= 1) return removeFirst();

        Node<T> secondLast = getNode(size - 2);
        T data = tail.data;
        tail = secondLast;
        tail.next = null;
        size--;

        return data;
    }

    /**
     * Remove the data on specific index
     * @param index of teh data to be removed
     * @return data
     */

    public T remove(int index) {
        if (index == 0) return removeFirst();


        if (index == size - 1) return removeLast();

        Node<T> previous = getNode(index - 1);
        T data = previous.next.data;

        previous.next = previous.next.next;
        size--;

        return data;
    }



   /* public Node<T> find(T data) {
        Node<T> node = head;

        while (node != null) {
            if (node.data == data) {
                return node;
            }
            node = node.next;
        }

        throw new LinkedListException("Not found");
    }*/

    /**
     * Get data on specific index
     * @param index position
     * @return node
     */

    public Node<T> getNode(int index) {
        Node<T> node = head;

        if (index >= size) {
            throw new LinkedListException("Incorrect index");
        }

        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node;

    }

    /**
     *
     * @param index the index for the element you want to get
     * @return the object in the node
     */
    public T get(int index){
        Node<T> node = head;

        if (index >= size) {
            throw new LinkedListException("Incorrect index");
        }

        for (int i = 0; i < index; i++) {
            node = node.next;
        }

        return node.data;
    }

    /**
     * Remove first item on the list
     * @return data
     */

    public T removeFirst() {
        if (head == null) throw new LinkedListException("Item does not exist!");

        T data = head.data;
        head = head.next;

        if (head == null) tail = null;

        size--;
        return data;
    }


    @Override
    public String toString() {
        Node<T> node = head;

        String temp = "";
        temp += "[";

        while(node.next != null) {
            temp += (node.data + ",");
            node = node.next;
        }

        temp += (node.data + "]");
        return temp;
    }

    /**
     *
     * @param data the object to check if it exists in the linked list
     * @return {true} if the linked list contains the object
     */
    public boolean contains(T data){

        for (int i = 0; i < size; i++) {
            if(this.get(i).equals(data)){
                return true;
            }
        }

        return false;
    }



    // List size
    public int size() {
        return size;
    }


}
