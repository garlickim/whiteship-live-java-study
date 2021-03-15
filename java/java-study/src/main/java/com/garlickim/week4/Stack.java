package com.garlickim.week4;

import java.util.EmptyStackException;

public class Stack {
    private int size = 10;
    private int[] nums;
    private int top;

    public Stack() {
        nums = new int[size];
        top = -1;
    }

    public void push(int data) {
        top++;

        if (nums.length == top) {
            int[] tmpNums = new int[size * 2];
            for (int i = 0; i < nums.length; i++) {
                tmpNums[i] = nums[i];
            }
            tmpNums[top] = data;
            nums = tmpNums;
        } else {
            nums[top] = data;
        }
    }

    public int pop() {
        if (top == -1) {
            throw new EmptyStackException();
        } else {
            int result = nums[top];
            top--;
            return result;
        }
    }
}
