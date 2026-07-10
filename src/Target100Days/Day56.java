package Target100Days;

public class Day56 {
    //Merge 2 sorted list
    //tc O(n+m) sc O(1)
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy=new ListNode (-1);
        ListNode temp=dummy;
        while(list1!=null && list2!=null){
            if(list1.val <= list2.val){
                temp.next=list1;
                list1=list1.next;
            }else{
                temp.next=list2;
                list2=list2.next;
            }
            temp=temp.next;
        }
        temp.next=(list1!=null) ? list1 :list2;
        return dummy.next;
    }

    //palindrome
    //tc O(n) sc O(1)
    public static ListNode rev(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode next=rev(head.next);
        ListNode temp=head.next;
        temp.next=head;
        head.next=null;
        return next;
    }
    public static boolean palin(ListNode head){
        if(head==null || head.next==null) return head;
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode second=rev(slow);
        ListNode first=head;
        while(second!=null){
//            if(first.val!=second) return false;
            first=first.next;
            second=second.next;
        }
        return true;
    }

    //
    public static void main(String[] args) {

    }
}
