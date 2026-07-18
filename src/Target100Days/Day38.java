package Target100Days;
import java.util.*;

public class Day38 {
    //Implement q from stack
    //operation worst aportised
    //push()	O(1)	O(1)
    //pop() 	O(n)	O(1)
    //peek()	O(n)	O(1)
    //empty()	O(1)	O(1)
    //Space Complexity
    //O(n)
    class MyQueue {
        Stack<Integer> input;
        Stack<Integer> output;
        public MyQueue() {
            input = new Stack<>();
            output = new Stack<>();
        }

        public void push(int x) {
            input.push(x);
        }

        public int pop() {
            if(output.isEmpty()){
                while(!input.isEmpty()){
                    output.push(input.pop());
                }
            }
            return output.pop();
        }

        public int peek() {
            if(output.isEmpty()){
                while(!input.isEmpty()){
                    output.push(input.pop());
                }
            }
            return output.peek();
        }

        public boolean empty() {
            return input.isEmpty() && output.isEmpty();
        }
    }

    /**
     * Your MyQueue object will be instantiated and called as such:
     * MyQueue obj = new MyQueue();
     * obj.push(x);
     * int param_2 = obj.pop();
     * int param_3 = obj.peek();
     * boolean param_4 = obj.empty();
     */

    //implement stack from queue
    // all tc O(1) sc O(n)
    class MyStack {

        Queue<Integer> q;

        public MyStack() {
            q = new LinkedList<>();
        }

        public void push(int x) {

            q.offer(x);

            int size = q.size();

            for(int i = 0; i < size - 1; i++) {
                q.offer(q.poll());
            }
        }

        public int pop() {
            return q.poll();
        }

        public int top() {
            return q.peek();
        }

        public boolean empty() {
            return q.isEmpty();
        }
    }

    //min no of coins
    // tc sc O(1)
        public int findMin(int n) {

            int[] coins = {10, 5, 2, 1};
            int count = 0;

            for(int coin : coins) {
                count += n / coin;
                n %= coin;
            }

            return count;
        }

    //right view of tree
    //tc O(n) sc O(n)
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode temp=q.poll();
                if(i==size-1){
                    res.add(temp.val);
                }

                if(temp.left !=null) q.add(temp.left);
                if(temp.right !=null) q.add(temp.right);
            }
        }
        return res;
    }

    //left view of tree
    //tc O(n) sc O(n)
    public List<Integer> leftSideView(TreeNode root) {
        List<Integer> res=new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int size = q.size();
            for(int i=0;i<size;i++){
                TreeNode temp=q.poll();
                if(i==0){
                    res.add(temp.val);
                }

                if(temp.left !=null) q.add(temp.left);
                if(temp.right !=null) q.add(temp.right);
            }
        }
        return res;
    }
    public static void main(String[] args) {

    }
}
