package Target100Days;

public class Day40 {
    // tc O(n) sc O(h)
    int count=0;
    int ans=-1;
    public int kthSmallest(TreeNode root, int k) {
        kth(root,k);
        return ans;
    }
    public void kth(TreeNode root,int k){
        if(root==null) return;
        kth(root.left,k);
        count++;
        if(count==k){
            ans=root.val;
            return;
        }
        kth(root.right,k);
    }
    public static void main(String[] args) {

    }
}
