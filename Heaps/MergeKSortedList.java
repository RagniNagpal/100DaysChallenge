package Heaps;

import java.util.PriorityQueue;

public class MergeKSortedList {
  public ListNode mergeKLists(ListNode[] lists) {

        // Min-Heap based on node value
        PriorityQueue<ListNode> pq =
            new PriorityQueue<>((a, b) -> a.val - b.val);

        // Step 1: add head of each list
        for (ListNode node : lists) {
            if (node != null) {
                pq.add(node);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        // Step 2: process heap
        while (!pq.isEmpty()) {
            ListNode minNode = pq.poll();
            curr.next = minNode;
            curr = curr.next;

            if (minNode.next != null) {
                pq.add(minNode.next);
            }
        }

        return dummy.next;
    }
}
