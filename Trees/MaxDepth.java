package Trees;

//Time Complexity: O(N) (every node visited once)
// Space Complexity: O(H), where H is the height of the tree.
// Balanced Tree → O(log N)
// Skewed Tree → O(N)

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class MaxDepth {

    /*
     * LeetCode 104 - Maximum Depth of Binary Tree
     *
     * Approach:
     * 1. If root is null, return 0.
     * 2. Recursively find left subtree depth.
     * 3. Recursively find right subtree depth.
     * 4. Return 1 + maximum(leftDepth, rightDepth).
     *
     * Time Complexity:
     * O(N)
     * Every node is visited exactly once.
     *
     * Space Complexity:
     * O(H)
     * H = Height of tree
     * Balanced Tree  -> O(log N)
     * Skewed Tree    -> O(N)
     */

    public int maxDepth(TreeNode root) {

        if (root == null)
            return 0;

        int left = maxDepth(root.left);
        int right = maxDepth(root.right);

        return 1 + Math.max(left, right);
    }

    public static void main(String[] args) {

        /*
                  1
                 / \
                2   3
               / \
              4   5

        Maximum Depth = 3
        */

        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        MaxDepth obj = new MaxDepth();

        int ans = obj.maxDepth(root);

        System.out.println("Maximum Depth = " + ans);
    }
}