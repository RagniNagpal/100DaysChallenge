package Target100Days;
class Node {
    int data;
    Node left;
    Node right;

    Node(int data) {
        this.data = data;
    }
}

public class Day2 {
    // LCA
    static int lowestCommonAncestor(Node root, int k1, int k2) {
        if(root == null) return 0;
        if(k1 < root.data && k2<root.data){
            return lowestCommonAncestor(root.left,k1,k2);
        }
        if (k1 > root.data && k2 > root.data) {
            return lowestCommonAncestor(root.right, k1, k2);
        }
        return root.data;
    }

    //Count the set bits of no
    static int countBits(int num)
    {
        int count=0;
        while(num > 0){
            count+=(num & 1);
            num=num >>1;
        }
        return count;
    }

    public static void main(String[] args) {
        Node root = new Node(20);

        root.left = new Node(10);
        root.right = new Node(30);

        root.left.left = new Node(5);
        root.left.right = new Node(15);

        root.right.left = new Node(25);
        root.right.right = new Node(35);

        // LCA Example
        int lca = lowestCommonAncestor(root, 5, 15);

        System.out.println("LCA = " + lca);

        // Count Bits Example
        int bits = countBits(13);

        System.out.println("Set Bits = " + bits);

    }
}
