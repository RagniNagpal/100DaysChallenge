package ReRevise;

public class reverse {
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public static void rotateLeft(int[] arr, int k) {
        int n = arr.length;
        if (n == 0) {
            return;
        }

        k = k % n;
        reverseArray(arr, 0, k - 1);
        reverseArray(arr, k, n - 1);
        reverseArray(arr, 0, n - 1);
    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) {
            return;
        }

        k = k % n;
        reverseArray(nums, 0, n - 1);
        reverseArray(nums, 0, k - 1);
        reverseArray(nums, k, n - 1);
    }

    private static void reverseArray(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6};
        rotateLeft(arr, 2);
        System.out.println("Left rotated array:");
        printArray(arr);

        int[] nums = {1, 2, 3, 4, 5, 6};
        rotate(nums, 2);
        System.out.println("Rotated array:");
        printArray(nums);
    }

    private static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
