package com.company.datastructures;

import com.company.models.Package;

import java.util.ArrayList;

public class Node {

    public Package key;
    int height;
    public Node left;
    public Node right;

    public Node(Package key) {
        this.key = key;
    }


}
