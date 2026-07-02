package Target100Days;
import java.util.*;

public class Day49 {
    //Grid unique path
    //tc sc O(n*m)
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m+1][n+1];

        for(int i=1;i<=m;i++){
            dp[i][1]=1;
        }
        for(int j=1;j<=n;j++){
            dp[1][j]=1;
        }
        for(int i=2;i<=m;i++){
            for(int j=2;j<=n;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[m][n];
    }

    //tc sc O(n*m)
    int func(int m, int n, int[][] dp) {
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                int up = 0;
                int left = 0;
                if (i > 0)
                    up = dp[i - 1][j];
                if (j > 0)
                    left = dp[i][j - 1];
                dp[i][j] = up + left;
            }
        }
        return dp[m - 1][n - 1];
    }

    //kth largest element in an array
    // O(n log(n)) time and O(1)
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    //tc O(n log n) sc O(n)
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<nums.length;i++){
            pq.add(nums[i]);
        }
        for(int j=0;j<k-1;j++){
            pq.poll();
        }
        return pq.poll();
    }
    public static void main(String[] args) {

    }
}
