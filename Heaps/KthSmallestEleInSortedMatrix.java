package Heaps;

import java.util.PriorityQueue;

public class KthSmallestEleInSortedMatrix {
  public int kthSmallest(int[][] matrix, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        for (int[] row : matrix) {
            for (int num : row) {
                pq.offer(num);
            }
        }
        for(int i=1;i<k;i++){
            pq.poll();
        }
        return pq.peek();
    }
}
