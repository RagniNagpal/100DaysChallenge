package Target100Days;
import java.util.*;

public class Day30 {
    //without extra space
    //tc O(m+n) sc o(1)
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i=m-1;
        int j=n-1;
        int k=m+n-1;
        while(i>=0 && j>=0){
            if(nums1[i] > nums2[j]){
                nums1[k]=nums1[i];
                i--;
            }else{
                nums1[k]=nums2[j];
                j--;
            }
            k--;
        }
        while(j>=0){
            nums1[k]=nums2[j];
            j--;
            k--;
        }
    }

    //search in 2d matrix
    public boolean searchMatrix(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j]==target){
                    return true;
                }
            }
        }
        return false;
    }

    //Time Complexity: O(log(NxM)), sc O(1)
    public boolean searchMatrix2(int[][] matrix, int target) {
        int m=matrix.length;
        int n=matrix[0].length;
        int low = 0;
        int high = m * n - 1;
        while(low <= high){
            int mid = low + (high - low)/2;
            int row=mid/n;
            int col=mid%n;
            if(matrix[row][col]==target){
                return true;
            }
            if(matrix[row][col] < target){
                low=mid+1;
            }else{
                high=mid-1;
            }
        }
        return false;
    }

    // Subarray with given sum4
    //TC = O(n²)
    //SC = O(1)
    public int subarraySum2(int[] nums, int k) {
        int n=nums.length;
        int sum=0;
        int count=0;
        for(int i=0;i<n;i++){
            sum=0;
            for(int j=i;j<n;j++){
                sum += nums[j];
                if(sum==k){
                    count++;
                }
            }
        }
        return count;
    }

    //Tc sc O(n)
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int prefixSum=0;
        int count=0;
        for(int num : nums){
            prefixSum += num;
            if(map.containsKey(prefixSum-k)){
                count += map.get(prefixSum-k);
            }
            map.put(prefixSum,map.getOrDefault(prefixSum,0)+1);
        }
        return count;
    }

    //largest subbaray with sum k

    // TC = O(n)
// SC = O(n)

    public int longestSubarrayWithSumK(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int prefixSum = 0;
        int maxLen = 0;

        // prefix sum 0 occurs before array starts
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {

            prefixSum += nums[i];

            // If there exists an earlier prefix = prefixSum - k
            if (map.containsKey(prefixSum - k)) {

                int len = i - map.get(prefixSum - k);
                maxLen = Math.max(maxLen, len);
            }

            // Store only first occurrence
            if (!map.containsKey(prefixSum)) {
                map.put(prefixSum, i);
            }
        }

        return maxLen;
    }

    // TC = O(n)
// SC = O(1)

    public int longestSubarrayWithSumK2(int[] nums, int k) {

        int left = 0;
        int sum = 0;
        int maxLen = 0;

        for (int right = 0; right < nums.length; right++) {

            sum += nums[right];

            while (sum > k) {
                sum -= nums[left];
                left++;
            }

            if (sum == k) {
                maxLen = Math.max(maxLen, right - left + 1);
            }
        }

        return maxLen;
    }

    //TC = O(N)
    //
    //SC = O(H)
    //
    //where H = height of tree
    //
    //Worst Case: O(N)
    //Balanced Tree: O(log N)
    class Solution {
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if(p==null && q==null){
                return true; }
            if(p==null || q==null) return false;
            if (p.val != q.val) {
                return false; }
            return isSameTree(p.left, q.left) && isSameTree(p.right, q.right); } }

    public static void main(String[] args) {

    }
}
