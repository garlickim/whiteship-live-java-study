package com.garlickim.week4;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class QueueTest {
    Queue queue = new Queue();

    @BeforeEach
    void initialize() {
        queue.enQueue(1);
        queue.enQueue(2);
        queue.enQueue(3);
    }

    @Test
    @DisplayName("Queue에 1, 2, 3을 삽입 후 peek 하면 결과는 1이다")
    void enQueue() throws Exception {
        assertEquals(1, queue.peek());
    }

    @Test
    @DisplayName("Queue에 1, 2, 3을 삽입 후 3번의 deQueue 후 4를 삽입 & deQueue하면 결과는 41이다")
    void deQueue() throws Exception {
        queue.deQueue();
        queue.deQueue();
        queue.deQueue();
        queue.enQueue(4);

        assertEquals(4, queue.deQueue());
    }

    @Test
    @DisplayName("Queue에 1, 2, 3을 삽입 후 여러번 peek을 해도 결과는 1이다")
    void peek() throws Exception {
        queue.peek();
        queue.peek();

        assertEquals(1, queue.peek());
    }
}