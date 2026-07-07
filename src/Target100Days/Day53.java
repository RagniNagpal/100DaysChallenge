package Target100Days;
import java.util.*;

public class Day53 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
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
    public static void main(String[] args) {

    }
}
