package com.garlickim.week5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BinaryTree {

    Queue<Node> queue = new LinkedList<>();
    Queue<Integer> result = new LinkedList<>();

    // bfs : 너비 우선
    void bfs(Node root) {
        queue.add(root);
        while (!queue.isEmpty()) {
            Node tmpNode = queue.poll();
            result.add(tmpNode.value);

            if (tmpNode.left != null) {
                queue.add(tmpNode.left);
            }

            if (tmpNode.right != null) {
                queue.add(tmpNode.right);
            }
        }

    }

    Stack<Integer> stack = new Stack<>();
    Integer rootNumber = null;

    // dfs : 깊이 우선
    void dfs(Node root) {

        Boolean isRoot = false;

        if(rootNumber == null) {
            isRoot = true;
            rootNumber=root.value;
        } else {
            stack.add(root.value);
        }

        if (root.left != null) {
            dfs(root.left);
        }

        if(isRoot){
            stack.add(rootNumber);
        }

        if (root.right != null) {
            dfs(root.right);
        }

    }

}