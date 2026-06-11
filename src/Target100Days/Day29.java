package Target100Days;
import java.util.*;

public class Day29 {
    //Majority Elments
    // tc O(n^2) sc O(1)
    public int majorityElement(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int count=0;
        for (int i = 0; i < n; i++) {
            count = 0;
            for (int j = 0; j < n; j++) {
                if (nums[i] == nums[j]) {
                    count++;

                }
            }
            if(count > n/2){
                return nums[i];
            }
        }
        return -1;
    }

    // tc sc O(n)
    public int majorityElement2(int[] nums) {
        int n=nums.length;
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        for(Map.Entry<Integer,Integer> entry: map.entrySet()){
            if(entry.getValue() > n/2){
                return entry.getKey();
            }
        }
        return -1;
    }

    //tc O(n) sc O(1)
    public int majorityElement3(int[] nums) {
        int n = nums.length;
        int cnt = 0;
        int el = 0;
        for (int i = 0; i < n; i++) {
            if (cnt == 0) {
                cnt = 1;
                el = nums[i];
            } else if (el == nums[i]) {
                cnt++;
            } else {
                cnt--;
            }
        }
        int cnt1 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == el) {
                cnt1++;
            }
        }
        if (cnt1 > (n / 2)) {
            return el;
        }
        return -1;
    }

    //Binary Tree Inorder Traversal
    // TC: O(n)
    //SC: O(h) (recursive call stack)
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Traversal(root,list);
        return list;
    }
    public void Traversal(TreeNode root,List<Integer> list) {
        if(root==null) return;
        Traversal(root.left,list);
        list.add(root.val);
        Traversal(root.right,list);
    }

    //iterative
    //tc O(n) sc O(h)
    public List<Integer> inorder(TreeNode root){
        List<Integer> ans=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();
        TreeNode curr=root;
        while(curr != null || !st.isEmpty()){
            while(curr != null){
                st.push(curr);
                curr=curr.left;
            }
            curr=st.pop();
            ans.add(curr.val);

            curr = curr.right;

        }
        return ans;
    }

    // Postorder
    //tc O(n) sc O(h)
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Traversal2(root,list);
        return list;
    }
    public void Traversal2(TreeNode root,List<Integer> list) {
        if(root==null) return;
        Traversal2(root.left,list);
        Traversal2(root.right,list);
        list.add(root.val);
    }

    //iterative
//    tc O(n) sc O(n)
    public List<Integer> post(TreeNode root){
        List<Integer> ans = new ArrayList<>();

        if(root == null) return ans;

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()){

            TreeNode curr = st.pop();
            ans.add(curr.val);

            if(curr.left != null)
                st.push(curr.left);

            if(curr.right != null)
                st.push(curr.right);
        }

        Collections.reverse(ans);

        return ans;
    }

    //Preorder
    //tc O(n) sc O(h)
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Traversal3(root,list);
        return list;
    }
    public void Traversal3(TreeNode root,List<Integer> list) {
        if(root==null) return;
        list.add(root.val);
        Traversal3(root.left,list);
        Traversal3(root.right,list);
    }

    //iterative
    //tc O(n) sc O(h)
    public List<Integer> pre(TreeNode root){
        List<Integer> ans=new ArrayList<>();
        if(root == null) return ans;
        Stack<TreeNode> st=new Stack<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode curr=st.pop();
            ans.add(curr.val);
            if(curr.right !=null){
                st.push(curr.right);
            }
            if(curr.left != null)
                st.push(curr.left);
        }
        return ans;
    }

    //Assign Cookie
    //TC: O(n log n + m log m)
    //SC: O(1)
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i=0;
        int j=0;
        while(i<g.length && j<s.length){
            if(s[j] >= g[i]){
                i++;
            }
            j++;
        }
        return i;
    }
    public static void main(String[] args) {

        Day29 obj = new Day29();

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.right = new TreeNode(6);

        System.out.println("Inorder Recursive : "
                + obj.inorderTraversal(root));

        System.out.println("Inorder Iterative : "
                + obj.inorder(root));

        System.out.println("Preorder Recursive : "
                + obj.preorderTraversal(root));

        System.out.println("Preorder Iterative : "
                + obj.pre(root));

        System.out.println("Postorder Recursive : "
                + obj.postorderTraversal(root));

        System.out.println("Postorder Iterative : "
                + obj.post(root));

        int[] nums = {2,2,1,1,1,2,2};

        System.out.println("Majority Element (Brute) : "
                + obj.majorityElement(nums));

        System.out.println("Majority Element (HashMap) : "
                + obj.majorityElement2(nums));

        System.out.println("Majority Element (Moore Voting) : "
                + obj.majorityElement3(nums));

        int[] g = {1,2,3};
        int[] s = {1,1};

        System.out.println("Assign Cookies : "
                + obj.findContentChildren(g,s));
    }
}
