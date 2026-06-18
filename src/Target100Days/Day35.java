package Target100Days;
import java.util.*;

public class Day35 {
    //permutation
    //tc : o(n*n!) sc O(n
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> list=new ArrayList<>();
            solve(0,nums,list);
            return list;
        }
        public static void solve(int idx,int[] nums,List<List<Integer>> list){
            int n=nums.length;
            if(idx==n){
                List<Integer> temp=new ArrayList<>();
                for(int num:nums){
                    temp.add(num);
                }
                list.add(temp);
                return;
            }
            for(int i=idx;i<n;i++){
                swap(nums,idx,i);
                solve(idx+1,nums,list);
                swap(nums,idx,i);
            }
        }
        public static void swap(int[] nums,int i,int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        // Symmetric tree
    // tc O(n) sc O(1)
        public boolean isSymmetric(TreeNode root) {
            if(root==null) return true;
            return symm(root.left,root.right);
        }
    public static boolean symm(TreeNode p,TreeNode q){
        if(p==null && q==null) return true;
        if(p==null || q==null) return false;
        if(p.val != q.val) return false;
        return symm(p.left,q.right) && symm(p.right,q.left);
    }

    //nth root of int
    //tc O(m) sc O(1)
    //only 7 testcases run
    public int nthRoot(int n, int m) {
        for (int i = 1; i <= m; i++) {
            long power = (long) Math.pow(i, n);

            if (power == m) return i;
            if (power > m) break;
        }
        return -1;
    }

    //- O(n * log(m)) Time and O(1) Space
    int power(int base, int expo, int limit) {
        int result = 1;
        for (int i = 0; i < expo; i++) {
            result *= base;

            if (result > limit)
                return result;
        }
        return result;
    }
    int nthRoot2(int n, int m) {

        if (m == 0) return 0;
        if (n == 1) return m;
        int low = 1, high = m;
        while (low <= high) {
            int mid = (low + high) / 2;
            int val = power(mid, n, m);
            if (val == m)
                return mid;
            else if (val < m)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }

    //Validate Binary Search Tree
    //tc O(n) Sc o(h)
    public boolean isValidBST(TreeNode root) {
        return solve(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    public static boolean solve(TreeNode root,long min,long max){
        if(root==null) return true;
        if (root.val <= min || root.val >= max) {
            return false;
        }
        return solve(root.left,min,root.val) && solve(root.right,root.val,max);
    }
    public static void main(String[] args) {

    }
}
