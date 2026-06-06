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

    //Valid anagrams
     // tcO(n log n) sc 0(n)
    public boolean isAnagram(String s, String t) {
        int n=s.length();
        int m=t.length();
        char[] arr1=s.toCharArray();
        char[] arr2=t.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        return Arrays.equals(arr1,arr2);
    }

    public boolean isAnagram2(String s, String t) {
        if(s.length() != t.length()) return false;

        int[] freq = new int[26];

        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)-'a']++;
            freq[t.charAt(i)-'a']--;
        }

        for(int x : freq){
            if(x != 0) return false;
        }

        return true;
    }

//    TC: O(n)
//    SC: O(1) (26 size array constant)
public static void main(String[] args) {

    Day24 obj = new Day24();

    // -------- Max Subarray --------
    int[] arr = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
    System.out.println("MaxSubArray O(n^2): " + obj.maxSubArray(arr));
    System.out.println("MaxSubArray O(n): " + obj.maxSubArray2(arr));

    // -------- Anagram --------
    String s = "anagram";
    String t = "nagaram";
    System.out.println("Is Anagram: " + obj.isAnagram(s, t));
    System.out.println("Is Anagram: " + obj.isAnagram2(s, t));

    // -------- Level Order (Tree) --------
    Day24.TreeNode root = obj.new TreeNode(1);
    root.left = obj.new TreeNode(2);
    root.right = obj.new TreeNode(3);
    root.left.left = obj.new TreeNode(4);
    root.left.right = obj.new TreeNode(5);

    System.out.println("Level Order: " + obj.levelOrder(root));

    // -------- Coin Change --------
    int[] coins = {1, 2, 5};
    int amount = 5;
    System.out.println("Coin Change: " + obj.change(amount, coins));
}
}
