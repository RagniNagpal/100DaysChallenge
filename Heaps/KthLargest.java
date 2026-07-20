package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

//Time Complexity: O(n log n)

// Heap build → O(n log n)
// k polls → O(k log n)
// Overall worst case → O(n log n)

// Space Complexity: O(n)
public class KthLargest {
  public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            pq.add(num);
        }

        int count = 0;

        while (!pq.isEmpty()) {

            int ans = pq.poll();
            count++;

            if (count == k) {
                return ans;
            }
        }

        return -1;
    }
}
