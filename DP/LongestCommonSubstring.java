package DP;

public class LongestCommonSubstring {

    public static int LCSubstring(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        int max = 0;

        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {

                    dp[i][j] = 1 + dp[i - 1][j - 1];

                    max = Math.max(max, dp[i][j]);

                } else {

                    dp[i][j] = 0;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {

        String text1 = "abcdxyz";
        String text2 = "xyzabcd";

        int ans = LCSubstring(text1, text2);

        System.out.println("Longest Common Substring Length = " + ans);
    }
}