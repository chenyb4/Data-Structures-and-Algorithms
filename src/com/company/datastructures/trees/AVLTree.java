package com.company.datastructures.trees;
//import com.company.models.T;

public class AVLTree <T extends Comparable<T>>{
    public Node root;

    /**
     *  to update the height of a node
     * @param node the node of which the height needs to be updated
     */

    private void updateHeight(Node node){
        node.height = 1 + Math.max(height(node.left), height(node.right));
    }

    /**
     * to get the height of a node
     * @param node the node of which we want to get the height
     * @return the height of the node
     */

    private int height(Node node){
        if (node == null) {
            return -1;
        } else {
            return node.height;
        }
    }

    /**
     * get the balance factor for a node
     * @param node the node
     * @return the balance factor of the node
     */

    private int getBalanceFactor(Node node){
        if (node==null) {
            return 0;
        } else {
            return height(node.right)-height(node.left);
        }
    }

    /**
     *  to perform a right rotation. The left child of the unbalanced node before rotation
     *  becomes the root of the branch after rotation
     * @param unbalancedNode the node that has a balance factor bigger than 1 or smaller than -1
     * @return the left child of the unbalanced node before rotation, which becomes the root of the branch after rotation
     */

    private Node rotateRight(Node unbalancedNode) {
        Node leftChildOfUnbalancedNode = unbalancedNode.left;
        Node rightChildOfLeftChildOfUnbalancedNode = leftChildOfUnbalancedNode.right;
        leftChildOfUnbalancedNode.right = unbalancedNode;
        unbalancedNode.left = rightChildOfLeftChildOfUnbalancedNode;
        updateHeight(unbalancedNode);
        updateHeight(leftChildOfUnbalancedNode);
        return leftChildOfUnbalancedNode;
    }

    /**
     * to perform a left rotation. The right child of the unbalanced node before rotation
     *  becomes the root of the branch after rotation
     * @param unbalancedNode the node that has a balance factor bigger than 1 or smaller than -1
     * @return the right child of the unbalanced node before rotation, which becomes the root of the branch after rotation
     */

    private Node rotateLeft(Node unbalancedNode){
        Node rightChildOfUnbalancedNode=unbalancedNode.right;
        Node leftChildOfRightChildOfUnbalancedNode=rightChildOfUnbalancedNode.left;
        rightChildOfUnbalancedNode.left=unbalancedNode;
        unbalancedNode.right=leftChildOfRightChildOfUnbalancedNode;
        updateHeight(unbalancedNode);
        updateHeight(rightChildOfUnbalancedNode);
        return rightChildOfUnbalancedNode;
    }

    /**
     * to balance a node
     * @param nodeToBalance the node that is unbalanced and need to balance after insertion or deletion
     * @return the unbalanced node after balancing it
     */

    private Node balance(Node nodeToBalance) {
        updateHeight(nodeToBalance);
        int balanceFactor = getBalanceFactor(nodeToBalance);
        if (balanceFactor > 1) {
            if (height(nodeToBalance.right.right) > height(nodeToBalance.right.left)) {
                nodeToBalance = rotateLeft(nodeToBalance);
            } else {
                nodeToBalance.right = rotateRight(nodeToBalance.right);
                nodeToBalance = rotateLeft(nodeToBalance);
            }
        } else if (balanceFactor < -1) {
            if (height(nodeToBalance.left.left) > height(nodeToBalance.left.right))
                nodeToBalance = rotateRight(nodeToBalance);
            else {
                nodeToBalance.left = rotateLeft(nodeToBalance.left);
                nodeToBalance = rotateRight(nodeToBalance);
            }
        }
        return nodeToBalance;
    }

    /**
     * to insert a key into the tree
     * @param node the root node
     * @param key the new key to be inserted to the tree
     * @return the root node
     */

    public Node insert(Node node, T key) {
        if (node == null) {
            return new Node(key);
        } else if (node.key.compareTo(key)>0) {
            //myself bigger
            node.left = insert(node.left, key);
        } else if (node.key.compareTo(key)<0) {
            //myself smaller
            node.right = insert(node.right, key);
        } else {
            throw new RuntimeException("you are inserting duplicate key.");
        }
        return balance(node);
    }

    /**
     * to get the smallest child from the right sub-tree
     * @param node the root of the right sub-tree
     * @return the smallest child from the right sub-tree
     */

    private Node getSmallestChildFromTheRight(Node node) {
        Node current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    /**
     * to delete a node from the tree
     * @param node the root node of the tree
     * @param key the key of the node we want to delete
     * @return the root
     */

    public Node delete(Node node, T key) {
        if (node == null) {
            return null;
        } else if (node.key.compareTo(key)>0) {
            //myself bigger that the key, then we need to find nodes with smaller keys so use recursion to go left
            node.left = delete(node.left, key);
        } else if (node.key.compareTo(key)<0) {
            //myself smaller that the key, then we need to find nodes with bigger keys so use recursion to go right
            node.right = delete(node.right, key);
        } else {
            //found the node, now determine how many children this node has, so we can find it a replacement after deletion
            //if either left or right child is null, then this node only has one child
            if (node.left == null || node.right == null) {
                if(node.left==null){
                    //the node does not have left child, then the replacement is the right child
                    //Right child can also be null here. That means the node has no child. The replacement is null. Still correct.
                    node=node.right;
                }else{
                    //same logic as above
                    node=node.left;
                }

            } else {
                //this node has two children, find the smallest child from the right as a replacement
                Node smallestChildFromTheRight = getSmallestChildFromTheRight(node.right);
                node.key = smallestChildFromTheRight.key;
                node.right = delete(node.right, (T) node.key);
            }
        }
        if (node != null) {
            node = balance(node);
        }
        return node;
    }

    /**
     * to find a node with the given key
     * @param key the key of the node to be found
     * @return the node containing the given key
     */

    public Node find(T key) {
        Node current = root;
        while (current != null) {
            if (current.key.compareTo(key)==0) {
                return current;
            }
            if(current.key.compareTo(key)<0){
                current=current.right;

            }else{
                current=current.left;
            }
        }
        return current;
    }

    /**
     * print the pre order of the tree for testing
     * @param node the root
     */

    public void preOrder(Node node) {
        if (node != null) {
            System.out.println(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    public void inOrder(Node node){
        if(node!=null){
            inOrder(node.left);
            System.out.println(node.key+" ");
            inOrder(node.right);
        }
    }
}
