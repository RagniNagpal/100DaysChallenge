package Target100Days;

import java.util.*;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class Day51 {
    // reverse ll
    // tc: O(n), sc: O(n) due to call stack
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode newHead = reverseList(head.next);
        ListNode temp = head.next;
        temp.next = head;
        head.next = null;

        return newHead;
    }

    //tc O(n) sc O(1)\
    public ListNode reverseList2(ListNode head) {
        ListNode prev=null;
        ListNode temp=head;
        while(temp!=null){
            ListNode front=temp.next;
            temp.next=prev;
            prev=temp;
            temp=front;
        }
        return prev;
    }
    public static void main(String[] args) {
        // Test your logic here
    }
}
