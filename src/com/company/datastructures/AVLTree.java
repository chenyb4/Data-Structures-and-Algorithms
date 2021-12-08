package com.company.datastructures;

import com.company.models.Client;
import com.company.models.Package;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AVLTree {
    public Node root;

    void updateHeight(Node n){
        n.height = 1 + Math.max(height(n.left), height(n.right));
    }

    int height(Node n){
        return n==null?-1:n.height;
    }

    int getBalance(Node n){
        return (n == null) ? 0 : height(n.right) - height(n.left);
    }

    /**
     *
     * @param y
     * @return
     */
    Node rotateRight(Node y) {
        Node x = y.left;
        Node z = x.right;
        x.right = y;
        y.left = z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    /**
     *
     * @param y
     * @return
     */
    Node rotateLeft(Node y){
        Node x=y.right;
        Node z=x.left;
        x.left=y;
        y.right=z;
        updateHeight(y);
        updateHeight(x);
        return x;
    }

    /**
     *
     * @param z
     * @return
     */
    Node rebalance(Node z) {
        updateHeight(z);
        int balance = getBalance(z);
        if (balance > 1) {
            if (height(z.right.right) > height(z.right.left)) {
                z = rotateLeft(z);
            } else {
                z.right = rotateRight(z.right);
                z = rotateLeft(z);
            }
        } else if (balance < -1) {
            if (height(z.left.left) > height(z.left.right))
                z = rotateRight(z);
            else {
                z.left = rotateLeft(z.left);
                z = rotateRight(z);
            }
        }
        return z;
    }


    /**
     *
     * @param node the root node
     * @param key the new key to be inserted to the tree
     * @return
     * @throws ParseException
     */
    public Node insert(Node node, Package key) throws ParseException {
        if (node == null) {
            return new Node(key);
        } else if (node.key.compareTo(key)>0) {
            node.left = insert(node.left, key);
        } else if (node.key.compareTo(key)<0) {
            node.right = insert(node.right, key);
        } else {
            throw new RuntimeException("duplicate Key!");
        }
        return rebalance(node);
    }


    /**
     *
     * @param node the root node
     * @param key the key to be deleted
     * @return
     */
    /*
    Node delete(Node node, Package key) {
        if (node == null) {
            return node;
        } else if (node.key.compareTo(key)>0) {
            node.left = delete(node.left, key);
        } else if (node.key.compareTo(key)<0) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null || node.right == null) {
                node = (node.left == null) ? node.right : node.left;
            } else {
                Node mostLeftChild = mostLeftChild(node.right);
                node.key = mostLeftChild.key;
                node.right = delete(node.right, node.key);
            }
        }
        if (node != null) {
            node = rebalance(node);
        }
        return node;
    }*/


    //only for testing. this method does not adhere to OOP convention and standards
    public void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key.getId() + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }


}
