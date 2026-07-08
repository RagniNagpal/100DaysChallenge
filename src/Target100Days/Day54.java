package Target100Days;

public class Day54 {

    // ================= NODE CLASS =================
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // ================= VARIABLES =================
    static Node head;
    static Node tail;
    static int size = 0;

    // ================= INSERT FIRST =================
    public static void insertFirst(int data) {

        Node temp = new Node(data);

        if (head == null) {
            head = tail = temp;
        } else {
            temp.next = head;
            head = temp;
        }

        size++;
    }

    // ================= INSERT LAST =================
    public static void insertLast(int data) {

        Node temp = new Node(data);

        if (head == null) {
            head = tail = temp;
        } else {
            tail.next = temp;
            tail = temp;
        }

        size++;
    }

    // ================= INSERT AT INDEX =================
    public static void insertAtIndex(int index, int data) {

        if (index < 0 || index > size) {
            System.out.println("Invalid Index");
            return;
        }

        if (index == 0) {
            insertFirst(data);
            return;
        }

        if (index == size) {
            insertLast(data);
            return;
        }

        Node temp = head;

        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        Node node = new Node(data);

        node.next = temp.next;
        temp.next = node;

        size++;
    }

    // ================= DISPLAY =================
    public static void display() {

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }

        System.out.println("null");
    }

    // ================= DELETE FIRST =================
    public static void deleteFirst() {

        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
        }

        size--;
    }

    // ================= DELETE LAST =================
    public static void deleteLast() {

        if (head == null) {
            System.out.println("List is Empty");
            return;
        }

        if (head == tail) {
            head = tail = null;
            size--;
            return;
        }

        Node temp = head;

        while (temp.next != tail) {
            temp = temp.next;
        }

        temp.next = null;
        tail = temp;

        size--;
    }

    // ================= DELETE AT INDEX =================
    public static void deleteAtIndex(int index) {

        if (index < 0 || index >= size) {
            System.out.println("Invalid Index");
            return;
        }

        if (index == 0) {
            deleteFirst();
            return;
        }

        if (index == size - 1) {
            deleteLast();
            return;
        }

        Node temp = head;

        for (int i = 0; i < index - 1; i++) {
            temp = temp.next;
        }

        temp.next = temp.next.next;

        size--;
    }

    // ================= SEARCH =================
    public static boolean search(int key) {

        Node temp = head;

        while (temp != null) {

            if (temp.data == key)
                return true;

            temp = temp.next;
        }

        return false;
    }

    // ================= GET SIZE =================
    public static int getSize() {
        return size;
    }

    // ================= IS EMPTY =================
    public static boolean isEmpty() {
        return head == null;
    }

    // ================= GET FIRST =================
    public static int getFirst() {

        if (head == null)
            return -1;

        return head.data;
    }

    // ================= GET LAST =================
    public static int getLast() {

        if (tail == null)
            return -1;

        return tail.data;
    }

    // ================= COUNT NODES =================
    public static int countNodes() {

        int count = 0;

        Node temp = head;

        while (temp != null) {
            count++;
            temp = temp.next;
        }

        return count;
    }

    // ================= PRINT RECURSIVELY =================
    public static void print(Node node) {

        if (node == null)
            return;

        System.out.print(node.data + " ");

        print(node.next);
    }

    // ================= REVERSE ITERATIVE =================
    public static void reverse() {

        Node prev = null;
        Node curr = head;
        tail = head;

        while (curr != null) {

            Node next = curr.next;

            curr.next = prev;

            prev = curr;
            curr = next;
        }

        head = prev;
    }

    // ================= REVERSE RECURSIVELY =================
    public static Node reverseRecursive(Node head) {

        if (head == null || head.next == null)
            return head;

        Node newHead = reverseRecursive(head.next);

        head.next.next = head;
        head.next = null;

        return newHead;
    }

    // ================= FIND MIDDLE =================
    public static Node middle() {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    // ================= DETECT CYCLE =================
    public static boolean hasCycle() {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast)
                return true;
        }

        return false;
    }

    // ================= REMOVE CYCLE =================
    public static void removeCycle() {

        Node slow = head;
        Node fast = head;

        boolean cycle = false;

        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                cycle = true;
                break;
            }
        }

        if (!cycle)
            return;

        slow = head;
        Node prev = null;

        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        if (prev != null)
            prev.next = null;
    }

    // ================= MAIN METHOD =================
    public static void main(String[] args) {

        insertFirst(20);
        insertFirst(10);

        insertLast(30);
        insertLast(40);

        display();

        insertAtIndex(2, 25);
        display();

        deleteFirst();
        display();

        deleteLast();
        display();

        deleteAtIndex(1);
        display();

        System.out.println("Search 30 : " + search(30));
        System.out.println("Size : " + getSize());
        System.out.println("Count : " + countNodes());
        System.out.println("First : " + getFirst());
        System.out.println("Last : " + getLast());

        reverse();
        display();

        head = reverseRecursive(head);

        tail = head;
        while (tail != null && tail.next != null) {
            tail = tail.next;
        }

        display();

        Node mid = middle();
        if (mid != null)
            System.out.println("Middle : " + mid.data);

        System.out.println("Has Cycle : " + hasCycle());

        System.out.print("Recursive Print : ");
        print(head);
    }
}