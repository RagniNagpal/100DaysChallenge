package Target100Days;

public class Day39 {

    // Tree Node
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Diameter of Binary Tree
    // TC: O(n)
    // SC: O(h)

    int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDiameter = 0;
        calculateHeight(root);
        return maxDiameter;
    }

    private int calculateHeight(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);

        // Diameter passing through current node
        maxDiameter = Math.max(maxDiameter,
                leftHeight + rightHeight);

        // Return height of current node
        return 1 + Math.max(leftHeight, rightHeight);
    }

    //const bst from preorder
    // tc O(n^2) sc O(n)
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */
        public TreeNode bstFromPreorder(int[] preorder) {
            int n=preorder.length;
            TreeNode root = null;
            for(int i=0;i<n;i++){
                root=build(root,preorder[i]);
            }
            return root;
        }
        public TreeNode build(TreeNode root,int val){
            if(root==null) return new TreeNode(val);
            if(root.val < val){
                root.right=build(root.right,val);
            }
            if(root.val > val){
                root.left=build(root.left,val);
            }
            return root;
        }

        //
    public static void main(String[] args) {

        Day39 obj = new Day39();

        /*
                  1
                 / \
                2   3
               / \
              4   5
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        int diameter = obj.diameterOfBinaryTree(root);

        System.out.println("Diameter = " + diameter);
    }
}