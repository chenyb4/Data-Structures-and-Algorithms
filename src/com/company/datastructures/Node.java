package com.company.datastructures;

import com.company.models.Package;

import java.util.ArrayList;

public class Node <T extends Comparable<T>>{


    public T key;
    int height;
    public Node left;
    public Node right;

    public Node(T key) {
        this.key = key;
    }


}
