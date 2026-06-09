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

    //floor
    //tc O(h) sc O(1)
    public int findMaxFork(Node root, int k) {
        // code here.
        int floor=-1;
        while(root != null){
            if(root.data==k) return root.data;
            else if(root.data < k){
                floor=root.data;
                root=root.right;
            }else{
                root=root.left;
            }
        }
        return floor;
    }

    //ceil
    //tc O(h) sc O(1)
    int findCeil(Node root, int x) {
        // code here
        int ceil=-1;
        while(root != null){
            if(root.data==x) return root.data;
            else if(root.data > x){
                ceil=root.data;
                root=root.left;
            }else{
                root=root.right;
            }
        }
        return ceil;
    }

    public static void main(String[] args) {

    }
}
