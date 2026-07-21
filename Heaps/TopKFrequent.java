package Heaps;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

// Time Complexity: O(n log n)
// Space Complexity: O(n)
public class TopKFrequent {
  public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
          for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            int a=entry.getKey();
            int b=entry.getValue();
        }
        PriorityQueue<Map.Entry<Integer,Integer>> pq= new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            pq.offer(entry);
        }
        int[] ans=new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll().getKey();
        }
        return ans;
    }
}
