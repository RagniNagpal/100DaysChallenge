// package DP;

// public class Day3 {
//     public boolean canPartition(int[] nums) {
//         int n=nums.length;
//         int sum=0;
//         for(int i=0;i<n;i++){
//             sum += nums[i];
//         }
//         if(sum % 2 != 0)
//             return false;
//         int target=sum/2;
//         int[][] dp=new int[n+1][target+1];
//         for (int[] row : dp) {
//             Arrays.fill(row, -1);
//         }
//         return solve(0,nums,target,dp);
//     }
//     public static boolean solve(int idx,int[] nums,int target,int[][] dp){
//         int n=nums.length;
//         if(target==0){
//             return true;
//         }
//         if(idx==nums.length){
//             return false;
//         }
//         if(dp[idx][target] !=-1){
//             return dp[idx][target]==1;
//         }
//         boolean take=false;
//         if(nums[idx] <= target){
//             take=solve(idx+1,nums,target-nums[idx],dp);
//         }
//         boolean notTake=solve(idx+1,nums,target,dp);
//         dp[idx][target] = (take || notTake) ? 1 : 0;

//         return take || notTake;
//     }


//     public static void main(String[] args) {

//     }
// }
