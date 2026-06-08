package Target100Days;

public class Day26 {
    //max height
    // tc O(n) sc O(h)
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        int left=maxDepth(root.left);
        int right=maxDepth(root.right);
        return 1+Math.max(left,right);
    }

    //Rod cutting
    // tc sc O(n²)
    public int cutRod(int[] price) {
        // code here
        int n=price.length;
        int[] length=new int[n];
        for(int i=0;i<n;i++){
            length[i] = i + 1;
        }

        int[][] dp = new int[n+1][n+1];
        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(length[i-1] <=j){
                    dp[i][j]=Math.max(price[i-1] + dp[i][j-length[i-1]],dp[i-1][j]);
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }
        return dp[n][n];
    }

    //compare version no
    // tc sc O(n + m)
    public int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        for(int i=0;i<Math.max(v1.length,v2.length);i++){
            int num1=i < v1.length ? Integer.parseInt(v1[i]) : 0;
            int num2=i < v2.length ? Integer.parseInt(v2[i]) : 0;
            if(num1 < num2){
                return -1;
            }
            if(num1>num2){
                return 1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {

    }
}
