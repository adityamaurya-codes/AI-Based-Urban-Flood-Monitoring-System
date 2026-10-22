package dsa;

import model.FloodArea;

public class FloodPriorityQueue {

    private FloodArea[] heap;
    private int size;

    public FloodPriorityQueue(int capacity) {

        heap = new FloodArea[capacity];
        size = 0;
    }

    // Add a flood area to the priority queue
    public void insert(FloodArea area) {

        if (size == heap.length) {
            System.out.println("Priority Queue is full.");
            return;
        }

        heap[size] = area;

        int current = size;
        size++;

        // Move the new element upward
        while (current > 0) {

            int parent = (current - 1) / 2;

            if (heap[parent].getRiskScore() >=
                    heap[current].getRiskScore()) {
                break;
            }

            FloodArea temp = heap[parent];
            heap[parent] = heap[current];
            heap[current] = temp;

            current = parent;
        }
    }

    // Remove and return the highest-risk area
    public FloodArea extractHighestRisk() {

        if (size == 0) {
            return null;
        }

        FloodArea highestRisk = heap[0];

        heap[0] = heap[size - 1];
        heap[size - 1] = null;
        size--;

        heapifyDown(0);

        return highestRisk;
    }

    // Restore max-heap property
    private void heapifyDown(int index) {

        while (true) {

            int left = 2 * index + 1;
            int right = 2 * index + 2;

            int largest = index;

            if (left < size &&
                    heap[left].getRiskScore() >
                    heap[largest].getRiskScore()) {

                largest = left;
            }

            if (right < size &&
                    heap[right].getRiskScore() >
                    heap[largest].getRiskScore()) {

                largest = right;
            }

            if (largest == index) {
                break;
            }

            FloodArea temp = heap[index];
            heap[index] = heap[largest];
            heap[largest] = temp;

            index = largest;
        }
    }

    public boolean isEmpty() {
        return size == 0;
    }
}