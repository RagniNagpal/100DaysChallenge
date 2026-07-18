package Target100Days;
import java.util.*;

public class Day13 {
    //merge sort
    //quick sort

    //collection linkedlist
    public static void CollLL(){
        LinkedList<Integer> llist=new LinkedList<>();
        llist.add(1);
        llist.add(2);
        llist.add(3);
        llist.addFirst(5);
        llist.addLast(8);
        llist.get(2);
        llist.getFirst();
        llist.getLast();
//        llist.remove();   //first
//        llist.removeFirst();
//        llist.removeLast();
//        llist.remove(5);
//        llist.remove(Integer.valueOf(1));
        llist.contains(30);
        llist.size();
//        llist.clear();
        llist.set(1, 99);
        for(int i = 0; i < llist.size(); i++) {
            System.out.println(llist.get(i));
        }

        for(int x : llist) {
            System.out.println(x);
        }

        Iterator<Integer> it = llist.iterator();

        while(it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println(llist);
    }

    // Remove Nth Node From End - 19
    public static void removeNth() {

        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        int n = 2;

        int idx = list.size() - n;

        list.remove(idx);

        System.out.println("After Removing : " + list);
    }
    // Merge Two Sorted Lists - 21
    public static void mergeLL() {

        LinkedList<Integer> l1 = new LinkedList<>();
        LinkedList<Integer> l2 = new LinkedList<>();

        l1.add(1);
        l1.add(3);
        l1.add(5);

        l2.add(2);
        l2.add(4);
        l2.add(6);

        LinkedList<Integer> ans = new LinkedList<>();

        ans.addAll(l1);
        ans.addAll(l2);

        Collections.sort(ans);

        System.out.println("Merged LinkedList : " + ans);
    }
    // Middle of Linked List - 876
    public static void middleLL() {

        LinkedList<Integer> list = new LinkedList<>();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);
        list.add(50);

        int mid = list.size() / 2;

        System.out.println("Middle Element : " + list.get(mid));
    }
    // Reverse Linked List - 206
    public static void reverseLL() {

        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);

        Collections.reverse(list);

        System.out.println("Reverse Linked List : " + list);
    }

    // Linked List Cycle - 141
    public static void cycleLL() {

        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);

        HashSet<Integer> set = new HashSet<>();

        boolean cycle = false;

        for (int x : list) {

            if (set.contains(x)) {
                cycle = true;
                break;
            }

            set.add(x);
        }

        System.out.println("Cycle Present : " + cycle);
    }

    // Palindrome Linked List - 234
    public static void palindromeLL() {

        LinkedList<Integer> list = new LinkedList<>();

        list.add(1);
        list.add(2);
        list.add(2);
        list.add(1);

        LinkedList<Integer> rev = new LinkedList<>(list);

        Collections.reverse(rev);

        System.out.println("Palindrome : " + list.equals(rev));
    }
    public static void main(String[] args) {
        CollLL();
      System.out.println();

        reverseLL();
        middleLL();
        cycleLL();
        mergeLL();
        removeNth();
        palindromeLL();

    }
}

//| Problem                                   | Time Complexity             | Space Complexity | Reason                       |
//        | ----------------------------------------- | --------------------------- | ---------------- | ---------------------------- |
//        | Reverse Linked List (Collections.reverse) | (\boxed{O(n)})              | (\boxed{O(1)})   | Reverse traverses list once  |
//        | Middle of Linked List                     | (\boxed{O(n)})              | (\boxed{O(1)})   | `size()` + `get()`           |
//        | Linked List Cycle (using HashSet)         | (\boxed{O(n)})              | (\boxed{O(n)})   | HashSet stores visited nodes |
//        | Merge Two Sorted Lists                    | (\boxed{O((n+m)\log(n+m))}) | (\boxed{O(n+m)}) | merge + sorting              |
//        | Remove Nth Node From End                  | (\boxed{O(n)})              | (\boxed{O(1)})   | size traversal + remove      |
//        | Palindrome Linked List                    | (\boxed{O(n)})              | (\boxed{O(n)})   | copied reversed list         |
