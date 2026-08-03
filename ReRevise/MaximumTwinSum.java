package ReRevise;

import java.util.ArrayList;
import java.util.List;

public class MaximumTwinSum {

    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int pairSum(ListNode head) {
        List<Integer> values = new ArrayList<>();
        ListNode temp = head;

        while (temp != null) {
            values.add(temp.val);
            temp = temp.next;
        }

        int left = 0;
        int right = values.size() - 1;
        int maxSum = 0;

        while (left < right) {
            maxSum = Math.max(maxSum, values.get(left) + values.get(right));
            left++;
            right--;
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
