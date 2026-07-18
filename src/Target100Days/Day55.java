package Target100Days;

public class Day55 {
    static class Node{
        int data;
        Node next;

        Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    static Node head;
    static Node tail;
    static int size=0;

    //Length of ll
    public static int length(Node head){
        Node temp=head;
        int count=0;
        while(temp!=null){
            count++;
            temp=temp.next;
        }
        return count;
    }

    //print ll
    public static void print(Node head){
        Node temp=head;
        while(temp!=null){
            System.out.println(temp.data + "->");
            temp=temp.next;
        }
        System.out.println("null");
    }

    //nth node from start
    //tc O(n) sc O(1)
    public static int nthNodeFromStart(int n){

        if(n<=0 || n>size){
            return -1;
        }

        Node temp=head;

        for(int i=1;i<n;i++){
            temp=temp.next;
        }

        return temp.data;
    }

    //tc O(n) sc O(1)
    public static int nthNodeFromEnd(int n){

        if(n<=0 || n>size){
            return -1;
        }

        Node temp=head;

        int position=size-n+1;

        for(int i=1;i<position;i++){
            temp=temp.next;
        }

        return temp.data;
    }

    //swapping nodes in linkedlist
    //tc O(n) sc O(1)
    public ListNode swapNodes(ListNode head, int k) {
        ListNode slow=head;
        ListNode fast=head;
        for(int i=1;i<=k;i++){
            fast=fast.next;
        }
        while(fast!=null){
            fast=fast.next;
            slow=slow.next;
        }
        ListNode first=head;
        for(int i=1;i<k;i++){
            first=first.next;
        }
        int temp=first.val;
        first.val=slow.val;
        slow.val=temp;
        return head;
    }

    public static void main(String[] args) {

    }
}
