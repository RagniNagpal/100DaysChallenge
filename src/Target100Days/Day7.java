package Target100Days;
 import java.util.*;
public class Day7 {
    //count of subsets
    public static int countSub(int[] arr,int sum,int n){
        int[][] t=new int[n+1][sum+1];
        for(int i=0;i<=n;i++){
            t[i][0]=1;
        }
        for(int j=1;j<=sum;j++){
            t[0][j]=0;
        }
        for(int i=1;i<n+1;i++){
            for(int j=1;j<sum+1;j++){
                if(arr[i-1]<= j){
                    t[i][j]=t[i-1][j-arr[i-1]] + t[i-1][j];
                }else{
                    t[i][j]=t[i-1][j];
                }
            }
        }
        return t[n][sum];
    }

    //print subsets
    public static void print(int[] arr,int idx,List<Integer> list){
        if(idx==arr.length){
            System.out.println(list);
            return;
        }
        list.add(arr[idx]);
        print(arr,idx+1,list);
        list.remove(list.size()-1);
        print(arr,idx+1, list);
    }

    // Minimum Subset Sum Difference
    public static int minSubsetSumDiff(int[] arr,int n){
        int range=0;
        for(int x:arr){
            range += x;
        }
        boolean[][] dp=new boolean[n+1][range+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=true;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=range;j++){
                if(arr[i-1] <= j){
                    dp[i][j]=dp[i-1][j-arr[i-1]] || dp[i-1][j];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        int ans=Integer.MAX_VALUE;
        for(int s1=0;s1<=range/2;s1++){
            if(dp[n][s1]){
                ans=Math.min(ans,range - 2 * s1);
            }
        }
        return ans;
    }

    //knapsack 0/1 unbounded
    public static int knapUnbound(int[] arr,int[] val,int W,int n){
        int[][] t=new int[n+1][W+1];
        for(int i = 0; i <= n; i++) {
            t[i][0] = 0;
        }

        for(int j = 0; j <= W; j++) {
            t[0][j] = 0;
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=W;j++){
                if(arr[i-1] <= j){
                    t[i][j]=Math.max(val[i-1] + t[i][j-arr[i-1]],t[i-1][j]);
                }else{
                    t[i][j]=t[i-1][j];
                }
            }
        }
        return t[n][W];
    }
    public static void main(String[] args) {
        int[] arr = {1, 2, 3};

        System.out.println("Printing Subsets:");
        print(arr, 0, new ArrayList<>());

        int count =
                countSub(arr, 3, arr.length);

        System.out.println(
                "\nCount of subsets = " + count);

        int[] arr2 = {1, 6, 11, 5};

        int diff =
                minSubsetSumDiff(arr2,
                        arr2.length);

        System.out.println(
                "\nMinimum Subset Difference = "
                        + diff);

        int[] wt = {1, 3, 4, 5};
        int[] val = {1, 4, 5, 7};

        int W = 7;

        int profit =
                knapUnbound(wt,
                        val,
                        W,
                        wt.length);

        System.out.println(
                "\nUnbounded Knapsack Profit = "
                        + profit);
    }
}
