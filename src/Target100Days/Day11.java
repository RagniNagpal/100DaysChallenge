package Target100Days;

public class Day11 {
    //MCM
    static int MCM(int[] arr,int i,int j){
        int n=arr.length;
        if(i==j) return 0;
        int minCost=Integer.MAX_VALUE;
        for(int k=i;k<j;k++){
            int cost1 = MCM(arr, i, k);
            int cost2 = MCM(arr, k + 1, j);
            int mul=arr[i-1]*arr[j]*arr[k];
            int total=cost1 + cost2 + mul;
            minCost=Math.min(minCost,total);
        }
        return minCost;
    }
    static int matrixMultiplication(int arr[]) {
        // code here
        int n = arr.length;
        return MCM(arr,1,n-1);

    }

    //Max product
    public int maxProduct(int[] nums) {
        int max=nums[0];
        for(int i=0;i<nums.length;i++){
            int prod=1;
            for(int j=i;j<nums.length;j++){
                prod *= nums[j];
                max=Math.max(max,prod);
            }
        }
        return max;
    }

    //Delete Operation for Two Strings
    public static int lcs(String word1,String word2){
        int m=word1.length();
        int n=word2.length();
        int[][] dp=new int[m+1][n+1];
        for(int i=1;i<=m;i++){
            for(int j=1;j<=n;j++){
                if(word1.charAt(i-1)==word2.charAt(j-1)){
                    dp[i][j]=1+dp[i-1][j-1];
                }else{
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
    public int minDistance(String word1, String word2) {
        int m=word1.length();
        int n=word2.length();
        int len=lcs(word1,word2);
        int minD=m-len;
        int minI=n-len;
        return minD + minI;
    }

    public static void main(String[] args) {
        Day11 obj = new Day11();

        // ===== MCM =====
        int[] arr = {10, 20, 30, 40, 30};

        int mcmAns = matrixMultiplication(arr);

        System.out.println("MCM Minimum Cost: " + mcmAns);

        // ===== Max Product Subarray =====
        int[] nums = {2, 3, -2, 4};

        int maxProd = obj.maxProduct(nums);

        System.out.println("Maximum Product Subarray: " + maxProd);

        // ===== Delete Operation for Two Strings =====
        String word1 = "sea";
        String word2 = "eat";

        int operations = obj.minDistance(word1, word2);

        System.out.println("Minimum Delete Operations: " + operations);
    }
}
