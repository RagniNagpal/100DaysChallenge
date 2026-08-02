package ReRevise;

public class prefixrunningSum {
    // Time Complexity: O(n)
    // Space Complexity: O(n)
    public int[] runningSum(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        prefix[0] = nums[0];
        for (int i = 1; i < n; i++) {
            prefix[i] = prefix[i - 1] + nums[i];
        }
        return prefix;
    }

    public static void main(String[] args) {
        prefixrunningSum solution = new prefixrunningSum();
        int[] nums = {1, 2, 3, 4};
        int[] result = solution.runningSum(nums);

        System.out.println("Running sum:");
        for (int value : result) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}
