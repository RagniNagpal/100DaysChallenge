package DP;
import java.util.*;

public class Day1 {
    //fibo
    //tc sc O(n)
    //rec + memo(top down dp)
    static int[] dp;
    public int fibo(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        if(dp[n]!=0){
            return dp[n];
        }
        dp[n]= fibo(n-1) + fibo(n-2);
        return dp[n];
    }
    public int fib(int n){
        dp=new int[n+1];
        return fibo(n);
    }

    //tab (bottom up dp)
    public static int fib2(int n){
        int[] dp=new int[n+1];
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1] + dp[i-2];
        }
        return dp[n];
    }

    //min cost climbing stairs
    //tc sc O(n)
    public int solve(int[] cost,int idx,int[] dp){
        if(idx==0 || idx==1){
            return cost[idx];
        }
        if(dp[idx]!=-1){
            return dp[idx];
        }
        dp[idx]=cost[idx] + Math.min(solve(cost,idx-1,dp),solve(cost,idx-2,dp));
        return dp[idx];
    }
    public int minCostClimbingStairs(int[] cost) {
        int n=cost.length;
        int[] dp=new int[n];
        Arrays.fill(dp,-1);
        return Math.min(solve(cost,n-1,dp),solve(cost,n-2,dp));
    }

    //tabulation
    //tc sc o(n)
    class Solution {
        public int minCostClimbingStairs(int[] cost) {
            int n = cost.length;
            int[] dp = new int[n];
            dp[0] = cost[0];
            dp[1] = cost[1];
            for (int i = 2; i < n; i++) {
                dp[i] = cost[i] + Math.min(dp[i - 1], dp[i - 2]);
            }
            return Math.min(dp[n - 1], dp[n - 2]);
        }
    }

    //nth tribonacci
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1 || n == 2) return 1;
        int[] dp=new int[n+1];
        dp[0]=0;
        dp[1]=1;
        dp[2]=1;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+ dp[i-2] +dp[i-3];
        }
        return dp[n];
    }

    //House Robber
    //rec  tle
    //
    public int rob(int[] nums) {
        return solve(nums,0);
    }
    public static int solve(int[] nums,int idx){
        if(idx >= nums.length) return 0;
        int take=nums[idx] + solve(nums,idx+2);
        int skip=solve(nums,idx+1);
        return Math.max(take,skip);
    }

    //memo
    public int rob2(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,-1);
        return solve(nums,0,dp);
    }
    public static int solve2(int[] nums,int idx,int[] dp){
        if(idx >= nums.length) return 0;
        if(dp[idx]!=-1) return dp[idx];
        int take=nums[idx] + solve2(nums,idx+2,dp);
        int skip=solve2(nums,idx+1,dp);
        return dp[idx]=Math.max(take,skip);
    }

    //tabulation
    //tc sc o(n)
    public static int robb(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
        }
        return dp[n - 1];
    }

    //friendspairing
    public int countFriendsPairings(int n){
        if(n==1)
            return 1;
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+(i-1)*dp[i-2];
        }
        return dp[n];
    }

    //climbing stairs
    public int climbStairs(int n) {
        int[] dp=new int[n+1];
        if (n <= 2) return n;
        dp[1]=1;
        dp[2]=2;
        for(int i=3;i<=n;i++){
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }

    //Count Derangements
    public int derangeCount(int n) {
        if(n==1)
            return 0;
        if(n==2)
            return 1;
        int[] dp=new int[n+1];
        dp[1]=0;
        dp[2]=1;
        for(int i=3;i<=n;i++){
            dp[i]=(i-1)*(dp[i-1]+dp[i-2]);
        }
        return dp[n];
    }
    public static void main(String[] args) {

    }
}
