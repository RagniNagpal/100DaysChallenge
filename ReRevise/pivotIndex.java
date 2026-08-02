package ReRevise;

public class pivotIndex {
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int leftSum = 0;
        int total = 0;

        for (int num : nums) {
            total += num;
        }

        for (int i = 0; i < n; i++) {
            int rightSum = total - leftSum - nums[i];
            if (leftSum == rightSum) {
                return i;
            }
            leftSum += nums[i];
        }
        return -1;
    }

    public static void main(String[] args) {
        pivotIndex solution = new pivotIndex();
        int[] nums = {1, 7, 3, 6, 5, 6};
        System.out.println("Pivot index: " + solution.pivotIndex(nums));
    }
}