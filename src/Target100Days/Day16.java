package Target100Days;

import java.util.*;

public class Day16 {

    // Three Sum
    // Time Complexity: O(n²)
    // Space Complexity: O(1)

    public static boolean threeSum(int[] nums, int target, int n) {

        Arrays.sort(nums);

        for (int i = 0; i < n - 2; i++) {

            int left = i + 1;
            int right = n - 1;

            while (left < right) {

                long sum = (long) nums[i] + nums[left] + nums[right];

                if (sum == target) {
                    return true;
                }

                if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        return false;
    }

    // Merge Two Sorted Arrays
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int k = m + n;

        int[] result = new int[k];

        int index = 0;

        // copy nums1
        for (int i = 0; i < m; i++) {
            result[index++] = nums1[i];
        }

        // copy nums2
        for (int i = 0; i < n; i++) {
            result[index++] = nums2[i];
        }

        // sort merged array
        Arrays.sort(result);

        // copy back to nums1
        for (int i = 0; i < k; i++) {
            nums1[i] = result[i];
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ---------- THREE SUM ----------

        System.out.println("Enter size of array:");

        int n = sc.nextInt();

        int[] nums = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println("Enter target:");

        int target = sc.nextInt();

        boolean ans = threeSum(nums, target, n);

        System.out.println("Three Sum Exists: " + ans);

        // ---------- MERGE TWO SORTED ARRAYS ----------

        System.out.println("\nEnter size of first sorted array:");

        int m = sc.nextInt();

        int[] nums1 = new int[m + 10];

        System.out.println("Enter first sorted array:");

        for (int i = 0; i < m; i++) {
            nums1[i] = sc.nextInt();
        }

        System.out.println("Enter size of second sorted array:");

        int p = sc.nextInt();

        int[] nums2 = new int[p];

        System.out.println("Enter second sorted array:");

        for (int i = 0; i < p; i++) {
            nums2[i] = sc.nextInt();
        }

        Day16 obj = new Day16();

        obj.merge(nums1, m, nums2, p);

        System.out.println("Merged Array:");

        for (int i = 0; i < m + p; i++) {
            System.out.print(nums1[i] + " ");
        }

        sc.close();
    }
}