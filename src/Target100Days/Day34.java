package Target100Days;
import java.util.*;

public class Day34 {
    //Search in BST
    // tc sc O(h)
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null) return null;
        if(root.val==val) return root;
        if(root.val< val) return searchBST(root.right,val);
        else return searchBST(root.left,val);
    }

    //Max cons ones
    // tc O(n) sc O(1)
    public int findMaxConsecutiveOnes(int[] nums) {
        int n=nums.length;
        int max=0;
        int count=0;
        for(int i=0;i<n;i++){
            if(nums[i]==1){
                count++;
                max=Math.max(max,count);
            }else{
                count=0;
            }
        }
        return max;
    }

    //Combination sum
    //✅ Time Complexity: O(2^target) (exponential)
    //✅ Space Complexity: O(target) (recursion stack + current path)
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ds=new ArrayList<>();
        int n=candidates.length;
        List<Integer> res = new ArrayList<>();
        solve(0,candidates,new ArrayList<>(),target,ds);
        return ds;

    }
    public static void solve(int idx,int[] candidates,List<Integer> res,int target,List<List<Integer>> ds){
        if(target == 0){
            ds.add(new ArrayList<>(res));
            return;
        }
        if(idx == candidates.length) {
            return;
        }
        if(candidates[idx] <= target){
            res.add(candidates[idx]);
            solve(idx,candidates,res,target-candidates[idx],ds);
            res.remove(res.size()-1);}
        solve(idx+1,candidates,res,target,ds);
    }

    //combination sum 2
    //Time Complexity: O(2^n)
    //✅ Space Complexity: O(n)
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result=new ArrayList<>();
        List<Integer> ans=new ArrayList<>();
        int n=candidates.length;
        solve(0,candidates,target,ans,result);
        return result;
    }
    public static void solve(int idx,int[] candidates,int target,List<Integer> ans,List<List<Integer>> result){
        if(target==0){
            result.add(new ArrayList<>(ans));
            return;
        }
        if(idx == candidates.length) {
            return;
        }
        for(int i=idx;i<candidates.length;i++){
            if(candidates[i] > target) {
                break;
            }
            if(i > idx && candidates[i] == candidates[i-1]){
                continue;
            }
            ans.add(candidates[i]);
            solve(i+1,candidates,target-candidates[i],ans,result);
            ans.remove(ans.size()-1);
        }
    }

    //remove dup from sorted array
    // tc sc O(n)
    public int removeDuplicates(int[] nums) {

        Set<Integer> set = new LinkedHashSet<>();

        for(int num : nums){
            set.add(num);
        }

        int idx = 0;

        for(int num : set){
            nums[idx] = num;
            idx++;
        }

        return idx;
    }

    //tc O(n) sc O(1)
    public int removeDuplicates2(int[] nums) {

        int i = 0;

        for(int j = 1; j < nums.length; j++) {

            if(nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }

        return i + 1;
    }
    public static void main(String[] args) {

    }
}
