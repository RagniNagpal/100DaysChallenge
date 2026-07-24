package Trees;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Traversal {
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

    //
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        if(root == null) return list;
        st.push(root);
        while(!st.isEmpty()){
            TreeNode temp=st.pop();
            list.add(temp.val);
            if(temp.right!=null){
               st.push(temp.right);
            }
            if(temp.left!=null){
                st.push(temp.left);
            }
        }
        return list;
    }

    // 
    //tc sc O(n)
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list=new ArrayList<>();
        Stack<TreeNode> st=new Stack<>();
        if(root==null) return list;
        st.push(root);
        while(!st.isEmpty()){
            TreeNode temp=st.pop();
            list.add(temp.val);
            if(temp.left!=null){
                st.push(temp.left);
            }if(temp.right!=null){
                st.push(temp.right);
            }
        }
        Collections.reverse(list);
        return list;
    }

    //
     public List<Integer> inorderTraversal(TreeNode root) {

        // Answer store karne ke liye
        List<Integer> ans = new ArrayList<>();

        // Stack recursion ko simulate karega
        Stack<TreeNode> st = new Stack<>();

        // Current node root se start karega
        TreeNode curr = root;

        // Jab tak current node hai ya stack mein pending nodes hain
        while (curr != null || !st.isEmpty()) {

            // Sabse left node tak jao
            while (curr != null) {
                st.push(curr);      // Current node ko stack mein store karo
                curr = curr.left;   // Left move karo
            }

            // Left khatam ho gaya, ab stack se node nikalo
            curr = st.pop();

            // Inorder mein ab is node ko visit karte hain
            ans.add(curr.val);

            // Ab right subtree mein chale jao
            curr = curr.right;
        }

        return ans;
    }
}
