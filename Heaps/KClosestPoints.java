package Heaps;

import java.util.PriorityQueue;

// TC: O(n log n)
// SC: O(n)
public class KClosestPoints {
  public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b)->{
            int distA=a[0] * a[0] + a[1] * a[1];
            int distB=b[0] * b[0] + b[1] * b[1];
            return distB-distA;
        } );
        for (int[] point : points) {
            pq.offer(point);
            if(pq.size() > k){
                pq.poll();
            }

        }
        int[][] ans=new int[k][2];
        for(int i=k-1 ; i>=0;i--){
            ans[i]=pq.poll();
        }
        return ans;
    }
}
