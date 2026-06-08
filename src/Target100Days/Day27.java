package Target100Days;

public class Day27 {
    //Symmetric tree
    //TC O(n) Sc O(H)
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return mirror(root.left, root.right);
    }
    public static boolean mirror(TreeNode t1,TreeNode t2){
        if(t1==null && t2==null) return true;
        if(t1==null || t2==null) return false;
        if(t1.val!=t2.val) return false;
        return mirror(t1.left,t2.right) && mirror(t2.left,t1.right);

    }
    public static void main(String[] args) {

    }
}
