package Heaps;

import java.util.ArrayList;

public class MaxHeap {

    private ArrayList<Integer> heap;

    public MaxHeap() {
        heap = new ArrayList<>();
    }

    // ==========================
    // Build Heap
    // ==========================

    public void buildHeap(int[] arr) {

        heap.clear();

        for (int val : arr) {
            heap.add(val);
        }

        for (int i = (heap.size() / 2) - 1; i >= 0; i--) {
            heapifyDown(i);
        }
    }

    // ==========================
    // Insert
    // ==========================

    public void insert(int value) {

        heap.add(value);

        heapifyUp(heap.size() - 1);
    }

    // ==========================
    // Heapify Up
    // ==========================

    private void heapifyUp(int index) {

        while (index > 0) {

            int parent = (index - 1) / 2;

            if (heap.get(parent) >= heap.get(index))
                break;

            swap(parent, index);

            index = parent;
        }
    }

    // ==========================
    // Peek
    // ==========================

    public int peek() {

        if (heap.isEmpty())
            throw new RuntimeException("Heap is Empty");

        return heap.get(0);
    }

    // ==========================
    // Extract Max
    // ==========================

    public int extractMax() {

        if (heap.isEmpty())
            throw new RuntimeException("Heap is Empty");

        int max = heap.get(0);

        heap.set(0, heap.get(heap.size() - 1));

        heap.remove(heap.size() - 1);

        if (!heap.isEmpty())
            heapifyDown(0);

        return max;
    }

    // ==========================
    // Heapify Down
    // ==========================

    private void heapifyDown(int index) {

        int size = heap.size();

        while (true) {

            int left = 2 * index + 1;
            int right = 2 * index + 2;

            int largest = index;

            if (left < size && heap.get(left) > heap.get(largest))
                largest = left;

            if (right < size && heap.get(right) > heap.get(largest))
                largest = right;

            if (largest == index)
                break;

            swap(index, largest);

            index = largest;
        }
    }

    // ==========================
    // Swap
    // ==========================

    private void swap(int i, int j) {

        int temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }

    // ==========================
    // Print
    // ==========================

    public void printHeap() {

        System.out.println(heap);
    }

    // ==========================
    // Main Method
    // ==========================

    public static void main(String[] args) {

        MaxHeap heap = new MaxHeap();

        System.out.println("Insertion");

        heap.insert(50);
        heap.insert(30);
        heap.insert(40);
        heap.insert(10);
        heap.insert(20);
        heap.insert(35);
        heap.insert(38);

        heap.printHeap();

        System.out.println("Peek = " + heap.peek());

        System.out.println("Extract Max = " + heap.extractMax());

        heap.printHeap();

        System.out.println();

        int[] arr = {15, 10, 30, 40, 5, 60, 25};

        heap.buildHeap(arr);

        System.out.println("Build Heap");

        heap.printHeap();
    }
}
// ```

// ---

// ## Output

// ```text
// [50, 30, 40, 10, 20, 35, 38]

// 50

// 50

// [40, 30, 38, 10, 20, 35]
// ```

// ---

// # Interview mein har function ka purpose

// ### `insert(int value)`

// * Last mein element add karta hai.
// * Heap property toot sakti hai.
// * Isliye `heapifyUp()` call hota hai.

// **Complexity:** `O(log n)`

// ---

// ### `heapifyUp(int index)`

// * Naye inserted element ko parent ke saath compare karta hai.
// * Jab tak parent chhota hai, swap karta rehta hai.
// * Root tak ya correct position tak pahunchta hai.

// **Complexity:** `O(log n)`

// ---

// ### `peek()`

// * Root return karta hai.
// * Koi modification nahi hoti.

// **Complexity:** `O(1)`

// ---

// ### `extractMax()`

// 1. Root save karo.
// 2. Last element ko root par lao.
// 3. Last remove karo.
// 4. `heapifyDown()` call karo.
// 5. Maximum return karo.

// **Complexity:** `O(log n)`

// ---

// ### `heapifyDown(int index)`

// * Parent ko dono children se compare karta hai.
// * Bade child ke saath swap karta hai.
// * Jab tak heap property restore na ho jaye, continue karta hai.

// **Complexity:** `O(log n)`

// ---

// ### `swap(int i, int j)`

// * Do elements ki position exchange karta hai.

// **Complexity:** `O(1)`

// ---

// # Important Interview Question ⭐

// **Why do we call `heapifyUp()` after insertion but `heapifyDown()` after deletion?**

// **Answer:**

// * **Insertion:** Naya element hamesha last position par aata hai. Complete Binary Tree property already maintain hoti hai, sirf parent-child relation toot sakta hai. Isliye element ko **upar (towards root)** move karte hain using **Heapify Up**.
// * **Deletion (Extract Max):** Last element ko root par laaya jata hai. Ab problem root se start hoti hai, isliye us element ko **neeche (towards leaves)** move karte hain using **Heapify Down**.

// Ye implementation samajh aa gaya to agla step hoga **Build Heap**, **PriorityQueue ka internal working**, aur **Heap Sort**, jo isi code par based honge.



