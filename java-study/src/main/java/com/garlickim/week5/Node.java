package com.garlickim.week5;

public class Node {
    Node left;

    Node right;

    int value;

    public Node() {
    }

    public Node(int value, Node left, Node right) {
        this.value = value;
        this.left = left;
        this.right = right;
    }
}
