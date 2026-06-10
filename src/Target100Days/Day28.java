package Target100Days;
import java.util.*;

public class Day28 {
    // Balanced tree
    //tc O(n^2) sc O(h)
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        if(Math.abs(height(root.left)-height(root.right)) > 1){
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }
    public int height(TreeNode root){
        if(root==null) return 0;
        int left=height(root.left);
        int right=height(root.right);
        return 1+Math.max(left,right);
    }

    //Subset sums
    //tc  O(n × 2^n) sc O(n)
    public static void solve(int[] nums,int idx,List<Integer> curr, List<List<Integer>> sums){
        if(idx == nums.length){
            sums.add(new ArrayList<>(curr));
            return;
        }
        curr.add(nums[idx]);
        solve(nums, idx+1, curr, sums);
        // Backtrack
        curr.remove(curr.size()-1);
        // Not Take
        solve(nums, idx+1, curr, sums);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> sums = new ArrayList<>();
        solve(nums, 0, new ArrayList<>(), sums);
        return sums;
    }

    //subset sum
    //tc sc TC = O(n * sum)
    static Boolean solve(int idx,int sum,int[] arr,int[][] dp){
        if(sum==0) return true;
        if(idx == arr.length){
            return false;
        }
        if (dp[idx][sum] != -1)
            return dp[idx][sum] == 1;
        boolean take=false;
        if(arr[idx]<=sum){
            take=solve(idx+1,sum - arr[idx],arr,dp);
        }
        boolean notTake =solve(idx + 1,sum,arr,dp);
        dp[idx][sum] =(take || notTake) ? 1 : 0;

        return take || notTake;
    }
    static Boolean isSubsetSum(int arr[], int sum) {
        // code here
        int n=arr.length;
        int[][] dp =new int[n][sum + 1];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,sum,arr,dp);
    }

    //Best time to buy and sell
    //tc O(n^2) sc O(1)
    public int maxProfit(int[] prices) {
        int n=prices.length;
        int ans=0;
        int res=prices[0];
        for(int i=1;i<n;i++){
            res=Math.min(res,prices[i]);
            ans=Math.max(ans,prices[i]-res);
        }
        return ans;
    }

    //optimised
    //TC = O(n) SC = O(1)
        public int maxProfit2(int[] prices) {
            int maxProfit=0;
            int minPrice=Integer.MAX_VALUE;
            int n=prices.length;
            for(int i=0;i<n;i++){
                if(prices[i] < minPrice){
                    minPrice=prices[i];

                }
                int profit=prices[i]-minPrice;
                maxProfit=Math.max(maxProfit,profit);
            }
            return maxProfit;
        }

    public static void main(String[] args) {

        Day28 obj = new Day28();

        // ==============================
        // 1. Subsets
        // ==============================
        int[] nums = {1, 2, 3};

        List<List<Integer>> subsets = obj.subsets(nums);

        System.out.println("Subsets:");
        for (List<Integer> subset : subsets) {
            System.out.println(subset);
        }

        // ==============================
        // 2. Subset Sum
        // ==============================
        int[] arr = {3, 34, 4, 12, 5, 2};
        int target = 9;

        System.out.println("\nSubset Sum:");
        System.out.println(isSubsetSum(arr, target));

        // ==============================
        // 3. Balanced Binary Tree
        // ==============================

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println("\nBalanced Tree:");
        System.out.println(obj.isBalanced(root));
        int[] prices={7,1,5,3,6,4};
        System.out.println();
        System.out.println("Buy and sell ");
        System.out.println(obj.maxProfit(prices));
        System.out.println(obj.maxProfit2(prices));
    }
}
