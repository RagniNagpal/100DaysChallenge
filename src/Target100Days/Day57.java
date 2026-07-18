package Target100Days;
import java.util.*;

public class Day57 {
    // Minimum Falling Path Sum
    //tc O(n*m) sc o(n*m)
        public int minFallingPathSum(int[][] matrix) {

            int m = matrix.length;
            int n = matrix[0].length;

            Integer[][] dp = new Integer[m][n];

            int ans = Integer.MAX_VALUE;

            for (int j = 0; j < n; j++) {
                ans = Math.min(ans, solve(0, j, matrix, dp));
            }

            return ans;
        }

        public static int solve(int i, int j, int[][] matrix, Integer[][] dp) {

            int m = matrix.length;
            int n = matrix[0].length;

            // Out of bounds
            if (j < 0 || j >= n) {
                return (int)1e9;
            }

            // Last row
            if (i == m - 1) {
                return matrix[i][j];
            }

            // Memoization
            if (dp[i][j] != null) {
                return dp[i][j];
            }

            int downLeft = solve(i + 1, j - 1, matrix, dp);
            int down = solve(i + 1, j, matrix, dp);
            int downRight = solve(i + 1, j + 1, matrix, dp);

            dp[i][j] = matrix[i][j] + Math.min(downLeft, Math.min(down, downRight));

            return dp[i][j];
        }

        //min path sum
    //
        public int minPathSum(int[][] grid) {
            int m=grid.length;
            int n=grid[0].length;
            int[][] dp=new int[m][n];
            for(int[] row:dp){
                Arrays.fill(row,-1);
            }
            return solve(0,0,grid,dp);
        }
    public static int solve(int i,int j,int[][] grid,int[][] dp){
        int m=grid.length;
        int n=grid[0].length;
        if(i==m-1 && j==n-1){
            return grid[i][j];
        }
        if(i>=m || j>=n){
            return (int)1e9;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int down=solve(i+1,j,grid,dp);
        int right=solve(i,j+1,grid,dp);
        return dp[i][j] =grid[i][j] + Math.min(down, right);
    }

    //unique path 2
    //
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return paths(0, 0, m, n, obstacleGrid, dp);
    }

    public static int paths(int i, int j, int m, int n,
                            int[][] obstacleGrid, int[][] dp) {

        if (i >= m || j >= n) {
            return 0;
        }

        if (obstacleGrid[i][j] == 1) {
            return 0;
        }

        if (i == m - 1 && j == n - 1) {
            return 1;
        }

        if (dp[i][j] != -1) {
            return dp[i][j];
        }

        int down = paths(i + 1, j, m, n, obstacleGrid, dp);
        int right = paths(i, j + 1, m, n, obstacleGrid, dp);

        return dp[i][j] = down + right;
    }

    //unique path 1
    //
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for(int[] row : dp){
            Arrays.fill(row,-1);
        }
        return paths(0,0,m,n,dp);
    }
    public static int paths(int i,int j,int m,int n,int[][] dp){

        if(i==m-1 && j==n-1){
            return 1;
        }
        if(i>=m || j>=n){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int down=paths(i+1,j,m,n,dp);
        int right=paths(i,j+1,m,n,dp);
        dp[i][j]=down+right;
        return dp[i][j];
    }

    //word search
    public static void main(String[] args) {

    }
}
