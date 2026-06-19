package Target100Days;
import java.util.*;

public class Day37 {
    public class ListNode {
    int val;
    ListNode next;
     ListNode(int x) {
         val = x;
          next = null;
      }
  }
    //Intersection of two nodes
    //Time Complexity: O(2 × max(length of list1, length of list2))
    //Space Complexity: O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null) return null;
        ListNode a=headA;
        ListNode b=headB;
        while(a !=b){
            a=(a==null) ? headB:a.next;
            b=(b==null) ? headA:b.next;
        }
        return a;
    }

    //Time Complexity: O(n + m), Iterating through list 1 first takes O(n), then iterating through list 2 takes O(m).
    //Space Complexity: O(n),
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Set<ListNode> st = new HashSet<>();
        while (headA != null) {
            st.add(headA);
            headA = headA.next;
        }
        while (headB != null) {
            if (st.contains(headB)) return headB;
            headB = headB.next;
        }
        return null;
    }

    //length of longest substring without repeating ch
    // tc O(n^3) sc O(n)
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLen = 0;
        for(int i=0;i<n;i++){
            for(int j=i;j<n;j++){
                String sub=s.substring(i,j+1);
                if(unique(sub)){
                    maxLen = Math.max(maxLen, sub.length());
                }
            }

        }
        return maxLen;
    }
    public static boolean unique(String s) {
        Set<Character> st = new HashSet<>();

        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if(st.contains(ch))
                return false;

            st.add(ch);
        }

        return true;
    }

    // tc O(n^2) sc O(1)
    public int lengthOfLongestSubstring2(String s) {
        int n = s.length();
        int maxLen = 0;
        for(int i=0;i<n;i++){
            int[] hash=new int[256];
            Arrays.fill(hash,0);
            for(int j=i;j<n;j++){
                if(hash[s.charAt(j)]==1) break;
                hash[s.charAt(j)]=1;
                int len=j-i+1;
                maxLen=Math.max(maxLen,len);
            }

        }
        return maxLen;
    }

    // tc sc O(n)
    public int lengthOfLongestSubstring3(String s) {
        int n=s.length();
        int i=0;
        int j=0;
        int max=0;
        int sum=0;
        HashSet<Character> set = new HashSet<>();
        while(j<n){
            char ch=s.charAt(j);
            if(!set.contains(ch)){
                set.add(ch);
                max=Math.max(max,j-i+1);
                j++;
            }else{
                set.remove(s.charAt(i));
                i++;
            }
        }
        return max;
    }

    // Convert Sorted Array to Binary Search Tree
    // tc O(n) sc O(log n)
    public TreeNode sortedArrayToBST(int[] nums) {
        int n=nums.length;
        return solve(nums,0,n-1);
    }
    public TreeNode solve(int[] nums,int start,int end){
        if(start > end) return null;
        int mid=start+(end-start)/2;
        TreeNode root=new TreeNode(nums[mid]);
        root.left=solve(nums,start,mid-1);
        root.right=solve(nums,mid+1,end);
        return root;

    }

    // implement minstack
    //tc O(!) sc O(n)
    class MinStack {
        private Stack<Integer> stack;
        private Stack<Integer> minstack;

        public MinStack() {
            stack=new Stack<>();
            minstack=new Stack<>();
        }

        public void push(int value) {
            stack.push(value);
            if(minstack.isEmpty()){
                minstack.push(value);
            }
            else{minstack.push(Math.min(value,minstack.peek()));}
        }

        public void pop() {
            stack.pop();
            minstack.pop();
        }

        public int top() {
            return stack.peek();
        }

        public int getMin() {
            return minstack.peek();
        }
    }

    /**
     * Your MinStack object will be instantiated and called as such:
     * MinStack obj = new MinStack();
     * obj.push(value);
     * obj.pop();
     * int param_3 = obj.top();
     * int param_4 = obj.getMin();
     */

    //queue implementation using array
        // all tc O(1)  deque O(n)sc O(n)
    class myQueue {
        int[] arr;
        int front, rear;
        int size;
        int count;

        public myQueue(int n) {
            arr = new int[n];
            size = n;
            front = 0;
            rear = -1;
            count = 0;
        }

        public boolean isEmpty() {
            return count == 0;
        }

        public boolean isFull() {
            return count == size;
        }

        public void enqueue(int x) {
            if (isFull()) return;

            arr[++rear] = x;
            count++;
        }

        public int dequeue() {
            if (isEmpty()) return -1;

            count--;
            return arr[front++];
        }

        public int getFront() {
            if (isEmpty()) return -1;
            return arr[front];
        }

        public int getRear() {
            if (isEmpty()) return -1;
            return arr[rear];
        }
    }

    //implement stack using arr
    // tc O(1) sc O(n)
    class myStack {
        int[] arr;
        int size;
        int top;

        public myStack(int n) {
            arr = new int[n];
            size = n;
            top = -1;
        }

        public boolean isEmpty() {
            return top == -1;
        }

        public boolean isFull() {
            return top == size - 1;
        }

        public void push(int x) {
            if (isFull())
                return;

            arr[++top] = x;
        }

        public int pop() {
            if (isEmpty())
                return -1;

            return arr[top--];
        }

        public int peek() {
            if (isEmpty())
                return -1;

            return arr[top];
        }
    }
    public static void main(String[] args) {

    }
}
