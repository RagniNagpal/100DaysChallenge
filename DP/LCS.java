package DP;

import java.util.*;

public class LCS {

    public static int[][] LCS(String text1, String text2) {

        int m = text1.length();
        int n = text2.length();

        int[][] dp = new int[m + 1][n + 1];

        // Build DP Table
        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {

                    dp[i][j] = 1 + dp[i - 1][j - 1];

                } else {

                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp;
    }

    public static void printLCS(String text1, String text2, int[][] dp) {

        int i = text1.length();
        int j = text2.length();

        StringBuilder sb = new StringBuilder();

        while (i > 0 && j > 0) {

            // Characters Match
            if (text1.charAt(i - 1) == text2.charAt(j - 1)) {

                sb.append(text1.charAt(i - 1));
                i--;
                j--;
            }

            // Move Up
            else if (dp[i - 1][j] > dp[i][j - 1]) {

                i--;
            }

            // Move Left
            else {

                j--;
            }
        }

        System.out.println("LCS = " + sb.reverse().toString());
    }

    public static void main(String[] args) {

        String text1 = "ABCBDAB";
        String text2 = "BDCAB";

        int[][] dp = LCS(text1, text2);

        System.out.println("Length = " + dp[text1.length()][text2.length()]);

        printLCS(text1, text2, dp);
    }
}