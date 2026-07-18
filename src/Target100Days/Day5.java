package Target100Days;

import java.util.Arrays;

public class Day5 {

    // 1. Search in rotated sorted array (Binary Search - O(log n))
    public int search(int[] nums, int target) {
        int n = nums.length;
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) return mid;

            if (nums[start] <= nums[mid]) { // Left half is sorted
                if (target >= nums[start] && target < nums[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else { // Right half is sorted
                if (target > nums[mid] && target <= nums[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }
        return -1;
    }

    // 2. 0/1 Knapsack Memoization (O(N * W))
    int knapSackUtil(int ind, int W, int[] wt, int[] val, int[][] dp) {
        if (ind == 0) {
            if (wt[0] <= W) return val[0];
            else return 0;
        }
        if (dp[ind][W] != -1) return dp[ind][W];

        int notTaken = knapSackUtil(ind - 1, W, wt, val, dp);
        int taken = Integer.MIN_VALUE;
        if (wt[ind] <= W) {
            taken = val[ind] + knapSackUtil(ind - 1, W - wt[ind], wt, val, dp);
        }
        return dp[ind][W] = Math.max(notTaken, taken);
    }

    // Wrapper for Knapsack to handle DP initialization
    public int knapSack(int W, int[] wt, int[] val, int n) {
        int[][] dp = new int[n][W + 1];
        for (int[] row : dp) Arrays.fill(row, -1);
        return knapSackUtil(n - 1, W, wt, val, dp);
    }

    public static void main(String[] args) {
        Day5 solver = new Day5();

        // Test Rotated Search
        int[] rotatedArray = {4, 5, 6, 7, 0, 1, 2};
        int target = 0;
        System.out.println("Search Result (Index): " + solver.search(rotatedArray, target));

        // Test Knapsack
        int[] values = {60, 100, 120};
        int[] weights = {10, 20, 30};
        int capacity = 50;
        int n = values.length;
        System.out.println("Max Knapsack Value: " + solver.knapSack(capacity, weights, values, n));
    }
}
