package Heaps;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class TopKfreqWords {
  public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> map=new HashMap<>();
        for(String word:words){
            map.put(word,map.getOrDefault(word,0)+1);
        }
        PriorityQueue<String> pq=new PriorityQueue<>((a,b)-> {
            if(map.get(a).equals(map.get(b))){
                return b.compareTo(a);
            }
            return map.get(a)-map.get(b);
        });
        for(String word:map.keySet()){
            pq.offer(word);
            if(pq.size() > k){
                pq.poll();
            }
        }
        List<String> ans=new ArrayList<>();
        while(!pq.isEmpty()){
            ans.add(pq.poll());
        }
        Collections.reverse(ans);
        return ans;
    }
}
