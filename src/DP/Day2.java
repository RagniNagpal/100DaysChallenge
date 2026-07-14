package DP;
import java.util.*;

public class Day2 {
    //Count Square Submatrices with All Ones
    public int countSquares(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==0) continue;
                if (i > 0 && j > 0) {
                    matrix[i][j] = min(matrix[i-1][j], matrix[i][j-1], matrix[i-1][j-1]) + 1;
                }
                count += matrix[i][j];
            }
        }
        return count;
    }
    public static int min(int a,int b,int c){
        return Math.min(a,Math.min(b,c));
    }

    //unique path 2
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m=obstacleGrid.length;
        int n=obstacleGrid[0].length;
        int[][] dp=new int[m+1][n+1];
        for(int[] d:dp){
            Arrays.fill(d,-1);
        }
        return paths(0, 0, m, n, obstacleGrid, dp);
    }
    public static int paths(int i,int j,int m,int n,int[][] obstacleGrid,int[][] dp){
        if(i>=m || j>=n || obstacleGrid[i][j] == 1) return 0;
        if(i==m-1 && j==n-1) return 1;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        dp[i][j]=paths(i+1,j,m,n,obstacleGrid,dp) + paths(i,j+1,m,n,obstacleGrid,dp);
        return dp[i][j];
    }
    public static void main(String[] args) {

    }
}
