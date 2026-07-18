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
//        if(head==null || head.next==null) return head;
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

    //Recursion

    //sabhki O(n) tc sc
    //print name
    public static int print(int n){
        if(n==0){
            return 0;
        }
        System.out.println("Ragni");
        return print(n-1);
    }

    //print n to 1
    public static int range1(int n){
        if(n==0){
            return 0;
        }
        System.out.println(n);
        return range1(n-1);
    }
    //print 1 to n
    public static void range2(int n){
        if(n==0){
            return;
        }
        range2(n-1);
        System.out.println(n);
    }

    //sum of first n
    public static int sum(int n){
        if(n==0){
            return 0;
        }
        return n + sum(n-1);
    }

    //factorial
    public static int fact(int n){
        if(n==0 || n==1){
            return 1;
        }
        return n*fact(n-1);
    }

    //reverse array
    public static void reverse(int[] arr){
        solve(0,arr.length-1,arr);
    }
    public static void solve(int start,int end,int[] arr){
        if(start >=end){
            return;
        }
        int temp=arr[start];
        arr[start]=arr[end];
        arr[end]=temp;
        solve(start+1,end-1,arr);
    }

//    check palindrome
    public static boolean palin(String str){
        return solve(0, str.length()-1, str);
    }
    public static boolean solve(int start,int end,String str){
        if(start>=end){
            return true;
        }
        if(str.charAt(start)!=str.charAt(end)){
            return false;
        }
        return solve(start+1,end-1,str);
    }


    public static void main(String[] args) {
        int n=5;
        print(n);
        range1(n);
        range2(n);
        System.out.println(sum(n));
        System.out.println(fact(n));
        int[] arr = {1,2,3,4,5};

        reverse(arr);

        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }

        String str = "madam";
        System.out.println(palin(str));
    }
}
