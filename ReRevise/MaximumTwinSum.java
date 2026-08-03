package ReRevise;

import java.util.ArrayList;
import java.util.List;

public class MaximumTwinSum {

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int pairSum(ListNode head) {
        List<Integer> list=new ArrayList<>();
        ListNode temp=head;
        while(temp != null){
            list.add(temp.val);
            temp=temp.next;
        }
        int maxSum=0;
        int n=list.size();
        for(int i=0;i<n/2;i++){
            int sum=list.get(i) + list.get(n-1-i);
            maxSum=Math.max(maxSum,sum);
        }
        return maxSum;
    }
    

    public static void main(String[] args) {
        MaximumTwinSum solution = new MaximumTwinSum();

        ListNode head = new ListNode(5);
        head.next = new ListNode(4);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(1);

        System.out.println("Maximum twin sum = " + solution.pairSum(head));
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}
