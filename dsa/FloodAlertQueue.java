package dsa;

import model.FloodArea;

public class FloodAlertQueue {

    private FloodArea[] queue;
    private int front;
    private int rear;
    private int size;

    public FloodAlertQueue(int capacity) {

        queue = new FloodArea[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    // Add an area to the queue
    public void enqueue(FloodArea area) {

        if (size == queue.length) {
            System.out.println("Alert Queue is full.");
            return;
        }

        rear = (rear + 1) % queue.length;
        queue[rear] = area;
        size++;
    }

    // Remove the first area from the queue
    public FloodArea dequeue() {

        if (size == 0) {
            return null;
        }

        FloodArea area = queue[front];

        queue[front] = null;
        front = (front + 1) % queue.length;
        size--;

        return area;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}