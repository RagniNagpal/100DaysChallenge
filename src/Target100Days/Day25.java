package Target100Days;
import java.util.*;

 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
public class Day25 {
   // TC , SC O(1);
    class ListNode{
        int val;
        ListNode next;
        ListNode(int val,ListNode next){
            this.val=val;
            this.next = next;
        }
    }
    public void deleteNode(ListNode node) {
        node.val=node.next.val;
        node.next=node.next.next;
    }

    //Sort colours
    // Tc O(nlogn) sc 0(log n)
    public void sortColors(int[] nums) {
        Arrays.sort(nums);
    }

    //Tc O(n^2) sc O(1)
    public void sortColors2(int[] nums) {
        int n=nums.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(nums[j] > nums[j+1]){
                    int temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
    }

    // Tc O(n) Sc O(1)
    public void sortColors3(int[] nums) {

        int zero = 0, one = 0, two = 0, three = 0;

        for (int x : nums) {
            if (x == 0) zero++;
            else if (x == 1) one++;
            else if (x == 2) two++;
            else if (x == 3) three++;
        }

        int i = 0;

        while (zero-- > 0) nums[i++] = 0;
        while (one-- > 0) nums[i++] = 1;
        while (two-- > 0) nums[i++] = 2;
        while (three-- > 0) nums[i++] = 3;
    }

    // LCA
    // Tc O(h) sc O(h)
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root==null) return null;
        if(root.val < p.val && root.val < q.val){
            return lowestCommonAncestor(root.right,p,q);
        }else if(root.val > p.val && root.val > q.val){
            return lowestCommonAncestor(root.left,p,q);
        }
        return root;
    }

    //Tc O(h) sc O(1)
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {

        while(root != null) {

            if(root.val < p.val && root.val < q.val) {
                root = root.right;
            }
            else if(root.val > p.val && root.val > q.val) {
                root = root.left;
            }
            else {
                return root;
            }
        }

        return null;
    }

    // LL cycle
    // Tc O(n) Sc O(1)
    public ListNode detectCycle(ListNode head) {
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                ListNode temp=head;
                while(temp != slow){
                    temp=temp.next;
                    slow=slow.next;
                }
                return temp;
            }
        }
        return null;
    }

    //Merge sorted array
    // TC: O((m+n) log(m+n))
    // SC: O(m+n)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int k=m+n;
        int[] res=new int[m+n];
        int idx=0;
        for(int i=0;i<m;i++){
            res[idx++]=nums1[i];
        }
        for(int j=0;j<n;j++){
            res[idx++]=nums2[j];
        }
        Arrays.sort(res);
        for (int i = 0; i < k; i++) {
            nums1[i] = res[i];
        }
    }

    // TC: O(m+n)
// SC: O(m+n)

    public void merge2(int[] nums1, int m, int[] nums2, int n) {

        int[] res = new int[m + n];

        int i = 0, j = 0, k = 0;

        while(i < m && j < n) {

            if(nums1[i] <= nums2[j]) {
                res[k++] = nums1[i++];
            } else {
                res[k++] = nums2[j++];
            }
        }

        while(i < m) {
            res[k++] = nums1[i++];
        }

        while(j < n) {
            res[k++] = nums2[j++];
        }

        for(i = 0; i < m + n; i++) {
            nums1[i] = res[i];
        }
    }

    // TC: O(m+n)
// SC: O(1)

    public void merge3(int[] nums1, int m, int[] nums2, int n) {

        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;

        while(i >= 0 && j >= 0) {

            if(nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        while(j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }

    //two sum
    // tc o(n^2) sc O(1)
    public int[] twoSum(int[] nums, int target) {
        int n=nums.length;
        for(int i=0;i<n;i++){
            for(int j=i+1;j<n;j++){
                if(nums[i] + nums[j]==target){
                    return new int[]{i,j};
                }
            }
        }
        return new int[]{-1,-1};
    }

    //tc , sc O(n)
    public int[] twoSum2(int[] nums, int target) {
        HashMap<Integer,Integer> map=new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[]{map.get(complement), i};
            }
            map.put(nums[i], i);
        }

        return new int[]{};
    }

    //knapsack 0/1
    public int knapsack(int W, int val[], int wt[]) {
        // code here
        int n=wt.length;
        int[][] t=new int[n+1][W+1];
        for(int i=0;i<n+1;i++){
            t[i][0]=0;
        }
        for(int j=0;j<W+1;j++){
            t[0][j]=0;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<W+1;j++){
                if(wt[i-1] <=j){
                    t[i][j]=Math.max(val[i-1]+t[i-1][j-wt[i-1]],t[i-1][j]);
                }else{
                    t[i][j]=t[i-1][j];
                }
            }
        }
        return t[n][W];
    }
    public static void main(String[] args) {

    }
}
