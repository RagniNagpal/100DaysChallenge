package Target100Days;

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
    //

    public static void main(String[] args) {

    }
}
