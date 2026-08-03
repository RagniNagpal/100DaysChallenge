package ReRevise;

public class deleteMiddle {
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public ListNode deleteMiddle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        int size = count(head);
        ListNode temp = head;

        for (int i = 0; i < size / 2 - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;
        return head;
    }

    public static int count(ListNode head) {
        int count = 0;
        ListNode temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        deleteMiddle solution = new deleteMiddle();
        System.out.println("Before: ");
        printList(head);

        ListNode result = solution.deleteMiddle(head);
        System.out.println("After deleting the middle node: ");
        printList(result);
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
        }
    }
}