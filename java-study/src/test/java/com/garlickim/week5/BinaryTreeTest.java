package com.garlickim.week5;

import com.sun.tools.javac.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BinaryTreeTest {

    @Test
    @DisplayName("bfs 탐색을 하면 1,2,3,4가 나와야한다")
    void bfs() {
        // given
        Node subNode_02 = new Node(3, null, null);
        Node subNode_03 = new Node(4, null, null);
        Node subNode_01 = new Node(2, subNode_03, null);
        Node node = new Node(1, subNode_01, subNode_02);

        // when
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.bfs(node);


        // then
        assertEquals(List.of(1, 2, 3, 4), binaryTree.result);
    }


    @Test
    @DisplayName("bfs 탐색을 왼쪽 -> 루트 -> 오른쪽으로 하면 2,4,1,3이 나와야한다")
    void dfs() {
        // given
        Node subNode_02 = new Node(3, null, null);
        Node subNode_03 = new Node(4, null, null);
        Node subNode_01 = new Node(2, subNode_03, null);
        Node node = new Node(1, subNode_01, subNode_02);

        // when
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.dfs(node);


        Stack<Integer> expected = new Stack<>();
        expected.add(2);
        expected.add(4);
        expected.add(1);
        expected.add(3);

        // then
        assertEquals(expected, binaryTree.stack);
    }
}