package DP;

import java.util.Arrays;

class Solution {

    public int solve(int i, int j, String word1, String word2, int[][] dp) {

        if (i == word1.length())
            return word2.length() - j;

        if (j == word2.length())
            return word1.length() - i;

        if (dp[i][j] != -1)
            return dp[i][j];

        // Characters match
        if (word1.charAt(i) == word2.charAt(j)) {
            return dp[i][j] = solve(i + 1, j + 1, word1, word2, dp);
        }

        // Insert
        int insert = 1 + solve(i, j + 1, word1, word2, dp);

        // Delete
        int delete = 1 + solve(i + 1, j, word1, word2, dp);

        // Replace
        int replace = 1 + solve(i + 1, j + 1, word1, word2, dp);

        return dp[i][j] = Math.min(insert,
                Math.min(delete, replace));
    }

    public int minDistance(String word1, String word2) {

        int[][] dp = new int[word1.length()][word2.length()];

        for (int[] row : dp)
            Arrays.fill(row, -1);

        return solve(0, 0, word1, word2, dp);
    }
}
