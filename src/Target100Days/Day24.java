package Target100Days;
import java.util.*;

public class Day24 {
    //Max subarray - Kndane
    //Tc O(n^2) sc O(1)
    public int maxSubArray(int[] nums) {
        int n=nums.length;
        int max=Integer.MIN_VALUE;
        int sum=0;
        for(int i=0;i<n;i++){
            sum=0;
            for(int j=i;j<n;j++){
                sum+=nums[j];
                max=Math.max(max,sum);
            }
        }
        if(sum <0){
            sum=0;
        }
        return max;
    }

    //Tc O(n) sc O(1)
    public int maxSubArray2(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            max = Math.max(max, sum);
            if (sum < 0) {
                sum = 0;
            }
        }
        return max;
    }

    //level order traversal
    // TC 0(N) SC 0(N)
    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int val) {
            this.val = val;
            left = null;
            right = null;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list=new ArrayList<>();
        Queue<TreeNode> q=new LinkedList<>();
        if(root==null) return list;
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i=0;i<size;i++){
                TreeNode node=q.poll();
                level.add(node.val);
                if(node.left!=null){
                    q.add(node.left);
                }
                if(node.right!=null){
                    q.add(node.right);
                }
            }
            list.add(level);
        }
        return list;
    }

    // Coin change
    // Tc O(n × amount) sc O(n × amount)
    public int change(int amount, int[] coins) {
        int n=coins.length;
        int[][] dp=new int[n+1][amount+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=1;
        }
        for(int j=0;j<=amount;j++){
            dp[0][j]=0;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<amount+1;j++){
                if(coins[i-1] <=j)
                    dp[i][j]=dp[i][j-coins[i-1]] + dp[i-1][j];
                else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][amount];
    }


    public static void main(String[] args) {

    }
}
