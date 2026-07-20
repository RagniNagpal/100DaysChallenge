package Heaps;

import java.util.Collections;
import java.util.PriorityQueue;

// Time Complexity: O(n log n)
// Space Complexity: O(n)
public class LastStoneWeight {
  public int lastStoneWeight(int[] stones) {
        int n=stones.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        if (stones.length == 1) {
            return stones[0];
        }
        for(int i=0;i<n;i++){
            pq.add(stones[i]);
        }
        while(pq.size() >1){
            int a=pq.poll();
            int b=pq.poll();
            if(a != b){
                pq.add(a - b);
            }
        }
        return pq.isEmpty() ? 0 : pq.poll();
    }
}
