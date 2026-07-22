package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianfromDataStream {

    PriorityQueue<Integer> left;   // Max Heap
    PriorityQueue<Integer> right;  // Min Heap

    // Constructor name should match class name
    public MedianfromDataStream() {
        left = new PriorityQueue<>(Collections.reverseOrder());
        right = new PriorityQueue<>();
    }

    public void addNum(int num) {

        if (left.isEmpty() || num <= left.peek()) {
            left.offer(num);
        } else {
            right.offer(num);
        }

        // Balance both heaps
        if (left.size() > right.size() + 1) {
            right.offer(left.poll());
        } else if (right.size() > left.size()) {
            left.offer(right.poll());
        }
    }

    public double findMedian() {

        if (left.size() == right.size()) {
            return (left.peek() + right.peek()) / 2.0;
        }

        return left.peek();
    }
}