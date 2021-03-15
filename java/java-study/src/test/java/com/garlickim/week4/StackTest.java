package com.garlickim.week4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    Stack stack = new Stack();

    @BeforeEach
    void initialize() {
        stack.push(3);
        stack.push(4);
        stack.push(5);
    }


    @Test
    @DisplayName("3,4,5를 push 하고 pop한 결과는 5이다")
    void push() {
        assertEquals(5, stack.pop());
    }

    @Test
    @DisplayName("3,4,5를 push 하고 두번 pop 한 이후 8을 푸시&팝 한 결과는 8이다")
    void pop() {
        stack.pop();
        stack.pop();
        stack.push(8);

        assertEquals(8, stack.pop());
    }
}