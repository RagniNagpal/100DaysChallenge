package Target100Days;

public class Day9 {

    // Minimum insertions or deletions to convert string A to B

    public static int lcs(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {

                    dp[i][j] = 1 + dp[i - 1][j - 1];

                } else {

                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    public int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        int len = lcs(word1, word2);

        int minDeletion = m - len;
        int minInsertion = n - len;

        return minDeletion + minInsertion;
    }

    // Longest Repeating Subsequence

    public static int lcsRep(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {

            for (int j = 1; j <= n; j++) {

                // i != j important condition
                if (word1.charAt(i - 1) == word2.charAt(j - 1) && i != j) {

                    dp[i][j] = 1 + dp[i - 1][j - 1];

                } else {

                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {

        // Minimum Insertions/Deletions

        Day9 obj = new Day9();

        String word1 = "heap";
        String word2 = "pea";

        int ans = obj.minDistance(word1, word2);

        System.out.println("Minimum operations = " + ans);

        // Longest Repeating Subsequence

        String str = "aabebcdd";

        int rep = lcsRep(str, str);

        System.out.println("Longest Repeating Subsequence Length = " + rep);
    }
}