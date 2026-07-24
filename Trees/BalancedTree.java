package Trees;

public class BalancedTree {
  public boolean isBalanced(TreeNode root) {
        if(root==null) return true;
        int left=height(root.left);
        int right=height(root.right);
        if(Math.abs(left-right)>1) return false;
         return isBalanced(root.left) && isBalanced(root.right);
    }
    public static int height(TreeNode root){
        if(root==null) return 1;
        int left=height(root.left);
        int right=height(root.right);
        return 1+ Math.max(left,right);
    }
}
