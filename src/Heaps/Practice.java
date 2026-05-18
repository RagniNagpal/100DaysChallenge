package Heaps;

import java.util.*;

public class Practice {

    // Heapify function
    public static void heapify(int[] arr, int n, int i) {

        int largest = i;

        int left = 2 * i + 1;

        int right = 2 * i + 2;

        // Check left child
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        // Check right child
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        // Swap if needed
        if (largest != i) {

            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }
    }

    // Build Max Heap
    public static void buildHeap(int[] arr) {

        int n = arr.length;

        // Start from last non-leaf node
        for (int i = n / 2 - 1; i >= 0; i--) {

            heapify(arr, n, i);
        }
    }

    // Kth Smallest Element
    public static int kthSmall(int[] arr, int k) {

        PriorityQueue<Integer> pq =
                new PriorityQueue<>(Collections.reverseOrder());

        for (int i = 0; i < arr.length; i++) {

            pq.add(arr[i]);

            // Keep only k smallest elements
            if (pq.size() > k) {

                pq.poll();
            }
        }

        return pq.peek();
    }

    // Kth Largest Element
    public static int kthLargest(int[] arr, int k) {

        PriorityQueue<Integer> pq =
                new PriorityQueue<>();

        for (int i = 0; i < arr.length; i++) {

            pq.add(arr[i]);

            // Keep only k largest elements
            if (pq.size() > k) {

                pq.poll();
            }
        }

        return pq.peek();
    }

    //top k frequent elements
    public int[] topKfreq(int[] nums,int k){
        HashMap<Integer,Integer> map=new HashMap<>();
        for(int num:nums){
            map.put(num,map.getOrDefault(num,0)+1);
        }
        PriorityQueue<Integer> pq=
    }

    //min cost of ropes
    public static int minCost(int[] arr){
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i=0;i<arr.length;i++){
            pq.add(arr[i]);}
        int count=0;
            while(pq.size() >1){
                int first=pq.poll();
                int sec=pq.poll();
                int sum=first+sec;
                count += sum;
                pq.add(sum);

        }
            return count;
    }
    // Print Array
    public static void print(int[] arr) {

        for (int num : arr) {

            System.out.print(num + " ");
        }

        System.out.println();
    }

    public static void main(String[] args) {

        int[] arr = {10, 20, 15, 30, 40};

        // Build Heap
        buildHeap(arr);

        System.out.println("Max Heap:");

        print(arr);

        // Kth Smallest
        int kthSmallest = kthSmall(arr, 2);

        System.out.println("2nd Smallest = " + kthSmallest);

        // Kth Largest
        int kthLargest = kthLargest(arr, 2);

        System.out.println("2nd Largest = " + kthLargest);
    }
}