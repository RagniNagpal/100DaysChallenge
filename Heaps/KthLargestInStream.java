package Heaps;

import java.util.PriorityQueue;

public class KthLargestInStream {
    private PriorityQueue<Integer> minHeap;
    private int size;

    public void KthLargest(int k, int[] nums) {
        size = k;
        minHeap = new PriorityQueue<>();

        for (int num : nums) {
            minHeap.add(num);

            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }

    public int add(int val) {
        minHeap.add(val);

        if (minHeap.size() > size) {
            minHeap.poll();
        }

        return minHeap.peek();
    }
}
