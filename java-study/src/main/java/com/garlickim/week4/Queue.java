package com.garlickim.week4;

public class Queue {
    private int size = 10;
    private int[] nums;
    private int last;

    public Queue() {
        nums = new int[size];
        last = -1;
    }

    public void enQueue(int data) {
        last++;

        if (nums.length == last) {
            int[] tmpNums = new int[size * 2];
            for (int i = 0; i < nums.length; i++) {
                tmpNums[i] = nums[i];
            }
            tmpNums[last] = data;
            nums = tmpNums;
        } else {
            nums[last] = data;
        }
    }

    public int deQueue() throws Exception {
        if (last == -1) {
            throw new Exception("Queue is empty");
        } else {
            int result = nums[0];

            for (int i = 1; i < last; i++) {
                nums[i - 1] = nums[i];
            }
            last--;
            return result;
        }
    }

    public int peek() throws Exception {
        if (last == -1) {
            throw new Exception("Queue is empty");
        } else {
            return nums[0];
        }
    }


}
