package Target100Days;
import java.util.*;

public class Day36 {
    //Search in Rotated Sorted Array
    //Time Complexity: O(log N),We eliminate half of the search space in each iteration using binary search.
    //Space Complexity: O(1),We use only a few variables (low, high, mid) no extra space used.
    public int search(int[] nums, int target) {
        int n=nums.length;
        int start=0;
        int end=n-1;
        while(start <= end){
            int mid=start + end-start/2;
            if(nums[mid]==target) return mid;
            if(nums[start]<=nums[mid]){
                if(target >= nums[start] && target < nums[mid]){
                    end=mid-1;
                }else{
                    start=mid+1;
                }
            }
            if(target > nums[mid] && target <=nums[end]){
                start=mid+1;
            }else{
                end=mid-1;
            }
        }
        return -1;
    }

    //lca
    //Time Complexity: O(N)
    //Space Complexity: O(H)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q) {
            return root;
        }
        TreeNode left=lowestCommonAncestor(root.left,p,q);
        TreeNode right=lowestCommonAncestor(root.right,p,q);
        if (left != null && right != null) {
            return root;
        }
        return (left != null) ? left : right;
    }

    //Binary Tree Zigzag Level Order Traversal
    // tc sc O(n)
        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

            List<List<Integer>> ans = new ArrayList<>();

            if (root == null)
                return ans;

            Queue<TreeNode> q = new LinkedList<>();
            q.offer(root);

            boolean leftToRight = true;

            while (!q.isEmpty()) {

                int size = q.size();
                LinkedList<Integer> level = new LinkedList<>();

                for (int i = 0; i < size; i++) {

                    TreeNode node = q.poll();

                    if (leftToRight)
                        level.addLast(node.val);
                    else
                        level.addFirst(node.val);

                    if (node.left != null)
                        q.offer(node.left);

                    if (node.right != null)
                        q.offer(node.right);
                }

                ans.add(level);
                leftToRight = !leftToRight;
            }

            return ans;
        }

    public static void main(String[] args) {

    }
}
