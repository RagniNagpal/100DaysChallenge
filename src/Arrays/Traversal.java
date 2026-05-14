package Arrays;

import java.util.*;

public class Traversal {

    // ================= LEVEL 1 =================

    // Largest element
    public static int largest(int[] arr) {

        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > max) {
                max = arr[i];
            }
        }

        return max;
    }

    // Smallest element
    public static int smallest(int[] arr) {

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] < min) {
                min = arr[i];
            }
        }

        return min;
    }

    // Second largest element
    public static int secLargest(int[] arr) {

        int max = Integer.MIN_VALUE;
        int secMax = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] > max) {

                secMax = max;
                max = arr[i];

            } else if (arr[i] > secMax && arr[i] != max) {

                secMax = arr[i];
            }
        }

        return secMax;
    }

    // Count even and odd
    public static void countEO(int[] arr) {

        int even = 0;
        int odd = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        System.out.println("Even = " + even);
        System.out.println("Odd = " + odd);
    }

    // Check sorted
    public static boolean sorted(int[] arr) {

        for (int i = 0; i < arr.length - 1; i++) {

            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }

        return true;
    }

    // Bubble Sort
    public static void sort(int[] arr) {

        int n = arr.length;

        for (int i = 0; i < n; i++) {

            for (int j = 0; j < n - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {

                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        System.out.println(Arrays.toString(arr));
    }

    // Reverse array
    public static void rev(int[] arr) {

        int left = 0;
        int right = arr.length - 1;

        while (left < right) {

            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;

            left++;
            right--;
        }

        System.out.println(Arrays.toString(arr));
    }

    // Count negative numbers
    public static int countNeg(int[] arr) {

        int count = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] < 0) {
                count++;
            }
        }

        return count;
    }

    // ================= LEVEL 2 =================

    // Maximum frequency
    public static int maxFreq(int[] arr) {

        int max = 0;

        for (int i = 0; i < arr.length; i++) {

            int count = 0;

            for (int j = 0; j < arr.length; j++) {

                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            if (count > max) {
                max = count;
            }
        }

        return max;
    }

    // Move zeroes to end
    public static int[] moveZero(int[] arr) {

        int[] ans = new int[arr.length];

        int idx = 0;

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] != 0) {
                ans[idx++] = arr[i];
            }
        }

        return ans;
    }

    // Linear Search
    public static int linear(int[] arr, int target) {

        for (int i = 0; i < arr.length; i++) {

            if (arr[i] == target) {
                return i;
            }
        }

        return -1;
    }

    // Remove duplicates
    public static Set<Integer> single(int[] arr) {

        Set<Integer> set = new HashSet<>();

        for (int a : arr) {
            set.add(a);
        }

        return set;
    }

    // ================= LEVEL 3 =================

    // Missing number from 1 to n
    public static int missing(int[] arr) {

        int n = arr.length + 1;

        int total = n * (n + 1) / 2;

        int sum = 0;

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];
        }

        return total - sum;
    }

    // Element appearing once (brute force)
    public static int appOnce(int[] arr) {

        for (int i = 0; i < arr.length; i++) {

            int count = 0;

            for (int j = 0; j < arr.length; j++) {

                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            if (count == 1) {
                return arr[i];
            }
        }

        return -1;
    }

    // XOR approach
    public static int xorOnce(int[] arr) {

        int res = 0;

        for (int a : arr) {

            res = res ^ a;
        }

        return res;
    }

    // Majority element
    public static int maj(int[] arr) {

        int n = arr.length;

        for (int i = 0; i < n; i++) {

            int count = 1;

            for (int j = i + 1; j < n; j++) {

                if (arr[i] == arr[j]) {
                    count++;
                }
            }

            if (count > n / 2) {
                return arr[i];
            }
        }

        return -1;
    }

    // Kadane's Algorithm
    public static int kadane(int[] arr) {

        int sum = 0;
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {

            sum += arr[i];

            max = Math.max(max, sum);

            if (sum < 0) {
                sum = 0;
            }
        }

        return max;
    }

    // Best time to buy and sell stock
    public static int buyAndSell(int[] arr) {

        int maxProfit = 0;

        for (int i = 0; i < arr.length; i++) {

            for (int j = i + 1; j < arr.length; j++) {

                int profit = arr[j] - arr[i];

                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }

    // ================= LEVEL 4 =================

    // Union of arrays
    public static Set<Integer> union(int[] arr1, int[] arr2) {

        Set<Integer> set = new HashSet<>();

        for (int a : arr1) {
            set.add(a);
        }

        for (int a : arr2) {
            set.add(a);
        }

        return set;
    }

    // Intersection of arrays
    public static int[] intersect(int[] arr1, int[] arr2) {

        HashSet<Integer> set1 = new HashSet<>();
        HashSet<Integer> inter = new HashSet<>();

        for (int a : arr1) {
            set1.add(a);
        }

        for (int a : arr2) {

            if (set1.contains(a)) {
                inter.add(a);
            }
        }

        int[] ans = new int[inter.size()];

        int idx = 0;

        for (int a : inter) {
            ans[idx++] = a;
        }

        return ans;
    }

    // ================= MAIN =================

    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 3};

        System.out.println("Largest: " + largest(arr));

        System.out.println("Smallest: " + smallest(arr));

        System.out.println("Second Largest: " + secLargest(arr));

        countEO(arr);

        System.out.println("Sorted: " + sorted(arr));

        rev(arr);

        System.out.println("Negative Count: " + countNeg(arr));

        System.out.println("Linear Search index: " + linear(arr, 3));

        System.out.println("Max Frequency: " + maxFreq(arr));

        int[] zero = {0, 1, 0, 3, 12};

        System.out.println("Move Zeroes: " + Arrays.toString(moveZero(zero)));

        int[] miss = {1, 2, 4, 5};

        System.out.println("Missing Number: " + missing(miss));

        int[] once = {2, 1, 4, 1, 2};

        System.out.println("Appearing Once: " + appOnce(once));

        System.out.println("XOR Once: " + xorOnce(once));

        int[] majority = {2, 2, 1, 2, 3, 2, 2};

        System.out.println("Majority Element: " + maj(majority));

        int[] kad = {-2, 1, -3, 4, -1, 2, 1, -5, 4};

        System.out.println("Kadane: " + kadane(kad));

        int[] stock = {7, 1, 5, 3, 6, 4};

        System.out.println("Buy and Sell: " + buyAndSell(stock));

        int[] a = {1, 2, 3};
        int[] b = {2, 3, 4};

        System.out.println("Union: " + union(a, b));

        System.out.println("Intersection: " + Arrays.toString(intersect(a, b)));
    }
}