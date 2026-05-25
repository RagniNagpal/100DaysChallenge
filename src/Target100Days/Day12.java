package Target100Days;

import java.util.*;

public class Day12 {

    // Longest Increasing Subsequence
    public int lengthOfLIS(int[] nums) {

        int n = nums.length;

        int[] dp = new int[n];

        Arrays.fill(dp,1);

        int ans = 1;

        for(int i=1;i<n;i++){

            for(int j=0;j<i;j++){

                if(nums[j] < nums[i]){

                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }

            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }

    // Minimum Path Sum
    public static int minSum(int[][] grid){

        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];

        // first column
        for(int i=1;i<m;i++){

            dp[i][0] =
                    dp[i-1][0] + grid[i][0];
        }

        // first row
        for(int j=1;j<n;j++){

            dp[0][j] =
                    dp[0][j-1] + grid[0][j];
        }

        // remaining cells
        for(int i=1;i<m;i++){

            for(int j=1;j<n;j++){

                dp[i][j] =
                        grid[i][j]
                                + Math.min(
                                dp[i-1][j],
                                dp[i][j-1]
                        );
            }
        }

        return dp[m-1][n-1];
    }

    public static void main(String[] args) {

        Day12 obj = new Day12();

        // LIS
        int[] nums = {10,9,2,5,3,7,101,18};

        int lisAns = obj.lengthOfLIS(nums);

        System.out.println("LIS Length = " + lisAns);

        // Minimum Path Sum
        int[][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };

        int minPath = minSum(grid);

        System.out.println("Minimum Path Sum = " + minPath);
    }
}