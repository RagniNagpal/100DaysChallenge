package DP;
import java.util.*;

public class Day4 {
    //LCS
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp=new int[text1.length()+1][text2.length()+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solve(0, 0, text1, text2, dp);
    }
    public static int solve(int i, int j, String text1, String text2, int[][] dp){
        if(i==text1.length() || j==text2.length()) return 0;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int pick = 0;
        if(text1.charAt(i) == text2.charAt(j)){
            return dp[i][j] =1 + solve(i+1, j+1, text1, text2, dp);}
        else{
            return dp[i][j] = Math.max(solve(i+1, j, text1, text2, dp),solve(i, j+1, text1, text2, dp));
        }
    }

    //longest palindromic subsequence
    public int longestPalindromeSubseq(String s) {
        String text2="";
        for(int i=s.length()-1;i>=0;i--){
            text2 += s.charAt(i);
        }
        return longestCommonSubsequencee(s, text2);
    }
    public int longestCommonSubsequencee(String text1, String text2) {
        int[][] dp=new int[text1.length()+1][text2.length()+1];
        for(int[] row:dp){
            Arrays.fill(row,-1);
        }
        return solvee(0, 0, text1, text2, dp);
    }
    public static int solvee(int i, int j, String text1, String text2, int[][] dp){
        if(i==text1.length() || j==text2.length()) return 0;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int pick = 0;
        if(text1.charAt(i) == text2.charAt(j)){
            return dp[i][j] =1 + solvee(i+1, j+1, text1, text2, dp);}
        else{
            return dp[i][j] = Math.max(solvee(i+1, j, text1, text2, dp),solvee(i, j+1, text1, text2, dp));
        }
    }

    //
    public static void main(String[] args) {

    }
}
