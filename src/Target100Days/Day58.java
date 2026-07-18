package Target100Days;

public class Day58 {
    //Print array
    //O(n)
    //O(n)
    public static void print(int[] arr,int idx){
        int n=arr.length;
        if(idx == n){
            return ;
        }
        System.out.println(arr[idx]);
        print(arr,idx+1);
    }
    //Find max
    //O(n)
    //O(n)
    public static int max(int[] arr,int idx){
        int n=arr.length;
        if(idx==n-1){
            return arr[idx];
        }
        int max=max(arr,idx+1);
        return Math.max(max,arr[idx]);
    }
    //Find min
    //O(n)
    //O(n)
    public static int min(int[] arr,int idx){
        if(idx==arr.length-1){
            return arr[idx];
        }
        int min=min(arr,idx+1);
        return Math.min(min,arr[idx]);
    }
    //Linear search
    //O(n)
    //O(n)
    public static boolean search(int[] arr,int idx,int target){
        if(idx==arr.length){
            return false;
        }
        if(arr[idx]==target) return true;
        return search(arr,idx+1,target);
    }

    //Check sorted array
    //O(n)
    //O(n)
    public static boolean sorted(int[] arr,int idx){
        if(idx==arr.length-1){
            return true;
        }
        if(arr[idx]>arr[idx+1]) return false;
        return sorted(arr,idx+1);
    }
    // climb stairs
    //O(2ⁿ)
    //O(n)
    public int climbStairs(int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return 1;
        return climbStairs(n-1) + climbStairs(n-2);
    }

    //rotate and sorted array
    //O(n)
    //O(n)
    public boolean check(int[] nums) {
        if (sort(nums, 0)) {
            return true;
        }
        return rotate(nums, 0) <= 1;
    }
    // Check if already sorted
    //O(n)
    //O(n)
    public static boolean sort(int[] nums, int idx) {
        if (idx == nums.length - 1) {
            return true;
        }
        if (nums[idx] > nums[idx + 1]) {
            return false;
        }
        return sort(nums, idx + 1);
    }
    // Count number of breaks
    //O(n)
    //O(n)
    public static int rotate(int[] nums, int idx) {
        if (idx == nums.length - 1) {
            if (nums[idx] > nums[0]) {
                return 1;
            }
            return 0;
        }
        int count = 0;
        if (nums[idx] > nums[idx + 1]) {
            count = 1;
        }
        return count + rotate(nums, idx + 1);
    }

    //count even digit no
    //O(n × d) (d = number of digits)
    //O(1)
    public int findNumbers(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            int digits = count(num);
            if (digits % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }
    //O(d)
    //O(1)
    public static int count(int num) {
        if (num == 0) {
            return 1;
        }
        int count = 0;
        while (num > 0) {
            num = num / 10;
            count++;
        }
        return count;
    }

    //power set
    //O(2ⁿ × n)
    //O(n)
    public static void subsets(String ans, String s, int idx) {
        if (idx == s.length()) {
            System.out.println(ans);
            return;
        }
        char ch = s.charAt(idx);
        subsets(ans + ch, s, idx + 1);
        subsets(ans, s, idx + 1);
    }

        public static void main(String[] args) {

            int[] arr = {1, 2, 3, 4, 5};

            // Print Array
            System.out.println("Print Array:");
            print(arr, 0);

            // Maximum
            System.out.println("\nMaximum Element:");
            System.out.println(max(arr, 0));

            // Minimum
            System.out.println("\nMinimum Element:");
            System.out.println(min(arr, 0));

            // Linear Search
            System.out.println("\nLinear Search (4):");
            System.out.println(search(arr, 0, 4));

            // Sorted Array
            System.out.println("\nIs Sorted?");
            System.out.println(sorted(arr, 0));

            Day58 obj = new Day58();

            // Climbing Stairs
            System.out.println("\nClimbing Stairs (n = 5):");
            System.out.println(obj.climbStairs(5));

            // Sorted and Rotated
            int[] nums = {3, 4, 5, 1, 2};

            System.out.println("\nSorted and Rotated?");
            System.out.println(obj.check(nums));

            // Even Digit Numbers
            int[] nums2 = {12, 345, 2, 6, 7896};

            System.out.println("\nEven Digit Count:");
            System.out.println(obj.findNumbers(nums2));

            // Power Set
            System.out.println("\nPower Set:");
            subsets("", "abc", 0);
        }
    }

