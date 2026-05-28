package Target100Days;

public class Day15 {
    //foldable
    static int isFoldable(Node root) {
        if(root==null ) return 1;
        if(root.left==null && root.right==null) return 1;
        if(height(root.left)!=height(root.right) )return 0;
        return isMirror(root.left, root.right);
    }
    static int isMirror(Node a, Node b) {
        if (a == null && b == null) return 1;
        if (a == null || b == null) return 0;
        return isMirror(a.left, b.right) & isMirror(a.right, b.left);
    }
    static int height(Node root){
        if(root==null) return 1;
        int left=height(root.left);
        int right=height(root.right);
        return 1 + Math.max(left, right);
    }

    //mirror or not
    static Node findMirror(Node root) {
        if (root == null) return null;
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;
        findMirror(root.left);
        findMirror(root.right);
        return root;
    }
    public static void main(String[] args) {

    }
}
