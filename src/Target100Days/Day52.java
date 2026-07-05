package Target100Days;

public class Day52 {
    //Add 2 no
    //tc sc O(max(m,n))
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy=new ListNode(0);
        ListNode temp=dummy;
        int carry=0;
        while(l1!=null || l2!=null || carry!=0){
            int sum=carry;
            if(l1!=null){
                sum+=l1.val;
                l1=l1.next;
            }if(l2!=null){
                sum+=l2.val;
                l2=l2.next;
            }
            carry=sum/10;
            temp.next=new ListNode(sum%10);
            temp=temp.next;
        }
        return dummy.next;
    }

    //palindrome
    //tc sc o(n)
    public ListNode reverseLinkedList(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode newHead=reverseLinkedList(head.next);
        ListNode temp=head.next;
        temp.next=head;
        head.next=null;
        return newHead;
    }
    public boolean isPalindrome(ListNode head) {
        if(head==null || head.next==null) return true;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode second = reverseLinkedList(slow);
        ListNode first = head;
        while(second!=null){
            if(first.val!=second.val){
                return false;
            }
            first=first.next;
            second=second.next;
        }
        return true;
    }
    public static void main(String[] args) {

    }
}
