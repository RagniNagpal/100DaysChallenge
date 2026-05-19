package Target100Days;

public class Day6 {

    // 0/1 Knapsack - Tabulation
    public static int knapsack(int[] val, int[] wt, int w, int n) {

        int[][] t = new int[n + 1][w + 1];

        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= w; j++) {

                if (wt[i - 1] <= j) {

                    t[i][j] = Math.max(
                            val[i - 1] + t[i - 1][j - wt[i - 1]],
                            t[i - 1][j]
                    );
                }
                else {

                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[n][w];
    }

    // Equal Sum Partition
    public static boolean isPartition(int[] nums) {

        int n = nums.length;

        int sum = 0;

        // total sum
        for (int x : nums) {
            sum += x;
        }

        // odd sum impossible
        if (sum % 2 != 0) {
            return false;
        }

        int target = sum / 2;

        boolean[][] t = new boolean[n + 1][target + 1];

        // sum = 0 possible always
        for (int i = 0; i <= n; i++) {
            t[i][0] = true;
        }

        // no items => false
        for (int j = 1; j <= target; j++) {
            t[0][j] = false;
        }

        // subset sum DP
        for (int i = 1; i <= n; i++) {

            for (int j = 1; j <= target; j++) {

                // can include current element
                if (nums[i - 1] <= j) {

                    t[i][j] =
                            t[i - 1][j - nums[i - 1]]
                                    || t[i - 1][j];
                }

                // cannot include
                else {

                    t[i][j] = t[i - 1][j];
                }
            }
        }

        return t[n][target];
    }

    public static void main(String[] args) {

        int[] nums = {1, 5, 11, 5};

        System.out.println(isPartition(nums));
    }
}