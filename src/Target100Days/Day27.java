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

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }
    static class Node {
        int data;
        Node left, right;

        Node(int data) {
            this.data = data;
        }
    }
    public static void main(String[] args) {

        Day27 obj = new Day27();

        // ================= Symmetric Tree =================

    /*
              1
            /   \
           2     2
          / \   / \
         3   4 4   3
    */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println("Is Symmetric: "
                + obj.isSymmetric(root));

        // ================= BST for Floor & Ceil =================

    /*
                10
              /    \
             5      15
            / \    /  \
           2   7  12  20
    */

        Node bst = new Node(10);

        bst.left = new Node(5);
        bst.right = new Node(15);

        bst.left.left = new Node(2);
        bst.left.right = new Node(7);

        bst.right.left = new Node(12);
        bst.right.right = new Node(20);

        int k = 13;

        System.out.println("Floor of " + k + " = "
                + obj.findMaxFork(bst, k));

        System.out.println("Ceil of " + k + " = "
                + obj.findCeil(bst, k));
    }
}
