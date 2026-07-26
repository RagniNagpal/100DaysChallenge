package Trees;

public class PathSum {
  // tc o(n) sc o(h)
  public boolean hasPathSum(TreeNode root, int targetSum) {
       return solve(root,0,targetSum); 
    }
    public boolean solve(TreeNode root,int sum,int targetSum){
        if(root==null) return false;
        sum += root.val;
        if (root.left == null && root.right == null) {
            return sum == targetSum;
        }
        return solve(root.left, sum, targetSum) || solve(root.right, sum, targetSum);
    }
}
